package com.jiawei.dao;


import com.jiawei.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User queryUserById(@Param("id") int id);


}
