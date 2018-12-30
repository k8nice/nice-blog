package com.nice.controller;

import com.nice.model.Article;
import com.nice.service.ArticleService;
import com.nice.service.UserService;
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
     * @param articleTitle
     * @param articleType
     * @param articleContent
     */
    @PostMapping("/add")
    public void addArticle(String articleTitle, String articleType, String articleContent, Long userId, HttpServletRequest request){
        Long sessionUserId = (Long) request.getSession().getAttribute("user_id");
        if (sessionUserId.equals(userId)){
            //
        }
       // Long userId = userService.queryUserIdByUserName(userName);
        Article article = new Article();
        article.setArticleTitle(articleTitle);
        article.setArticleType(articleType);
        article.setArticleContent(articleContent);
        article.setUserId(userId);
        articleService.addArticle(article);
    }

    /**
     * 跳转到添加文章页面
     */
    @GetMapping("/add")
    public String add(){
        return "/article/add";
    }

}
