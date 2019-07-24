package com.example.demo.Model;

import java.util.List;

public class SysUserRoleKey {
    private String roleId;

    private String uid;

    private SysRole role;

    private UserInfo userInfos;

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public UserInfo getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(UserInfo userInfos) {
        this.userInfos = userInfos;
    }



    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}