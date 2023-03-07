package com.jiawei.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//manipulate database
public class BaseDao {

    private static final String driver;
    private static final String username;
    private static final String password;
    private static final String url;

    //static block, loaded when class is loaded
    static {
        //load properties by classloader
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //get connection from database
    public static Connection getConnection(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //public query function
    public static ResultSet execute(Connection connection,
                                    PreparedStatement preparedStatement,
                                    String sql,
                                    Object[] params,
                                    ResultSet resultSet
                                    ) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject starts from 1, but array index starts from 0
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //Create Delete and Update
    public static int execute(Connection connection,
                              PreparedStatement preparedStatement,
                              String sql,
                              Object[] params
                              ) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //setObject starts from 1, but array index starts from 0
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }

    //release resources
    public static boolean closeResource(Connection connection,
                                        PreparedStatement preparedStatement,
                                        ResultSet resultSet){
        boolean closeIsDone = true;
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
                closeIsDone = false;
            }
        }

        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
                closeIsDone = false;
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
                closeIsDone = false;
            }
        }
        return  closeIsDone;
    }
}
