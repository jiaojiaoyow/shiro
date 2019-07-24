package com.example.demo.Dao;

import com.example.demo.Model.SysRolePermissionKey;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(SysRolePermissionKey key);

    int insert(SysRolePermissionKey record);

    int insertSelective(SysRolePermissionKey record);
}