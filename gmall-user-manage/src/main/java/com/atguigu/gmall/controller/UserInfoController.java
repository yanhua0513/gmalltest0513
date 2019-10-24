package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public List<UserInfo> getAll(){

        return userService.getAll();
    }

    @RequestMapping("getuser")
    public List<UserInfo> getuser(UserInfo userInfo){
        return userService.getUser(userInfo);
    }

    @RequestMapping("getuserinfo")
    public List<UserInfo> getUserInfo(UserInfo userInfo){

        return userService.getUserInFo(userInfo);
    }

    @RequestMapping("getOne")
    public UserInfo getOne(UserInfo userInfo){

        return userService.getOne(userInfo);
    }

    @RequestMapping("adduser")
    public void addUser(UserInfo userInfo){

        userService.adduser(userInfo);
    }

    @RequestMapping("deluser")
    public void delUser(UserInfo userInfo){

        userService.deluser(userInfo);
    }

    @RequestMapping("updateuser")
    public void updateUser(UserInfo userInfo){

        userService.updateUser(userInfo);
    }

}
