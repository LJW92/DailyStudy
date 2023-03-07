package com.jiawei.service.user;

import com.jiawei.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserService {
    //user login
    User login (String userCode, String password);

    boolean updatePwd( int id, String pwd) ;

    int getUserCount(String userName, int userRole);

    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

}
