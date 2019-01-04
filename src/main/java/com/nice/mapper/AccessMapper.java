package com.nice.mapper;

import com.nice.model.Access;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nice
 */
@Mapper
public interface AccessMapper {
    /**
     * 增加访问
     * @param access
     */
    void addAccess(Access access);

    /**
     * 日访问计算
     * @param access
     */
    Long dayAccess(Access access);
    Long weekAccess(Access access);
    Long monthAccess(Access access);
    Long yearAccess(Access access);
}
