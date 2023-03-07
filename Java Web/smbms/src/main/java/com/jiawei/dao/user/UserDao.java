package com.jiawei.dao.user;

import com.jiawei.pojo.Role;
import com.jiawei.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //get login user

    User getLoginUser(Connection connection, String userCode) throws SQLException;
    /* change current users password */
    int updatePwd(Connection connection, int id, String password) throws SQLException;

    //query for total user number, by total/ username / useRole
    int getUserCount(Connection connection,String userName, int userRole) throws SQLException;

    List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
            throws Exception;



}
