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
    List<Comments> queryCommentsByArticleId(Long articleId);
}
