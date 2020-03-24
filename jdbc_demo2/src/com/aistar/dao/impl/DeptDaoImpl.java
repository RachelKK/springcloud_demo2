package com.aistar.dao.impl;

import com.aistar.dao.DeptDao;
import com.aistar.pojo.Dept;
import com.aistar.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public int insert(Dept dept) {
        int rows = 0;
       Connection connection =  DBConnection.getConnection();

       String sql = "insert into dept values(?,?,?)" ; // dept.getDeptNo(), dept.getDname()  dept.getLoc()
        PreparedStatement pstmt = null;
        try {

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,dept.getDeptno());
            pstmt.setString(2,dept.getDname());
            pstmt.setString(3,dept.getLoc());

           rows =  pstmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt !=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();
        }

        return rows;
    }

    @Override
    public int delete(int deptno) {
      Connection connection =   DBConnection.getConnection();
      String sql ="delete from dept where deptno = ?";
      PreparedStatement  pstmt = null;
      int rows = 0;


        try {
            pstmt =   connection.prepareStatement(sql);
            pstmt.setInt(1,deptno);
            rows = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt !=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();
        }

        return rows;
    }

    @Override
    public int update(Dept dept) {
        Connection connection = DBConnection.getConnection();
        String sql ="update dept set dname = ? , loc = ? where deptno =?";
        PreparedStatement pstmt = null;
        int rows = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,dept.getDname());
            pstmt.setString(2,dept.getLoc());
            pstmt.setInt(3,dept.getDeptno());

            rows =  pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();
        }


        return rows;
    }

    @Override
    public Dept selectByPrimaryKey(int deptno) {
        Dept dept = null;
       Connection connection =  DBConnection.getConnection();
       String sql = "select deptno,dname,loc from dept where deptno = " + deptno;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                String dname = rs.getString(2);
                String location = rs.getString(3);
                dept =  new Dept(deptno,dname,location);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs !=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt !=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();

        }

        return dept;
    }

    @Override
    public List<Dept> selectAll() {
        List<Dept> deptList = new ArrayList<>();


        Connection connection =  DBConnection.getConnection();
        String sql = "select deptno,dname,loc from dept ";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int deptno = rs.getInt(1);
                String dname = rs.getString(2);
                String location = rs.getString(3);
                deptList.add(new Dept(deptno,dname,location));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs !=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt !=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection();

        }

        return deptList;
    }
}
