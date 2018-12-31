package com.nice.service;

import com.nice.model.Article;

import java.util.List;

/**
 * @author nice
 */
public interface ArticleService {
    void addArticle(Article article);
    List<Article> queryArticleAll();
    List<Article> queryArticleByUserId(Long userId);
    void deleteArticleByUserIdAndArticleId(Article article);
}
