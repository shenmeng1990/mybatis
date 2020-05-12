package com.alibaba.mybatis.dao;

import com.alibaba.mybatis.pojo.OrderExt;
import com.alibaba.mybatis.pojo.User;

import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-01-31
 **/
public interface OrderMapper {

    /**
    * 以订单为主查询
    **/
    List<OrderExt> findOrderList();

    /**
    * 以用户为主查询，查询用户下了多少单
    **/
    List<User> findUserOrder();

}
