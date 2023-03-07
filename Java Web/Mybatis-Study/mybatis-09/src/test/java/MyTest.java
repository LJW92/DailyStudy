import com.jiawei.dao.UserMapper;
import com.jiawei.pojo.User;
import com.jiawei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.clearCache();
        System.out.println("==================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }

}
