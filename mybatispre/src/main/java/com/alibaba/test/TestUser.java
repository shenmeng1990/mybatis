package com.alibaba.test;

import com.alibaba.dao.UserMapper;
import com.alibaba.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-05-13
 **/
public class TestUser {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        String resource = "sqlMapConfig.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void testGetUserByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserByName("userName");
        Assert.assertNotNull(userList);

    }
}
