package com.liang.controller;

import com.liang.dao.ReplyDao;
import com.liang.daoimpl.ReplyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindAllReplyServlet")
public class FindAllReplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReplyDao rd = new ReplyDaoImpl();
        rd.findAllReply(Integer.parseInt(request.getParameter("eId")));
    }
}
