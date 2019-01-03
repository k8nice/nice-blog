package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nice
 */
@Data
public class Comments implements Serializable {
    private static final long serialVersionUID = 5472233784482515555L;
    private Long commentId;
    private Long userId;
    private Long articleId;
    private Date createCommentDate;
    private Date updateCommentDate;
    private String commentContent;
}
