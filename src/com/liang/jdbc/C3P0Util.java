package com.liang.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 单例实现C3P0数据库连接池工具类
 * @author 梁思禹
 */
public class C3P0Util {

    private static C3P0Util util;

    private static ComboPooledDataSource dataSource;

    static synchronized C3P0Util getInstance(){
        if (util == null){
            util = new C3P0Util();
        }
        return util;
    }

    private C3P0Util(){
        init();
    }

    private void init(){
        dataSource = new ComboPooledDataSource();
    }

    /**
     * 获得连接
     * @return Connection
     */
    public Connection getConnection(){

        try {
            /*System.out.println(dataSource);*/
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

/*    public static void main(String[] args) {
        C3P0Util util1 = C3P0Util.getInstance();
        C3P0Util util2 = C3P0Util.getInstance();
        util1.getConnection();
        util2.getConnection();
    }*/
}
