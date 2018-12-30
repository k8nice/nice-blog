package com.nice.controller;

import com.nice.model.Article;
import com.nice.service.ArticleService;
import com.nice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @PostMapping("/add")
    public String addArticle(String articleTitle, String articleType, String articleContent,String userName){
        Long userId = userService.queryUserIdByUserName(userName);
        Article article = new Article();
        article.setArticleTitle(articleTitle);
        article.setArticleType(articleType);
        article.setArticleContent(articleContent);
        article.setUserId(userId);
        articleService.addArticle(article);
        return "/article/list";
    }
}
