package com.nice.mapper;

import com.nice.model.User;
import org.apache.ibatis.annotations.Mapper;
import sun.reflect.generics.tree.VoidDescriptor;


@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    String  queryUserNameByUserName(String userName);

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

    /**
     * 通过用户id获取用户名
     * @param userId
     * @return
     */
    String queryUserNameByUserId(Long userId);

}
