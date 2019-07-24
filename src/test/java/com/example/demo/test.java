package com.example.demo;

import com.example.demo.Model.SysPermission;
import com.example.demo.Model.SysRole;
import com.example.demo.Service.RoleService;
import com.example.demo.Service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Permission;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleService roleService;

    @Test
    public void test(){
        List<SysRole> roles=userInfoService.selectUserRole("1");
        List<SysPermission> permissions=roleService.selectRolePermission("1");
        System.out.println("1");
    }
}
