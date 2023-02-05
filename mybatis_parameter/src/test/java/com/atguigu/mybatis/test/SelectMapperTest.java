package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserBuyId(2);
        System.out.println(user);

    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);

    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);

    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = mapper.getUserByIdToMap(2);
        //{password=88888888, gender=男, id=2, age=23, email=12345@qq.com, username=changed}
        //当某个字段值为null时，它不会被放到map中
        System.out.println(map);
    }



    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String,Object>> list = mapper.getAllUserToMap();
        //{password=88888888, gender=男, id=2, age=23, email=12345@qq.com, username=changed}
        //当某个字段值为null时，它不会被放到map中
        System.out.println(list);
    }

    @Test
    public void testGetAllUserToMapKey(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = mapper.getAllUserToMapKey();
        //{2={password=88888888, gender=男, id=2, age=23, email=12345@qq.com, username=changed},
        // 4={password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin},
        // 5={password=123456, gender=女, id=5, age=33, email=new@123.com, username=new}}
        System.out.println(map);
    }

}
