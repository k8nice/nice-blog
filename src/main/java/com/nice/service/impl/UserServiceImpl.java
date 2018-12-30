package com.nice.service.impl;

import com.nice.mapper.UserMapper;
import com.nice.model.User;
import com.nice.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author nice
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    @Override
    public String queryUserNameByUserName(String userName) {
        return userMapper.queryUserNameByUserName(userName);
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public String addUser(User user,HttpServletRequest request) {
        String salt = String.valueOf(UUID.randomUUID());
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        String md5Password = String.valueOf(new SimpleHash(hashAlgorithmName,user.getUserPassword(),salt,hashIterations));
        user.setUserPassword(md5Password);
        user.setUserSalt(salt);
        userMapper.addUser(user);
        Long userId = userMapper.queryUserIdByUserName(user.getUserName());
        request.getSession().setAttribute("USER_ID",userId);
        return "redirect:main";
    }

    /**
     * 根据用户名查出salt和密码
     * @param userName
     * @return
     */
    @Override
    public User queryUserPasswordAndSaltByUserName(String userName) {
        return userMapper.queryUserPasswordAndSaltByUserName(userName);
    }


    @Override
    public Long queryUserIdByUserName(String userName) {
        return userMapper.queryUserIdByUserName(userName);
    }

    @Override
    public String queryUserNameByUserId(Long userId) {
        String userName = userMapper.queryUserNameByUserId(userId);
        return userName;
    }

    @Override
    public String isLogin(String userName, String userPassword, HttpServletRequest request) {
        User user = userMapper.queryUserPasswordAndSaltByUserName(userName);
        Long userId = userMapper.queryUserIdByUserName(userName);
        System.out.println(userId);
        request.getSession().setAttribute("USER_ID",userId);
        String salt = user.getUserSalt();
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        String md5Password = String.valueOf(new SimpleHash(hashAlgorithmName,userPassword,salt,hashIterations));
        //数据库中查询的密码
        String resultUserPassword = user.getUserPassword();
        if (md5Password.equals(resultUserPassword)){
            return "redirect:main";
        }
        else {
            return "error";
        }
    }


}
