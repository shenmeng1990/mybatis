import com.alibaba.mybatis.step03.dao.AnnotationUserMapper;
import com.alibaba.mybatis.step03.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
public class MybatisTest03 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("step03/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);

    }


}
