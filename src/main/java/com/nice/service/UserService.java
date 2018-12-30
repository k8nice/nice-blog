package com.nice.service;

import com.nice.model.User;

public interface UserService {
    /**
     * 查询全部用户
     *
     * @param userName
     * @return
     */
    String queryUserNameAll(String userName);

    /**
     * 添加用户
     *
     * @param User
     */
    void addUser(User User);

    /**
     * 根据用户名查询密码
     *
     * @param userName
     * @return
     */
    String queryUserPasswordByUser(String userName);

    /**
     * 根据用户名获取salt
     * @param userName
     * @return
     */
    String queryUserSaltByUserName(String userName);
}
