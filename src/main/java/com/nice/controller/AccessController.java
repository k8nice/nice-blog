package com.nice.controller;

import com.google.gson.Gson;
import com.nice.model.Access;
import com.nice.model.User;
import com.nice.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nice
 */
@Controller
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @ResponseBody
    @GetMapping("/add")
    public void addAccess(Long articleId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("USER");
        Date date = new Date();
        Access access = new Access();
        access.setAccessTime(date);
        try {
            access.setAccessIP(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
            access.setArticleId(articleId);
        access.setUserId(user.getUserId());
        accessService.addAccess(access);
    }

    @ResponseBody
    @GetMapping("/count")
    public String queryAccessCount(Long articleId){
        Access access = new Access();
        access.setArticleId(articleId);
      Long dayAccessCount =   accessService.dayAccess(access);
        Long weekAccessCount =    accessService.weekAccess(access);
        Long monthAccessCount =   accessService.monthAccess(access);
        Long yearAccessCount =  accessService.yearAccess(access);
        System.out.println(dayAccessCount);
        Map map = new HashMap();
        map.put("yearAccessCount",yearAccessCount);
        map.put("monthAccessCount",monthAccessCount);
        map.put("weekAccessCount",weekAccessCount);
        map.put("dayAccessCount",dayAccessCount);
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
