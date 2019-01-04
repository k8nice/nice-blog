package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nice
 */
@Data
public class Access implements Serializable {
    /**
     * 主键id
     * 访问时间
     * 访问ip
     * 文章id
     * 用户id
     */
    private static final long serialVersionUID = 239157596711084401L;
    private Long accessId;
    private Date accessTime;
    private String accessIP;
    private Long articleId;
    private Long userId;
}
