package com.aistar.dao;

import com.aistar.pojo.Dept;

import java.util.List;

/**
 * 部门的数据操作接口
 */
public interface DeptDao {

    /**
     * 添加新部门
     * @param dept  部门对象
     * @return  返回表中受影响的行数
     */
    public int insert(Dept dept);


    /**
     * 删除部门
     * @param deptno 部门编号
     * @return  返回表中受影响行数
     */
    public int delete(int deptno);


    /**
     * 修改部门
     * @param dept 部门对象
     * @return 返回表中受影响的行数
     */
    public int update(Dept dept);


    /**
     * 根据主键查询部门
     * @param deptno 部门编号
     * @return  返回对应的部门对象
     */
    public Dept selectByPrimaryKey(int deptno);


    /**
     * 查询所有部门
     * @return  返回所有部门的集合
     */
    public List<Dept> selectAll();

}
