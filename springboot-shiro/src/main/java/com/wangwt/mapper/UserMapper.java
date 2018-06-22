package com.wangwt.mapper;

import com.wangwt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018\6\8 0008.
 */
//@Mapper
public interface UserMapper {
    @Select("select * from user where username =#{username}")
    @ResultType(User.class)
    User selectUserByUsername(@Param("username") String username);


}
