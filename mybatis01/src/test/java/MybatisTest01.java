import com.alibaba.mybatis.step01.dao.UserDao;
import com.alibaba.mybatis.step01.dao.impl.UserDaoImpl;
import com.alibaba.mybatis.step01.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public class MybatisTest01 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("step01/config/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testFindUserById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = null;
        try {
            user = userDao.findUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }


}
