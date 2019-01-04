package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nice
 */
@Data
public class Comments implements Serializable {
    /**
     * 主键id
     * 用户id
     * 文章id
     * 评论创建时间
     * 评论修改时间
     * 评论内容
     */
    private static final long serialVersionUID = 5472233784482515555L;
    private Long commentId;
    private Long userId;
    private Long articleId;
    private Date createCommentDate;
    private Date updateCommentDate;
    private String commentContent;
}
