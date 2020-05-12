import com.alibaba.mybatis.dao.UserMapper;
import com.alibaba.mybatis.pojo.User;
import com.alibaba.mybatis.pojo.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author shenmeng
 * @Date 2020-01-31
 **/
public class TestPageHelper {

    private SqlSessionFactory sqlSessionFactory;



    @Before
    public void init() throws Exception{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory= builder.build(input);
    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(2,1);
        UserExample example = new UserExample();
        List<User> users = mapper.selectByExample(example);
        PageInfo<User> pageInfo=new PageInfo<>(users);
        System.out.println(pageInfo);
    }

}
