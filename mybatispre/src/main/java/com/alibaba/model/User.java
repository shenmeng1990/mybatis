package com.alibaba.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author shenmeng
 * @Date 2020-05-13
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4061459328256637413L;

    private Integer id;

    private String userName;

    private Date birthDay;

    private String sex;

    private String address;

}
