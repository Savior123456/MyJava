import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class CacheMapperTest {


    /*
    * Mybatis的一级缓存
    * Mybatis的一级缓存是SqlSession级别，即通过同一个SqlSession查询的数据会被缓存
    * 再次使用同一个SqlSession查询同一条数据，会从缓存中获取
    * 默认开启一级缓存
    * 使一级缓存失效的四种情况
    * 1) 不同的SqlSession对应不同的一级缓存
      2) 同一个SqlSession但是查询条件不同
      3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
      4) 同一个SqlSession两次查询期间手动清空了缓存
      *
      * 二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被
        缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
        二级缓存开启的条件：
        a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
        b>在映射文件中设置标签<cache/>
        c>二级缓存必须在SqlSession关闭或提交之后有效
        d>查询的数据所转换的实体类类型必须实现序列化的接口
    * */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(1);
        System.out.println(empById);
        //手动清空一级缓存
        sqlSession.clearCache();
        Emp empById1 = mapper.getEmpById(1);
        System.out.println(empById1);

        //mapper.insertEmp(new Emp(null,"小红",25,"女"));

    }

    @Test
    public void testCache() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession1 = build.openSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(mapper.getEmpById(1));
        System.out.println(mapper1.getEmpById(1));
        sqlSession1.close();
        sqlSession.close();//未实现
    }
}
