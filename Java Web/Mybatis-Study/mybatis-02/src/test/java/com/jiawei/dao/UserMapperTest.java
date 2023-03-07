package com.jiawei.dao;

import com.jiawei.pojo.User;
import com.jiawei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {
    @Test
    public void getUserList(){
        //第一步，获得sqlSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            //执行，方式1 getMapper 新又好
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }  //不会忘记要关闭
        //关闭sqlSession
    }
}
