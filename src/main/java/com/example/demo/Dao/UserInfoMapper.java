package com.example.demo.Dao;

import com.example.demo.Model.SysRole;
import com.example.demo.Model.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByUsername(String username);

    List<SysRole> selectUserRole(String uid);
}