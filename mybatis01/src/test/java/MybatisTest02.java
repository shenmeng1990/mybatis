import com.alibaba.mybatis.step01.dao.UserDao;
import com.alibaba.mybatis.step01.dao.impl.UserDaoImpl;
import com.alibaba.mybatis.step02.dao.UserMapper;
import com.alibaba.mybatis.step02.pojo.QueryVo;
import com.alibaba.mybatis.step02.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-01-30
 **/
public class MybatisTest02 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("step02/config/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindByUserName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUserName("test");
        System.out.println(userList);
    }

    @Test
    public void testFindByQueryVo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUsername("test");
        queryVo.setUser(user);
        List<User> userList = mapper.findByQueryVo(queryVo);
        System.out.println(userList);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("test002");
        user.setAddress("上海");
        user.setSex("女");
        user.setBirthday(new Date());
        mapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void testfindUserListResultMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findUserListResultMap();
        System.out.println(userList);
    }

}
