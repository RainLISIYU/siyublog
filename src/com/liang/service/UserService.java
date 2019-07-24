package com.liang.service;

import com.liang.dao.UserDao;
import com.liang.daoimpl.UserDaoImpl;
import com.liang.po.User;

import java.sql.SQLException;

/**
 * @author 梁思禹
 */
public class UserService {

    public void insertUser(User user) {
        UserDao ud = new UserDaoImpl();
        ud.insertUser(user);
    }

    public int checkUserName(String uName) {
        UserDao ud = new UserDaoImpl();
       return ud.checkUserName(uName);
    }

    public boolean checkUser(String uName, String uPassword) {
        UserDao ud = new UserDaoImpl();
        return ud.checkUser(uName, uPassword);
    }

    public User findUser(String uName) {
        UserDao ud = new UserDaoImpl();
        return ud.findUser(uName);
    }

    public boolean updateUser(User user){
        UserDao ud = new UserDaoImpl();
        return ud.updateUser(user);
    }
}
