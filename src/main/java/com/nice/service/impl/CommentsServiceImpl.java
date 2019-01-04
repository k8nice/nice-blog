package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.CommentsMapper;
import com.nice.model.Article;
import com.nice.model.Comments;
import com.nice.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author nice
 */
@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

//    @Override
//    public Article queryArticleByArticleId(Long articleId,Long pageNum,Long pageSize) {
//     //   List<Comments> commentsList = PageHelper.startPage(Math.toIntExact(pageNum),Math.toIntExact(pageSize)).setOrderBy("")
//        return null;
//    }

    @Override
    public void addComments(Comments comments) {
        commentsMapper.addComments(comments);
    }

    @Override
    public List<Comments> queryCommentsByArticleId(Long articleId,Long pageNum) {
        PageInfo<Comments> pageInfo = PageHelper.startPage(Math.toIntExact(pageNum),10).setOrderBy("article_id desc").doSelectPageInfo(() -> this.commentsMapper.queryCommentsByArticleId(articleId));
        return pageInfo.getList();
    }

    @Override
    public Long queryCommentsPagesByArticleId(Long articleId) {
        PageInfo<Comments> pageInfo1 = new PageInfo<Comments>(this.commentsMapper.queryCommentsByArticleId(articleId));
        Long total = pageInfo1.getTotal();
        return total;
    }

    @Override
    public void deleteComments(Long commentsId) {
        commentsMapper.deleteComments(commentsId);
    }
}
