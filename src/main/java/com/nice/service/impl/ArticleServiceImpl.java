package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.ArticleMapper;
import com.nice.model.Article;
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
    public List<Article> queryArticleAll() {
        List<Article> list = articleMapper.queryArticleAll();
        final PageInfo<Article> pageInfo = PageHelper.startPage(1,10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleAll());
        return null;
    }

    @Override
    public List<Article> queryArticleByUserId(Long userId) {
        final PageInfo<Article> pageInfo = PageHelper.startPage(1,10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.articleMapper.queryArticleByUserId(userId));
        return pageInfo.getList();
    }

    @Override
    public void deleteArticleByUserIdAndArticleId(Article article) {
        articleMapper.deleteArticleByUserIdAndArticleId(article);
    }
}
