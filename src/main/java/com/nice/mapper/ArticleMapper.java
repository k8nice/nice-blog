package com.nice.mapper;

import com.nice.model.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nice
 */
@Mapper
public interface ArticleMapper {
    void addArticle(Article article);
}
