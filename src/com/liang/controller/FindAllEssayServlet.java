package com.liang.controller;

import com.liang.dao.ReplyDao;
import com.liang.daoimpl.ReplyDaoImpl;
import com.liang.po.Essay;
import com.liang.po.Reply;
import com.liang.service.EssayService;
import com.liang.service.ReplyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * @author 梁思禹
 */
@WebServlet(name = "FindAllEssayServlet", urlPatterns = "/FindAllEssayServlet")
public class FindAllEssayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EssayService es = new EssayService();
        List<Essay> essays;
        essays = es.findAll();

        /*System.out.println(essays);*/

        request.setAttribute("essays",essays);

        request.getRequestDispatcher("BlogCenter").forward(request, response);
    }
}
