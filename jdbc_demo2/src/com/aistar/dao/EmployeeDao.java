package com.aistar.dao;

import com.aistar.pojo.Employee;

import java.util.List;

/**
 * 员工的数据操作
 */
public interface EmployeeDao {


    public int insert(Employee employee);

    public int update(Employee employee);

    public int delete(int empno);

    public Employee selectByPrimaryKey(int empno);

    public Employee selectAll(Employee employee);

    //分页查询
    public List<Employee>  selectByPage(int startRecord, int size);

    //查询总记录数
    public int count();

}
