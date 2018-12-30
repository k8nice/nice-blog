package com.nice.controller;

import com.nice.model.Article;
import com.nice.service.ArticleService;
import com.nice.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
@RequestMapping("/article")
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    /**
     * 添加一篇文章
     */
    @PostMapping("/add")
    public void addArticle(Article article, HttpServletRequest request){
        Long sessionUserId = (Long) request.getSession().getAttribute("USER_ID");
        article.setUserId(sessionUserId) ;
        articleService.addArticle(article);
    }

    /**
     * 跳转到添加文章页面
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("USER_ID"));
        return "/article/add";
    }

}
