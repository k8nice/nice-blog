package com.nice.service.impl;

import com.nice.mapper.ArticleMapper;
import com.nice.model.Article;
import com.nice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
