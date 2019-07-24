package com.liang.daoimpl;

import com.liang.dao.EssayDao;
import com.liang.dao.ReplyDao;
import com.liang.jdbc.JDBCUtil;
import com.liang.po.Essay;
import com.liang.po.Page;
import com.liang.po.Reply;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EssayaDaoImpl implements EssayDao {

    @Override
    public List<Essay> findAll(){
        List<Essay> essays = new LinkedList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from essay where ePower = 0 order by eDate DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            findEssay(essays,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return essays;
    }

    @Override
    public boolean insertEssay(Essay essay) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into essay values (null,?,?,?,?)";
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,essay.getuName());
            ps.setString(2,essay.getEssay());
            ps.setDate(3,essay.geteDate());
            ps.setInt(4,essay.getePower());
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

    @Override
    public List<Essay> findUserAllEssay(String uName) {
        List<Essay> essays = new LinkedList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from essay where uName = ? order by eDate DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uName);
            rs = ps.executeQuery();
            findEssay(essays, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return essays;
    }

    @Override
    public void deleteEssay(int eId) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from essay where eId = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,eId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                JDBCUtil.release(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Essay> findUsersAllEssay(String uName) {
        List<Essay> essays = new LinkedList<>();
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from essay where uName like ? order by eDate DESC";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,uName+"%");
            rs = ps.executeQuery();
            findEssay(essays, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return essays;
    }

    @Override
    public List<Essay> findSomeEssay(Page page) {
        String sql = "select * from essay where ePower = 0 order by edate desc limit ?,?";
        List<Essay> essays = new LinkedList<>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(page.getCurrentPage()-1)*5);
            ps.setInt(2,page.getPAGE_SIZE());
            rs = ps.executeQuery();
            findEssay(essays,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return essays;
    }

    @Override
    public List<Essay> findUserSomeEssay(Page page, String uName) {
        String sql = "select * from essay where uName like ? and ePower = 0 order by edate desc limit ?,?";
        List<Essay> essays = new LinkedList<>();
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(2,(page.getCurrentPage()-1)*5);
            ps.setInt(3,page.getPAGE_SIZE());
            ps.setString(1,uName+"%");
            rs = ps.executeQuery();
            findEssay(essays,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return essays;
    }

    @Override
    public int findUserCount(String uName) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select count(*) as userCount from essay where uname like ? and ePower = 0";
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userCount = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, uName+"%");
            rs = ps.executeQuery();
            rs.next();
            userCount = rs.getInt("userCount");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return userCount;
    }

    @Override
    public boolean updatePower(int eId, int ePower) {
        ePower = ePower^1;
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        boolean flag = false;
        String sql = "update essay set ePower = ? where eId = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ePower);
            ps.setInt(2, eId);
            int num = ps.executeUpdate();
            if (num > 0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn, ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public int findAllCount() {
        String sql = "select count(*) as allCount from essay where ePower = 0";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int allCount = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            allCount = rs.getInt("allCount");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.release(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allCount;
    }


    private void findEssay(List<Essay> essays, ResultSet rs){
        try {
            while (rs.next()){
                Essay essay = new Essay();
                int eId = rs.getInt("eId");
                essay.seteId(eId);
                essay.setuName(rs.getString("uName"));
                essay.setEssay(rs.getString("essay"));
                essay.seteDate(rs.getDate("eDate"));
                essay.setePower(rs.getInt("ePower"));
                ReplyDao rd = new ReplyDaoImpl();
                List<Reply> replies = rd.findAllReply(eId);
                essay.setReplies(replies);
                essays.add(essay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



/*    public static void main(String[] args) throws SQLException {
        EssayDao ed = new EssayaDaoImpl();
        System.out.println(ed.findAll());
    }*/
}
