<%--
  Created by IntelliJ IDEA.
  User: 梁思禹
  Date: 2019/6/11
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${sessionScope.uName}的博客</title>
    <link rel="stylesheet" href="<% request.getContextPath(); %>/css/personalcenter.css"/>
    <link rel="stylesheet" href="<% request.getContextPath();%>/css/personalmessage.css"/>
    <script rel="script" src="<% request.getContextPath();%>/js/addessay.js"></script>
</head>
<body>
<div class="personal-message-body">
    <div class="personal-center-title">
        <div class="personal-name">
            <a href="#" style="text-decoration: none" >${sessionScope.uName}</a>
        </div>
        <div class="personal-center-title-buttons">
            <div class="essay-manage">
                <a href="#" style="text-decoration: none">文档管理</a>
            </div>
            <div class="personal-message-manage">
                <a href="PersonalCenterServlet" style="text-decoration: none">个人信息&nbsp;&nbsp;</a>
            </div>
            <div class="personal-message-manage">
                <a href="GoBlogCenterServlet" style="text-decoration: none">回到首页&nbsp;&nbsp;</a>
            </div>
        </div>
    </div>
    <div class="left-area">
        <div class="left-area-check" onclick="showPage1()">
            编写文章
        </div>
        <div class="left-area-update" onclick="showPage2()">
            管理文章
        </div>
    </div>
    <div class="middle-essay1" id="middle-essay1" style="margin-left: 250px;margin-top: 150px;display: none">
        <form action="AddEssayServlet" method="post">
            <textarea name="essay" id="essay" cols="10" rows="10" style="font-size: 20px;margin: 0px; width: 874px; height: 319px;resize:none;outline:none;"></textarea>
            <div class="submit-button">
                <span><input type="checkbox" name="ePower" value="1">仅自己可见</span>
                <input type="submit" value="发表" onclick="return checkEssay()&&alert('添加成功')" style="float:right;margin-right:76px;border: 0;background: aquamarine;width: 150px;border-radius: 10px"/>
            </div>
        </form>
    </div>
    <div class="middle-essay2" id="middle-essay2" style="margin-left: 250px;margin-top: 150px;display: block;">
        <style type="text/css">
            table {
                table-layout:fixed;
            }
            td {
                overflow:hidden;
                word-break:keep-all;
                text-overflow:ellipsis
            }
        </style>
        <table class="tb" style="border-collapse: collapse;width: 600px;background: white;border: 1px solid black;margin-left: 150px">
            <tr style="text-align: center">
                <td>用户</td>
                <td>类型</td>
                <td>内容</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${essays}" var="essay">
                <tr>
                    <td class="q" style="text-align: center">${essay.uName}</td>
                    <td style="text-align: center">文章</td>
                    <td class="m" >${essay.essay}</td>
                    <td class="h">
                        <a href="DeleteEssayServlet?eId=${essay.eId}">删除</a>&nbsp;&nbsp;|&nbsp;
                        <a href="UpdatePowerServlet?eId=${essay.eId}&ePower=${essay.ePower}">
                            <c:if test="${essay.ePower==1}">
                                设为公开
                            </c:if>
                            <c:if test="${essay.ePower==0}">
                                设为私密
                            </c:if>
                        </a>
                    </td>
                </tr>
                <c:forEach items="${essay.replies}" var="reply">
                    <tr>
                        <td class="q" style="text-align: center">${reply.uName}</td>
                        <td style="text-align: center">回复</td>
                        <td class="m" >${reply.reply}</td>
                        <td class="h">
                            <a href="DeleteReplyServlet?rId=${reply.rId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
