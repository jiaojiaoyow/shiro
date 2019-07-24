package com.example.demo.Realm;

import com.example.demo.Model.SysPermission;
import com.example.demo.Model.SysRole;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.RoleService;
import com.example.demo.Service.UserInfoService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
        List<SysRole> userRoles=userInfoService.selectUserRole(userInfo.getUid());
        if(userRoles==null){
            System.out.println("空");
        }
        for(SysRole role:userRoles){
            authorizationInfo.addRole(role.getRole());
            List<SysPermission> rolePermissions=roleService.selectRolePermission(role.getRoleId());
            for(SysPermission p:rolePermissions){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.selectByUsername(username);
        //插入成功就放入缓存
        redisTemplate.opsForValue().set(userInfo.getUid(),userInfo);
        //这里是设置键的有效日期,不设置就是永久的token
//        redisTemplate.expire(record.getToken(), 123L, TimeUnit.SECONDS);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}