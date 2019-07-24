package com.example.demo.Model;

import java.util.List;

public class SysRole {
    private String roleId;

    private Integer available;

    private String description;

    private String role;

    private List<SysRolePermissionKey> permissions;

    public List<SysRolePermissionKey> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysRolePermissionKey> permissions) {
        this.permissions = permissions;
    }


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}