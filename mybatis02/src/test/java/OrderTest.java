import com.alibaba.mybatis.dao.OrderMapper;
import com.alibaba.mybatis.pojo.OrderExt;
import com.alibaba.mybatis.pojo.User;
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
public class OrderTest {

    private SqlSessionFactory sqlSessionFactory;



    @Before
    public void init() throws Exception{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory= builder.build(input);

    }

    @Test
    public void testFindOrderList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderExt> orderList = orderMapper.findOrderList();
        System.out.println(orderList);
        sqlSession.close();
    }

    @Test
    public void testFindUserOrderList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<User> userOrder = orderMapper.findUserOrder();
        System.out.println(userOrder);
    }
}
