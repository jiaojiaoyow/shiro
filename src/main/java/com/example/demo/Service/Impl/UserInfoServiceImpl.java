package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserInfoMapper;
import com.example.demo.Model.SysRole;
import com.example.demo.Model.UserInfo;
import com.example.demo.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectByUsername(String username) {
        return this.userInfoMapper.selectByUsername(username);
    }

    @Override
    public List<SysRole> selectUserRole(String uid) {
        return this.userInfoMapper.selectUserRole(uid);
    }


}
