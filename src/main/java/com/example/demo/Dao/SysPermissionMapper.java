package com.example.demo.Dao;

import com.example.demo.Model.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}