package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nice
 */
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = -4184375624816977716L;
    /**
     * 文章id
     * 文章标题
     * 文章类型
     * 文章创建日期
     * 文章更新日期
     * 文章内容
     * 用户id
     * 文章是否存在
     */
    private Long articleId;
    private String articleTitle;
    private String articleType;
    private Date articleCreateDate;
    private Date articleUpdateDate;
    private String articleContent;
    private Long userId;
    private Long ctr;
    private boolean idExist;
}
