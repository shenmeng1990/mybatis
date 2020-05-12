package com.alibaba.mybatis.config;

import lombok.Data;

import javax.sql.DataSource;

/**
 * @Author shenmeng
 * @Date 2020-02-01
 **/
@Data
public class Configuration {

    private DataSource dataSource;

}
