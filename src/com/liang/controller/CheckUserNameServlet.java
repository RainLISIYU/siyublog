package com.liang.controller;

import com.liang.dao.UserDao;
import com.liang.daoimpl.UserDaoImpl;
import com.liang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 梁思禹
 */
@WebServlet(name = "CheckUserNameServlet", urlPatterns = "/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName = request.getParameter("uName");
        UserService userDao = new UserService();
        int num = userDao.checkUserName(uName);
        if (num == 0) {
            response.getWriter().write("0");
        }else{
            response.getWriter().write("1");
        }
    }
}
