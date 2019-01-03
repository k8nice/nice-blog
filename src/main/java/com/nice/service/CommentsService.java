package com.nice.service;

import com.nice.model.Article;

public interface CommentsService {
    Article queryArticleByArticleId(Long articleId,Long pageNum,Long pageSize);
}
