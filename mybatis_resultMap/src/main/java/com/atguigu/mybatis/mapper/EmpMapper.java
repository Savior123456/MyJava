package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 通过id查询员工信息
     * @param id
     * @return
     */
    Emp getEmpByEmpId(@Param("empId")Integer id);


    /**
     * 根据id获取员工以及部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 分步查询查询员工以及所对应的部分信息的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStep(@Param("empId") Integer empId);

    /**
     *通过分步查询查询某个部门中所有的员工信息第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
}
