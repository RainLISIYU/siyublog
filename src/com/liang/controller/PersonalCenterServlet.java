package com.liang.controller;

import com.liang.po.User;
import com.liang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PersonalCenterServlet", urlPatterns = "/PersonalCenterServlet")
public class PersonalCenterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("uName") == null){
            request.getRequestDispatcher("BlogLogin").forward(request,response);
        }
        String uName = request.getSession().getAttribute("uName").toString();

        UserService us = new UserService();
        User user;
        user = us.findUser(uName);
        request.setAttribute("user",user);
        request.getRequestDispatcher("PersonalCenter").forward(request, response);
    }
}
