import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    /**
     * mybatis的一级缓存（默认开启）：
     * mybatis的一级缓存是sqlSession级别的，即通过同一个sqlseesion查询的数据会被缓存
     * 再次使用同sqlsession查询同一数据时会从缓存获取
     * 一级缓存失效的四种情况（重新从数据库获取）
     * 1、不同sqlsession
     * 2、同sqlsession，但查询条件不同
     * 3、两次查询中间执行了增删改
     * 4、手动清空了缓存
     *
     * mybatis二级缓存：
     * 二级缓存是SqlSessionFactory级别的，同SqlSessionFactory获取的SqlSession对象查询的数据会被缓存
     * 它们查询相同数据时会从缓存中获取
     * 二级缓存开启条件：
     * 1、核心配置文件中，全局属性cacheEnabled设置为true，默认为true
     * 2、映射文件中设置标签，<cache/>
     * 3、二级缓存必须在SqlSession关闭或提交之后才有效（一级缓存在SqlSession关闭或提交之后才会写入二级缓存）
     * 4、查询的数据所转换的实体类类型必须实现序列化接口 public class Emp implements Serializable
     *
     * 二级缓存失效：
     * 两次查询之间执行了增删改
     *
     * 缓存查询顺序：
     * 先查二级缓存再查一级缓存，一级没命中就查数据库
     *
     */

    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
//        手动清除缓存
//        sqlSession.clearCache();
        mapper.insertEmp(new Emp(null,"kk",25,"女"));
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testCache () throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }

}
