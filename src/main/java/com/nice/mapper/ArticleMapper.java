package com.nice.mapper;

import com.nice.model.Article;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author nice
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 添加文章
     * @param article
     */
    void addArticle(Article article);

    /**
     * 查询全部文章
     * @return List<Article>
     */
    List<Article> queryArticleAll();

    /**
     * 根据用户id查询该用户下全部文章
     * @param userId
     * @return
     */
    List<Article> queryArticleByUserId(Long userId);

    /**
     * 根据文章id和用户id删除文章
     * @param article
     */
    void deleteArticleByUserIdAndArticleId(Article article);
}
