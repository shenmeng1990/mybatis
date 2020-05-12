package com.alibaba.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;

import java.util.List;
import java.util.Properties;

/**
 * @Author shenmeng
 * @Date 2020-02-01
 **/
public class XMLConfigParser {

    private Configuration configuration;

    public XMLConfigParser() {
        configuration=new Configuration();
    }

    /**
    * <configuration>
     *     <properties resource="db.properties"></properties>
     *     <environments default="development">
     *         <environment id="development">
     *             <transactionManager type="JDBC" />
     *             <dataSource type="POOLED">
     *                 <property name="driver" value="" />
     *                 <property name="url" value="" />
     *                 <property name="username" value="" />
     *                 <property name="password" value="" />
     *             </dataSource>
     *         </environment>
     *     </environments>
     *     <mappers>
     *         <mapper resource="mapper/UserMapper.xml"></mapper>
     *     </mappers>
     * </configuration>
    **/

    /**
    * @Description 解析mybatis的全局配置文件
    * @Return
    */
    public  Configuration parse(Element rootElement){
        //解析environments标签
        parseEnvironment(rootElement.element("environments"));
        //解析mappers标签
        parseMapper(rootElement.element("mappers"));
        return configuration;
    }

    private void parseEnvironment(Element environments) {
        //获取environments的default属性的值
        String envDef = environments.attributeValue("default");
        //获取全部environment标签
        List<Element> envElements = environments.elements();
        for (Element envElement : envElements) {
            String envId = envElement.attributeValue("id");
            if(StringUtils.isEmpty(envId)){
                break;
            }
            if(envId.equals(envDef)){
                //解析数据源
                parseDataSource(envElement);
            }
        }
    }

    private void parseDataSource(Element envElement) {
        Element dataSourceElement = envElement.element("dataSource");
        String type = dataSourceElement.attributeValue("type");

        List<Element> propertyList = dataSourceElement.elements("property");

        Properties properties = new Properties();

        for (Element element : propertyList) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }


        if("DRUID".equals(type)){
            DruidDataSource dataSource =  new DruidDataSource();
            dataSource.setDriverClassName(properties.getProperty("driver"));
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            configuration.setDataSource(dataSource);
        }


    }

    private void parseMapper(Element mappers) {
    }

}
