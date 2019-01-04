package com.nice.dto;

import lombok.Data;

/**
 * @author nice
 */
@Data
public class CommentsDto {
    private String userName;
    private String commentsContent;
    private Long commentsId;
}
