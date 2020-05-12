package com.alibaba.mybatis.step02.dao;

import com.alibaba.mybatis.step02.pojo.QueryVo;
import com.alibaba.mybatis.step02.pojo.User;

import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public interface UserMapper {

    User findUserById(int id);

    List<User> findByUserName(String userName);

    List<User> findByQueryVo(QueryVo queryVo);

    void insertUser(User user);

    List<User> findUserListResultMap();
}
