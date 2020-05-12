package com.alibaba.mybatis.utils;

import java.io.InputStream;

/**
 * @Author shenmeng
 * @Date 2020-02-01
 **/
public class ResourceUtil {

    public static InputStream read(String resource){
        return ResourceUtil.class.getClassLoader().getResourceAsStream(resource);
    }
}
