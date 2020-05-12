package com.alibaba.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author shenmeng
 * @Date 2020-01-31
 **/
@Data
public class Order {

    private Integer id;

    private Integer userId;

    private Integer number;

    private Date createTime;

    private String note;
}
