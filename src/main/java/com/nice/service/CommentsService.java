package com.nice.service;

import com.nice.model.Comments;

import java.util.List;

public interface CommentsService {

    /**
     * 添加一个评论
     * @param comments
     */
    void addComments(Comments comments);

    /**
     * 根据文章id查看评论
     * @param articleId
     * @return
     */
    List<Comments> queryCommentsByArticleId(Long articleId,Long pageNum);

    /**
     * 根据文章id查看评论条数
     * @param articleId
     * @return
     */
    Long queryCommentsPagesByArticleId(Long articleId);

    /**
     * 删除评论
     * @param commentsId
     */
    void deleteComments(Long commentsId);
}
