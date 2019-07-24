package com.liang.controller;

import com.liang.dao.ReplyDao;
import com.liang.po.Reply;
import com.liang.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "InsertReplyServlet",urlPatterns = "/InsertReplyServlet")
public class InsertReplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getSession().getAttribute("uName") == null){
            request.getRequestDispatcher("BlogLogin").forward(request, response);
        }
        String uName = request.getSession().getAttribute("uName").toString();
        int eId = Integer.parseInt(request.getParameter("eId"));
        String reply = request.getParameter("reply");
        Date rDate = new Date(System.currentTimeMillis());
        Reply reply1 = new Reply();
        reply1.setuName(uName);
        reply1.seteId(eId);
        reply1.setReply(reply);
        reply1.setrDate(rDate);
        ReplyService rs = new ReplyService();
        rs.insertReply(reply1);
        request.getRequestDispatcher("FindSomeEssayServlet").forward(request, response);
    }
}
