package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.nice.model.Article;
import com.nice.model.Comments;
import com.nice.service.CommentsService;

import java.util.List;

public class CommentsServiceImpl implements CommentsService {
    @Override
    public Article queryArticleByArticleId(Long articleId,Long pageNum,Long pageSize) {
     //   List<Comments> commentsList = PageHelper.startPage(Math.toIntExact(pageNum),Math.toIntExact(pageSize)).setOrderBy("")
        return null;
    }
}
