package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.mapper.UserInfoMapper;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> getUser(UserInfo userInfo) {

        return userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> getUserInFo(UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        //第一个参数是表示实体类属性，并非表中字段，第二个数表示给属性赋值
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public UserInfo getOne(UserInfo userInfo) {
        return  userInfoMapper.selectOne(userInfo);
    }

    @Override
    public void adduser(UserInfo userInfo) {

        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void deluser(UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andGreaterThan("id",userInfo.getId());

        userInfoMapper.deleteByExample(example);

    }

    @Override
    public void updateUser(UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userLevel",userInfo.getUserLevel());

//        userInfoMapper.updateByExample(userInfo,example);缺少的部分不能自动补全
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }
}
