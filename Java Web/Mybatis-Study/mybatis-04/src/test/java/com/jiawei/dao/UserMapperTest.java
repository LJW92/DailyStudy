package com.jiawei.dao;

import com.jiawei.pojo.User;
import com.jiawei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;



public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserByLimit(){

    }


    @Test
    public void getUserList(){
        //第一步，获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try  {
            //执行，方式1 getMapper 新又好
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
            stringIntegerHashMap.put("startIndex", 1);
            stringIntegerHashMap.put("pageSize", 2);
            List<User> userByLimit = userMapper.getUserByLimit(stringIntegerHashMap);
            for (User user : userByLimit) {
                System.out.println(user);
            }
        }  finally {//不会忘记要关闭
            sqlSession.close();     //关闭sqlSession
        }
    }
    @Test
    public void testLog4j(){
        logger.info("info:进入了testlog4j");
        logger.debug("debug:进入了testlog4j");
        logger.error("error:进入了testlog4j");
    }
}
