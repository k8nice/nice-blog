package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.ArticleMapper;
import com.nice.model.Article;
import com.nice.model.User;
import com.nice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nice
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加文章
     * @param article
     */
    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public List<Article> queryArticleAll(Long pageNum,Long pageSize) {
        PageInfo<Article> pageInfo = PageHelper.startPage(Math.toIntExact(pageNum),Math.toIntExact(pageSize)).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleAll());
        return pageInfo.getList();
    }

    @Override
    public List<Article> queryArticleByUserId(Long userId,Long pageNum,Long pageSize){
        PageInfo<Article> pageInfo = PageHelper.startPage(Math.toIntExact(pageNum),10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleByUserId(userId));
        return pageInfo.getList();
    }

    @Override
    public void deleteArticleByUserIdAndArticleId(Article article) {
        articleMapper.deleteArticleByUserIdAndArticleId(article);
    }

    @Override
    public Long queryUserArticlePages(Long userId) {
        PageInfo<Article> pageInfo1 = new PageInfo<Article>(this.articleMapper.queryArticleByUserId(userId));
        Long pages = pageInfo1.getTotal();
        return pages;
    }

    @Override
    public Article queryArticleByArticleTitle(Long articleId) {
        return articleMapper.queryArticleByArticleId(articleId);
    }
}
