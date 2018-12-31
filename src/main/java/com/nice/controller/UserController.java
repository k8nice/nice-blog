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


import javax.servlet.http.HttpServletRequest;

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
     * 注册提交
     * @param user
     */
    @PostMapping("/register")
    public String registerSubmit(User user,HttpServletRequest request) {
        String resultName = userService.queryUserNameByUserName(user.getUserName());
        if (resultName == null) {
            userService.addUser(user);
            Long userId = userService.queryUserIdByUserName(user.getUserName());
            request.getSession().setAttribute("USER_ID", userId);
            return "redirect:main";
        } else {
            return "redirect:register";
        }
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
    @PostMapping("/login")
    public String loginSubmit(String userName, String userPassword, HttpServletRequest request) {
        if (userService.isLogin(userName,userPassword)){
            Long userId = userService.queryUserIdByUserName(userName);
            request.getSession().setAttribute("USER_ID",userId);
            return "redirect:main";
        }else {
            return "error";
        }
    }

    /**
     * 跳转主页面
     * @param request
     * @return
     */
    @GetMapping("/main")
    public String main(HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("USER_ID");
        String userName = userService.queryUserNameByUserId(userId);
        System.out.println(userName);
        request.setAttribute("userName",userName);
        return  "main";
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
