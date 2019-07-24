package com.liang.controller;

import com.liang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckUserServlet", urlPatterns = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName = request.getParameter("username");
        String uPassword = request.getParameter("password");
        UserService us = new UserService();
        boolean flag;
        flag = us.checkUser(uName, uPassword);
        if (flag){
            HttpSession session = request.getSession();
            session.setAttribute("uName", uName);
            request.getRequestDispatcher("FindSomeEssayServlet").forward(request, response);
        }else{
            request.setAttribute("error","用户名或密码有误");
            request.getRequestDispatcher("BlogLogin").forward(request, response);
        }
    }
}
