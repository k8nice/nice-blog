package com.nice.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.nice.model.Article;
import com.nice.model.User;
import com.nice.service.ArticleService;
import com.nice.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.*;


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
        return "/article/add";
    }

    /**
     * 显示全部文章
     * @return
     */
    @GetMapping("/list/all")
    public String list(HttpServletRequest request,Long pagesNum,Long pagesSize){
      //  User user = (User) request.getSession().getAttribute("USER");
     //   Long allPages = articleService.queryUserArticlePages(user.getUserId());
        List<Article> articleList = articleService.queryArticleAll(pagesNum,pagesSize);
        Map<Object,Object> map = new HashMap<Object, Object>();
     //   map.put("allPages",allPages);
        map.put("articleList",articleList);
        Gson gson = new Gson();
        return gson.toJson(map);
    //    return "article/allList";
    }



    /**
     * 接收每页的页数，和要查看的页数，返回数据和数量
     * @param pagesNum
     * @param pagesSize
     * @param request
     * @return
     */
    @GetMapping("/user/pages")
    @ResponseBody
    public String queryArticleByPages(Long pagesNum,Long pagesSize,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("USER");
        Long allPages = articleService.queryUserArticlePages(user.getUserId());
        List<Article> articleList = articleService.queryArticleByUserId(user.getUserId(),pagesNum,pagesSize);
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("allPages",allPages);
        map.put("articleList",articleList);
        Gson gson = new Gson();
        return gson.toJson(map);
    }


    @GetMapping("/user/list")
    public String queryUserArticleList(){
        return "article/myList";
    }


    /**
     * 根据文章id删除文章
     * @param articleId
     * @param request
     * @return
     */
    @GetMapping("/delete/{articleId}")
    public String delete(@PathVariable("articleId") Long articleId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("USER");
        Article article = new Article();
        article.setUserId(user.getUserId());
        article.setArticleId(articleId);
        articleService.deleteArticleByUserIdAndArticleId(article);
        return "redirect:../../user/main";
    }

    @GetMapping("/query/exist/content/{articleId}")
    public String queryExistArticleContent(@PathVariable("articleId") Long articleId,HttpServletRequest request){
        Article article = articleService.queryArticleByArticleTitle(articleId);
        request.setAttribute("article",article);
        return "article/articleContent";
    }



}
