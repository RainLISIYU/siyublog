package com.liang.daoimpl;

import com.liang.dao.UserDao;
import com.liang.jdbc.JDBCUtil;
import com.liang.po.User;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author 梁思禹
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(User user){
        String sql = "insert into user (uid,uname,upassword,uphonenumber,uemail,udate) values (null,?,?,?,?,?);";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,user.getuName());
            ps.setString(2, user.getuPassword());
            ps.setString(3, user.getuPhoneNumber());
            ps.setString(4, user.getuEmail());
            ps.setDate(5,user.getuDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int checkUserName(String uname) {
        String sql = "select count(*) as num from user where uname = ?";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            rs.next();
            num = rs.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public boolean checkUser(String uName, String uPassword){
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select uPassword from user where uName = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uName);
            rs = ps.executeQuery();
            String pass = "";
            if (rs.next()) {
               pass = rs.getString("uPassword");
            }
            if (uPassword.equals(pass)){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User findUser(String uName){
        User user = new User();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from user where uName = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uName);
            rs = ps.executeQuery();
            if (rs.next()){
                user.setuName(rs.getString("uName"));
                user.setuPassword(rs.getString("uPassword"));
                user.setuPhoneNumber(rs.getString("uPhoneNumber"));
                user.setuEmail(rs.getString("uEmail"));
                user.setuDate(rs.getDate("uDate"));
                user.setuGender(rs.getInt("uGender"));
                user.setuHobby(rs.getString("uHobby"));
                user.setuMessage(rs.getString("uMessage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "update user set upassword = ? , uPhonenumber = ? ," +
                "uemail = ? , ugender = ? , uhobby = ? , umessage = ? where uname = ?";
        PreparedStatement ps = null;
        boolean flag = false;
        String uName = user.getuName();
        String uPassword = user.getuPassword();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uPassword);
            ps.setString(2, user.getuPhoneNumber());
            ps.setString(3, user.getuEmail());
            ps.setInt(4, user.getuGender());
            ps.setString(5, user.getuHobby());
            ps.setString(6,user.getuMessage());
            ps.setString(7,user.getuName());
            int num = ps.executeUpdate();
            if (num > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
