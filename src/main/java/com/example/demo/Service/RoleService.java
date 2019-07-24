package com.example.demo.Service;

import com.example.demo.Model.SysPermission;

import java.util.List;

public interface RoleService {
    List<SysPermission> selectRolePermission(String roleid);
}
