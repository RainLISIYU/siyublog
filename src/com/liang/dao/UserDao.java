package com.liang.dao;

import com.liang.po.User;

import java.sql.SQLException;

/**
 * @author 梁思禹
 */
public interface UserDao {
    /**
     * user表中添加用户
     * @param user 用户
     * @throws SQLException
     */
    void insertUser(User user);

    /**
     * 检查user表中该用户名是否注册
     * @param uName 用户名
     * @return 1或0
     * @throws SQLException
     */
    int checkUserName(String uName);

    /**
     * 检查用户及密码
     * @param uName
     * @param uPassword
     * @return true or not
     * @throws SQLException
     */
    boolean checkUser(String uName, String uPassword);

    /**
     * 找到用户的信息
     * @param uName
     * @return
     * @throws SQLException
     */
    User findUser(String uName);

    /**
     * 更新用户信息
     * @param user
     */
    boolean updateUser(User user);
}
