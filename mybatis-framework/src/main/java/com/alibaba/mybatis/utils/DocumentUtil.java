package com.alibaba.mybatis.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @Author shenmeng
 * @Date 2020-02-01
 **/
public class DocumentUtil {

    public static Document readDocument(InputStream inputStream) {
        SAXReader saxReader=new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }
}
