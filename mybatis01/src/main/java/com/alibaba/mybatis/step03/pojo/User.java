package com.alibaba.mybatis.step03.pojo;

import lombok.Data;

import java.util.Date;

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

}
