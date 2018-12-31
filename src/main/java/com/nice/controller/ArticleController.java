package com.nice.controller;

import com.nice.model.Article;
import com.nice.service.ArticleService;
import com.nice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


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
        article.setArticleCreateDate(new Date());
        article.setArticleUpdateDate(new Date());
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


    @GetMapping("/list/all")
    public String list(){
        return "article/allList";
    }

    @GetMapping("/list/user")
    public String userArticleList(HttpServletRequest request){
        Long userId = (Long) request.getSession().getAttribute("USER_ID");
        List<Article> list = articleService.queryArticleByUserId(userId);
        request.setAttribute("articleList",list);
        return "/article/myList";
    }

    @PostMapping("/delete")
    public void delete(Article article){
        articleService.deleteArticleByUserIdAndArticleId(article);
    }

}
