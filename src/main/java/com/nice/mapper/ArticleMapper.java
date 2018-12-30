package com.nice.mapper;

import com.nice.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    void addArticle(Article article);
}
