package com.liang.controller;

import com.liang.po.User;
import com.liang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
/**
 * @author 梁思禹
 */
@WebServlet(name = "RegisteServlet",urlPatterns = "/RegisteServlet")
public class RegisteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName = request.getParameter("username");
        String uPassword = request.getParameter("password");
        String uPhoneNumber = request.getParameter("phonenumber");
        String uEmail = request.getParameter("email");
        Date uDate = new Date(System.currentTimeMillis());

        User user = new User();
        user.setuName(uName);
        user.setuPassword(uPassword);
        user.setuPhoneNumber(uPhoneNumber);
        user.setuEmail(uEmail);
        user.setuDate(uDate);

        UserService userDao = new UserService();

        userDao.insertUser(user);

        response.sendRedirect("BlogLogin");

    }
}
