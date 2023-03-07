package com.jiawei.test;

import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 配置信息
        //useUnicode=ture&characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=ture&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";
        //2. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3. 连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //4 .向数据库发送sql的对象statement
        Statement statement = connection.createStatement();
        //5. 根据业务编写sql
        String sql = "select * from users";
        //6. 执行查询sql，返回一个resultset

        //当执行指令为更新时，返回受影响行数
        int i = statement.executeUpdate(sql);

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
        }
        //7. 关闭连接，释放资源
        resultSet.close();
        statement.close();
        connection.close();

    }

}
