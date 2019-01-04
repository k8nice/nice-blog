package com.nice.mapper;

import com.nice.model.Comments;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author nice
 */
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    List<Comments> queryCommentsByArticleId(Long articleId);

    /**
     * 添加评论
     * @param comments
     */
    void addComments(Comments comments);

    /**
     * 删除评论
     * @param commentsId
     */
    void deleteComments(Long commentsId);
}
