package com.nice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nice
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -3030313100942864088L;
    /**
     * 用户id
     * 用户名称
     * 用户密码
     * 用户创建时间
     * 用户更新时间
     * 用户身份证号
     * 用户邮箱
     * 用户电话
     * 用户地址
     */
    private Long   userId;
    private String userName;
    private String userPassword;
    private Date   userCreateDate;
    private Date   userUpdateDate;
    private String userRealName;
    private String userIdCard;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userSalt;
}
