package com.nice.controller;

import com.nice.model.User;
import com.nice.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.UUID;

/**
 * @author nice
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 判断用户是否存在
     *
     * @param userName
     * @return
     */
    @ResponseBody
    @PostMapping("/isExist")
    public String isUserExist(String userName) {
        String resultName = userService.queryUserNameByUserName(userName);
        if (resultName == null) {
            return "用户名不存在";
        } else {
            return "用户名已存在";
        }
    }

    /**
     * 登陆验证
     * @param user
     */
    @ResponseBody
    @PostMapping("/register")
    public void registerSubmit(User user) {
        //以下为md5加密,注册的时候先加密一遍
        String salt = String.valueOf(UUID.randomUUID());
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        String md5Password = String.valueOf(new SimpleHash(hashAlgorithmName,user.getUserPassword(),salt,hashIterations));
        //------------------
        userService.addUser(user);
    }

    /**
     * 登陆页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登陆提交
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public String loginSubmit(String userName, String userPassword) {
        //登录的时候再次加密密码，跟数据库中已加密的密码做比较，如果相同，则登陆成功
        User user = userService.queryUserPasswordAndSaltByUserName(userName);
        String salt = user.getUserSalt();
        String hashAlgorithmName = "MD5";
        int hashIterations = 1024;
        String md5Password = String.valueOf(new SimpleHash(hashAlgorithmName,userPassword,salt,hashIterations));
        //数据库中查询的密码
        String resultUserPassword = user.getUserPassword();
       if (md5Password.equals(resultUserPassword)){
           return "success";
       }
       else {
           return "error";
       }
    }

    /**
     * 注册页面
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }


}
