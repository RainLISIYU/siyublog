package com.liang.controller;

import com.liang.service.EssayService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdatePowerServlet", urlPatterns = "/UpdatePowerServlet")
public class UpdatePowerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EssayService es = new EssayService();
        int eId = Integer.parseInt(request.getParameter("eId"));
        int ePower = Integer.parseInt(request.getParameter("ePower"));
        es.updatePower(eId, ePower);
        response.sendRedirect("FindUserEssayServlet");
    }
}
