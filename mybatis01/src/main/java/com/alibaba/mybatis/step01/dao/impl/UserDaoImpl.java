package com.alibaba.mybatis.step01.dao.impl;

import com.alibaba.mybatis.step01.dao.UserDao;
import com.alibaba.mybatis.step01.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try {
            //通过sqlsession调用selectOne方法获取一条结果集
            //参数1：指定定义的statement的id,参数2：指定向statement中传递的参数
            user = session.selectOne("test.findUserById", id);
            System.out.println(user);

        } finally{
            session.close();
        }
        return user;
    }

}
