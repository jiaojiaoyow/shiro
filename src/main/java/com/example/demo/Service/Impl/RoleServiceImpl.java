package com.example.demo.Service.Impl;

import com.example.demo.Dao.SysRoleMapper;
import com.example.demo.Model.SysPermission;
import com.example.demo.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysPermission> selectRolePermission(String roleid) {
        return this.sysRoleMapper.selectRolePermission(roleid);
    }
}
