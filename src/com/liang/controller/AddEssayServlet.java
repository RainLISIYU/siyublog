package com.liang.controller;

import com.liang.po.Essay;
import com.liang.service.EssayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddEssayServlet", urlPatterns = "/AddEssayServlet")
public class AddEssayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String essay = request.getParameter("essay");
        int ePower = 0;
        String f = "ePower";
        if (request.getParameter(f)!= null){
            ePower = 1;
        }
        String uName = request.getSession().getAttribute("uName").toString();
        Date eDate = new Date(System.currentTimeMillis());
        Essay essay1 = new Essay();
        essay1.setEssay(essay);
        essay1.setuName(uName);
        essay1.seteDate(eDate);
        essay1.setePower(ePower);
        EssayService es = new EssayService();
        es.insertEssay(essay1);
        request.getRequestDispatcher("FindUserEssayServlet").forward(request, response);
//        response.sendRedirect();f
    }
}
