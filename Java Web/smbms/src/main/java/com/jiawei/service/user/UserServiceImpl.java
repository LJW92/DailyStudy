package com.jiawei.service.user;

import com.jiawei.dao.BaseDao;
import com.jiawei.dao.user.UserDao;
import com.jiawei.dao.user.UserDaoImpl;
import com.jiawei.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    //service layer uses DAO layer
    private final UserDao userDao;

    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    public User login(String userCode, String password) {
        Connection  connection = null;
        User user;


        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.closeResource(connection, null,null);
        }
        return user;
    }

    public boolean updatePwd(int id, String pwd) {
        Connection  connection;
        boolean changeDone = false;
        connection = BaseDao.getConnection();
        try {
            if (userDao.updatePwd(connection, id, pwd) > 0){
                changeDone = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return changeDone;
    }

    public int getUserCount(String userName, int userRole) {
        Connection connection = null;
        int count;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, userName, userRole);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return  count;
    }

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }
}
