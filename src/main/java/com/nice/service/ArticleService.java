package com.nice.service;

import com.nice.model.Article;

import java.util.List;

/**
 * @author nice
 */
public interface ArticleService {
    /**
     * 添加一篇文章
     * @param article
     */
    void addArticle(Article article);

    /**
     * 根据每页的文章个数，和需要查询的页数获取文章列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Article> queryArticleAll(Long pageNum,Long pageSize);

    /**
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Article> queryArticleByUserId(Long userId,Long pageNum,Long pageSize);
    void deleteArticleByArticleId(Article article);
    Long queryUserArticlePages(Long userId);
    Long queryAllArticlePages();
    Article queryArticleByArticleTitle(Long articleId);
    Long queryCtrByArticleId(Long articleId);
    Long updateCtr(Long articleId,Long ctr);
    List<String> queryArticleTypeAll();
    List<Article> queryArticleByArticleType(String articleType);
//    Long queryArticleIdByArticleTitle(String articleTitle);
}
