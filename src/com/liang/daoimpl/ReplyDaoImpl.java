package com.liang.daoimpl;

import com.liang.dao.ReplyDao;
import com.liang.jdbc.JDBCUtil;
import com.liang.po.Reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public List<Reply> findAllReply(int eId){

        List<Reply> replies = new LinkedList<>();

        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from reply where eId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,eId);
            rs = ps.executeQuery();
            while (rs.next()){
                Reply reply = new Reply();
                reply.setrId(rs.getInt("rId"));
                reply.setuName(rs.getString("uName"));
                reply.seteId(eId);
                reply.setReply(rs.getString("reply"));
                reply.setrDate(rs.getDate("rDate"));
                replies.add(reply);
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
        return replies;
    }

    @Override
    public void insertReply(Reply reply) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into reply values (null, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,reply.getuName());
            ps.setInt(2, reply.geteId());
            ps.setString(3, reply.getReply());
            ps.setDate(4, reply.getrDate());
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
    public void deleteReply(int rId) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from reply where rId = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,rId);
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


}
