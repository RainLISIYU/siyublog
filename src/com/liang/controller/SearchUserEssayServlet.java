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

@WebServlet(name = "SearchUserEssayServlet", urlPatterns = "/SearchUserEssayServlet")
public class SearchUserEssayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uName = request.getParameter("text");
        int currentPage = 1;
        String str = request.getParameter("currentPage");
        if (str != null){
            currentPage = Integer.parseInt(str);
        }
        EssayService es = new EssayService();
        Page page = es.getPage(currentPage, uName);
        request.setAttribute("text1",uName);
        request.setAttribute("bPage",page);
        request.setAttribute("sUser",1);
        request.getRequestDispatcher("BlogCenter").forward(request, response);
    }
}
