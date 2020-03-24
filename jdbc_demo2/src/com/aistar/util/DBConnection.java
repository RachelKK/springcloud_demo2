package com.aistar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 该类用于获得数据库连接对象与关闭数据库连接
 */
public class DBConnection {

    private static Connection connection = null;

    /**
     * 获得数据库连接对象
     * @return  返回连接对象
     */
    public static Connection getConnection(){

        try {
            Class.forName(DataScourceUtil.getDriverName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DataScourceUtil.getUrl(), DataScourceUtil.getUsername(), DataScourceUtil.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    /**
     * 关闭数据库连接
     */
    public static  void closeConnection(){
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }

}
