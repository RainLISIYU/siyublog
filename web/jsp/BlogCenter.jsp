<%--
  Created by IntelliJ IDEA.
  User: 梁思禹
  Date: 2019/6/2
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>私语微博</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/blogcenter.css"/>
    <script rel="script" src="<%request.getContextPath();%>/js/reply-js.js"></script>
</head>
<body style="background: cadetblue;">
<script type="text/javascript" src="<%request.getContextPath();%>/js/canvas-nest.min.js"></script>
<canvas height="926" width="1920" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;" id="c_n1"></canvas>
<div class="siyu-header">
    <div class="siyu-header-wrap">
        <div class="siyu-header-bd">
            <img style="height: 60px;float: left;" title="私语微博" src="<%request.getContextPath();%>/image/logo1.jpg">
            <span class="siyu-header-logo">私语微博</span>
            <div class="siyu-header-search">
                <form action="SearchUserEssayServlet" method="post" class="siyu-header-search-form">
                    <div class="siyu-header-search-input">
                        <input type="text" id="text" name="text" placeholder="用户名">
                        <input type="submit" value="搜索" />
                    </div>
                </form>
            </div>
            <div class="siyu-header-personcenter">
                <c:if test="${sessionScope.uName != null}">
                    <span style="font-size: 15px;">欢迎，${sessionScope.uName}</span>
                </c:if>
                <c:if test="${sessionScope.uName == null}">
                    <span ><a href="BlogLogin" style="text-decoration: none;">登陆</a></span>
                </c:if>&nbsp;|
                <a style="text-decoration: none" href="PersonalCenterServlet" onclick="checkSession(${sessionScope.uName})">个人中心</a>&nbsp;|
                <a style="text-decoration: none" href="QuitPageServlet">退出</a>
            </div>
        </div>
    </div>
</div>
<c:forEach items="${bPage.essays}" var="essay">
    <div class="siyu-body-title">
        <a style="text-decoration: none;color: black" href="#">${essay.uName}</a>
    </div>
    <div class="siyu-body-content">${essay.essay}</div>
    <div class="siyu-body-reply">
        <div class="reply-button" id="reply-button${essay.eId}" onclick="showReply(${essay.eId})">
            回复
        </div>
        <div class="date-button">
            发布于${essay.eDate}
        </div>
    </div>
    <div class="siyu-body-reply-content" id="siyu-body-reply-content${essay.eId}" style="display: none">
        <input type="hidden" id="reply-button-value" value="${essay.eId}"/>
        <c:forEach items="${essay.replies}" var="reply">
            <div class="siyu-body-replyContent">
                <div class="reply-content-title">
                        ${reply.uName}
                </div>
                <div class="reply-content-body">
                        ${reply.reply}
                </div>
                <div class="reply-content-buttom">
                    <div style="float: right;margin-right: 20px">${reply.rDate}</div>
                </div>
            </div>
        </c:forEach>
        <div class="reply-area">
            <form action="InsertReplyServlet?eId=${essay.eId}" method="post" onsubmit="return checkReply(${essay.eId})&&checkSession(${uName});">
                <div class="reply-textarea">
                    <textarea name="reply" placeholder="写的什么吧" id="reply${essay.eId}" style="font-size: 18px;resize:none;outline:none;" cols="69" rows="4"></textarea>
                </div>
                <div class="reply-area-button">
                    <div class="area-button">
                        <input type="submit" style="cursor: pointer;border: none;background: none;outline: none;width: 100%;height: 100%" value="发表">
                    </div>
                </div>
            </form>
        </div>
    </div>
</c:forEach>
<div class="siyu-body-title">
    页数${bPage.currentPage}/${bPage.countPage}&nbsp;&nbsp;总微博数：${bPage.allCount}&emsp;&emsp;&emsp;&emsp;
    <c:forEach begin="1" end="${bPage.countPage}" var="i">
        <c:if test="${bPage.currentPage==i}">
            ${i}
        </c:if>
        <c:if test="${bPage.currentPage!=i}">
            <%--查询分页--%>
            <c:if test="${sUser == 1}"><a href="SearchUserEssayServlet?currentPage=${i}&text=${text1}"> ${i}</a></c:if>
            <%--总分页--%>
            <c:if test="${sUser == 0}"><a href="FindSomeEssayServlet?currentPage=${i}"> ${i}</a></c:if>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
