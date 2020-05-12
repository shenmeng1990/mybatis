package com.alibaba.mybatis.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
@Data
public class User {

    private int id;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private List<Order> orders;
}
