package com.liang.jdbc;

import java.sql.*;

/**
 * 数据库工具类
 * @author 梁思禹
 */
public class JDBCUtil {
/*    static String driverClass = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/lsys?serverTimezone=UTC";
    static String uname = "root";
    static String password = "lsy19980104";*/

    public static Connection getConnection(){

        C3P0Util util = C3P0Util.getInstance();
        return util.getConnection();

    }

    /**
     * 释放连接
     * @param conn
     * @param ps
     * @param rs
     * @throws SQLException
     */
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
        if (rs != null){
            rs.close();
        }
        if (ps != null){
            ps.close();
        }
        if (conn != null){
            conn.close();
        }
    }

    /**
     * 释放连接
     * @param conn
     * @param ps
     * @throws SQLException
     */
    public static void release(Connection conn, PreparedStatement ps) throws SQLException{
        if (ps != null){
            ps.close();
        }
        if (conn != null){
            conn.close();
        }
    }

/*    public static PreparedStatement getPrepareStatement(String sql){

        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }*/



    /*public static void main(String[] args) {
        System.out.println(getConnection());
    }*/

}
