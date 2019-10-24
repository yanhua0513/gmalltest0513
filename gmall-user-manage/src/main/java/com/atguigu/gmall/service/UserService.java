package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getAll();

    List<UserInfo> getUser(UserInfo userInfo);

    List<UserInfo> getUserInFo(UserInfo userInfo);

    UserInfo getOne(UserInfo userInfo);

    void adduser(UserInfo userInfo);

    void deluser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);
}
