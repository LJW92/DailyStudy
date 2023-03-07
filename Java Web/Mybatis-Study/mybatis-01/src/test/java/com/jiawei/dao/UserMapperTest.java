package com.jiawei.dao;

import com.jiawei.pojo.User;
import com.jiawei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void getUserList(){
        //第一步，获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            //执行，方式1 getMapper 新又好
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } finally {  //不会忘记要关闭
            //关闭sqlSession
            sqlSession.close();
        }
    }




    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            //执行，方式1 getMapper 新又好
            User userById = userMapper.getUserById(1);
            System.out.println(userById);
        } finally {  //不会忘记要关闭
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            //执行，方式1 getMapper 新又好
            int isDone = userMapper.addUser(new User(4, "哈哈", "33333333"));
            if (isDone > 0) {
                System.out.println("insert done");
            } else {
                System.out.println("insert failed");
            }
            sqlSession.commit(); //必须提交事务
        } finally {  //不会忘记要关闭
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void upDateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            //执行，方式1 getMapper 新又好
            int isDone = userMapper.upDateUser(new User(4, "呵呵", "33333333"));
            if (isDone > 0) {
                System.out.println("update done");
            } else {
                System.out.println("update failed");
            }
            sqlSession.commit(); //必须提交事务
        } finally {  //不会忘记要关闭
            //关闭sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void delUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try{
            //执行，方式1 getMapper 新又好
            int isDone = userMapper.delUser(4);
            if (isDone > 0) {
                System.out.println("delete done");
            } else {
                System.out.println("delete failed");
            }
            sqlSession.commit(); //必须提交事务
        } finally {  //不会忘记要关闭
            //关闭sqlSession
            sqlSession.close();
        }
    }

}
