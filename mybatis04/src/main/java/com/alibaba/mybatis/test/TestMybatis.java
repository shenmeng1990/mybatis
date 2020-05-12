package com.alibaba.mybatis.test;

import com.alibaba.mybatis.config.Configuration;
import com.alibaba.mybatis.config.XMLConfigParser;
import com.alibaba.mybatis.utils.DocumentUtil;
import com.alibaba.mybatis.utils.ResourceUtil;
import org.dom4j.Document;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author shenmeng
 * @Date 2020-02-01
 **/
public class TestMybatis {

    @Test
    public void initConfiguration(){
        //1:定义配置文件路径
        String resource = "SqlMapConfig.xml";
        //2:读取配置文件
        InputStream inputStream = ResourceUtil.read(resource);
        //3:将inputStream解析成Document对象
        Document document = DocumentUtil.readDocument(inputStream);
        //4:从document对象的标签中解析处configuration对象
        XMLConfigParser xmlConfigParser=new XMLConfigParser();
        Configuration configuration=xmlConfigParser.parse(document.getRootElement());
        System.out.println(configuration);
    }

}
