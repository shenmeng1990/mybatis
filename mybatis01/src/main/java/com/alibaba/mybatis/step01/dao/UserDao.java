package com.alibaba.mybatis.step01.dao;

import com.alibaba.mybatis.step01.pojo.User;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public interface UserDao {

    public User findUserById(int id) throws Exception;

}
