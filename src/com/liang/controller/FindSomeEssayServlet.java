package com.liang.controller;

import com.liang.po.Page;
import com.liang.service.EssayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindSomeEssayServlet", urlPatterns = "/FindSomeEssayServlet")
public class FindSomeEssayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EssayService es = new EssayService();
        int currentPage = 1;
        String str = request.getParameter("currentPage");
        if (str != null){
            currentPage = Integer.parseInt(str);
        }
        Page page = es.getPage(currentPage);
        request.setAttribute("bPage",page);
        /*默认为查找所有用户微博*/
        request.setAttribute("sUser",0);
        request.getRequestDispatcher("BlogCenter").forward(request, response);
    }
}
