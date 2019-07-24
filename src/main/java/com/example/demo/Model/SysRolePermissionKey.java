package com.example.demo.Model;

import java.util.List;

public class SysRolePermissionKey {
    private String permissionId;

    private String roleId;

   private SysRole sysRole;

   private SysPermission sysPermission;

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public void setSysPermission(SysPermission sysPermission) {
        this.sysPermission = sysPermission;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}