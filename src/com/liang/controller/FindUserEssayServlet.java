package com.liang.controller;

import com.liang.po.Essay;
import com.liang.po.Page;
import com.liang.service.EssayService;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindUserEssayServlet",urlPatterns = "/FindUserEssayServlet")
public class FindUserEssayServlet extends HttpServlet {
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
        EssayService es = new EssayService();
        List<Essay> essays = es.findUserAllEssay(uName);
        request.setAttribute("essays",essays);
        request.getRequestDispatcher("PersonalEssayPage").forward(request, response);
    }
}
