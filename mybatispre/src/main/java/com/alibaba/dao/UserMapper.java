package com.alibaba.dao;

import com.alibaba.model.User;

import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-05-13
 **/
public interface UserMapper {

    User  getUserById(Integer id);

    List<User> getUserByName(String userName);

}
