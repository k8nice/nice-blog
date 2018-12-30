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
     * 根据用户名查出salt和密码
     *
     * @param userName
     * @return
     */
    User queryUserPasswordAndSaltByUserName(String userName);

    /**
     * 根据用户名查询用户id
     * @param userName
     * @return
     */
    Long queryUserIdByUserName(String userName);

}
