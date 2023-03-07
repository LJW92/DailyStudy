package com.jiawei.dao;

import com.jiawei.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据ID查询用户
    User getUserById(int id);
    //insert一个用户
    int addUser(User user);
    int upDateUser(User user);

    //删除一个用户
    int delUser(int id);
}
