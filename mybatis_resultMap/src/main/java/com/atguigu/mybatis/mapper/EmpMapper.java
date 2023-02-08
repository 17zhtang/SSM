package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);


    /**
     * 获取员工以及所对应的部门信息
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);


    /**
     * 查询员工和部门信息的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStep(@Param("empId") Integer empId);


    /**
     * 分布查询部门和部门中的员工的第二个步骤
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
