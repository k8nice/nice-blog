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
    private Long articleId;
    private String articleTitle;
    private String articleType;
    private Date articleCreateDate;
    private Date articleUpdateDate;
    private String articleContent;
    private Long userId;
    private boolean idExist;
}
