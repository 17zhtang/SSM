package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(System.out::println);
        //根据条件查询
//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("ff").andAgeGreaterThanOrEqualTo(20);
//        example.or().andGenderEqualTo("男");
//        List<Emp> list = mapper.selectByExample(example);
//        list.forEach(System.out::println);

        Emp emp = new Emp(1,"gaigai",null,"女");
        //普通修改，属性值为null时，会将字段修改为null

//        mapper.updateByPrimaryKey(emp);
        //选择性修改，属性值为null时，不修改字段
        mapper.updateByPrimaryKeySelective(emp);

    }

}
