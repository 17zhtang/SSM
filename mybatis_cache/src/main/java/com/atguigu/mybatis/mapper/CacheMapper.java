package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * 根据员工id查询
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    void insertEmp(Emp emp);

}
