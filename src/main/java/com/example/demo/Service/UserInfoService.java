package com.example.demo.Service;

import com.example.demo.Dao.UserInfoMapper;
import com.example.demo.Model.SysRole;
import com.example.demo.Model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserInfoService {

    UserInfo selectByUsername(String username);

    List<SysRole> selectUserRole(String uid);

}
