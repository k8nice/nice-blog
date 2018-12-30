package com.nice.controller;

import com.nice.model.User;
import com.nice.service.UserService;
import com.nice.util.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
        String resultName = userService.queryUserNameAll(userName);
        if (resultName == null) {
            return "用户名不存在";
        } else {
            return "用户名已存在";
        }
    }

    /**
     * 登陆提交
     *
     * @param userName
     * @param userPassword
     * @param userRealName
     * @param userIdCard
     * @param userEmail
     * @param userPhone
     * @param userAddress
     */
    @ResponseBody
    @PostMapping("/register")
    public void registerSubmit(String userName, String userPassword
            , String userRealName, String userIdCard, String userEmail, String userPhone, String userAddress) {
        //  userPassword = MD5S
        try {
            userPassword = Md5SaltTool.getEncryptedPwd(userPassword);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserRealName(userRealName);
        user.setUserIdCard(userIdCard);
        user.setUserEmail(userEmail);
        user.setUserPhone(userPhone);
        user.setUserAddress(userAddress);
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
     * 登陆
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public String loginSubmit(String userName, String userPassword) {
        String resultUserPassword = userService.queryUserPasswordByUser(userName);
        if (null != resultUserPassword) {
            try {
                if (Md5SaltTool.validPassword(userPassword, resultUserPassword)) {
                    return "success";
                }
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "error";
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
