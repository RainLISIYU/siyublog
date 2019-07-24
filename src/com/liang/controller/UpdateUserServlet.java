package com.liang.controller;

import com.liang.po.User;
import com.liang.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] values = request.getParameterValues("hobby");
        StringBuilder hobby = new StringBuilder("");
        int gender = 0;
        if (values != null) {
            for (String s : values) {
                hobby.append(s);
            }
        }
        String g = request.getParameter("gender");
        if (g != null){
            gender = Integer.parseInt(g);
        }

        User user = new User();
        user.setuName(request.getSession().getAttribute("uName").toString());
        user.setuPassword(request.getParameter("password"));
        user.setuPhoneNumber(request.getParameter("phonenumber"));
        user.setuEmail(request.getParameter("email"));
        user.setuGender(gender);
        user.setuHobby(hobby.toString());
        user.setuMessage(request.getParameter("message"));

        UserService us = new UserService();

        boolean flag = us.updateUser(user);

        if (flag){
            request.getRequestDispatcher("PersonalCenterServlet").forward(request, response);
        }

    }
}
