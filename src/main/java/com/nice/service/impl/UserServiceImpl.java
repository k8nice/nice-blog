package com.nice.service.impl;

import com.nice.mapper.UserMapper;
import com.nice.model.User;
import com.nice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部用户
     *
     * @param userName
     * @return
     */
    @Override
    public String queryUserNameAll(String userName) {
        return userMapper.queryUserNameAll(userName);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    /**
     * 根据用户名查询密码
     *
     * @param userName
     * @return
     */
    @Override
    public String queryUserPasswordByUser(String userName) {
        return userMapper.queryUserPasswordByUser(userName);
    }

    @Override
    public String queryUserSaltByUserName(String userName) {
        return userMapper.queryUserSaltByUserName(userName);
    }
}
