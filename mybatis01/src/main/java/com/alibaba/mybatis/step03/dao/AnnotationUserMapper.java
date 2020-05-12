package com.alibaba.mybatis.step03.dao;

import com.alibaba.mybatis.step03.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public interface AnnotationUserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(int id);
}
