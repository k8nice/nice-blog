package com.nice.mapper;

import com.nice.model.User;
import org.apache.ibatis.annotations.Mapper;
import sun.reflect.generics.tree.VoidDescriptor;


@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
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
}
