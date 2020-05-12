package com.alibaba.mybatis.pojo;

import lombok.Data;

/**
 * @Author shenmeng
 * @Date 2020-01-31
 **/
@Data
public class OrderExt extends Order {

    private User user;

}
