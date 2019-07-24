<%--
  Created by IntelliJ IDEA.
  User: 梁思禹
  Date: 2019/5/6
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>微博登陆</title>
    <link rel="stylesheet" href="<%request.getContextPath();%>/css/logincss.css">
    <script rel="script" src="<%request.getContextPath();%>/js/Login_Test.js"></script>
</head>
<body onload="return checkFlag(${requestScope.flag});">
<div class="head">
    <div id="tile">
        <a href="#">私语微博</a>
    </div>
</div>
<form action="CheckUserServlet" method="post" onsubmit="return checkAll();">
    <div class="body">
        <div id="login">
            <div class="login_body">
                <div class="radio">
                    <div class="radio1">
                        <span>用户登陆</span>
                    </div>
                </div>
                <ul>
                    <li>
                        <div>
                            <span class="q">用户名：</span>
                            <span class="h">
                                <input type="text" id="username" name="username" onblur="checkName()" onkeyup="checkName()"/>
                            </span>
                            <span id="name_tips"><font color="red" > ${error} </font> </span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <span class="q">密码：</span>
                            <span class="h">
                                <input type="password" id="password" name="password" onblur="checkPassword()" onkeyup="checkPassword()"/>
                            </span>
                            <span id="password_tips"></span>
                        </div>
                    </li>
                </ul>
                <div class="button" >
                    <input type="submit" name="userlogin" value="登&nbsp;&nbsp;&nbsp;&nbsp;陆"/>
                </div>
                <div class="registe">
                    <a href="FindSomeEssayServlet">游客登陆</a>/
                    <a href="Registe">立即注册</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
