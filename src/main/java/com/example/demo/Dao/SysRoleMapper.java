package com.example.demo.Dao;

import com.example.demo.Model.SysPermission;
import com.example.demo.Model.SysRole;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysPermission> selectRolePermission(String roleid);
}