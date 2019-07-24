<%@ page import="com.liang.po.User" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 梁思禹
  Date: 2019/6/10
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${sessionScope.uName}的博客</title>
    <link rel="stylesheet" href="<% request.getContextPath(); %>/css/personalcenter.css"/>
    <link rel="stylesheet" href="<% request.getContextPath();%>/css/personalmessage.css"/>
    <script rel="script" src="<%request.getContextPath();%>/js/registe-js.js"></script>
    <script>
        function showPassword() {
            var str = document.getElementById("password").type;
            if (str === "password"){
                document.getElementById("password").type = "text";
            }else{
                document.getElementById("password").type = "password";
            }
        }
    </script>
</head>
<body>

<div class="personal-message-body">
    <div class="personal-center-title">
        <div class="personal-name">
            <a href="#" style="text-decoration: none" >欢迎，${sessionScope.uName}</a>
        </div>
        <div class="personal-center-title-buttons">
            <div class="essay-manage">
                <a href="FindUserEssayServlet" style="text-decoration: none">文档管理</a>
            </div>
            <div class="personal-message-manage">
                <a href="#" style="text-decoration: none">个人信息&nbsp;&nbsp;</a>
            </div>
            <div class="personal-message-manage">
                <a href="GoBlogCenterServlet" style="text-decoration: none">回到首页&nbsp;&nbsp;</a>
            </div>
        </div>
    </div>
    <div class="left-area">
        <div class="left-area-check" onclick="showPage1()">
            查看信息
        </div>
        <div class="left-area-update" onclick="showPage2()">
            更新信息
        </div>
    </div>
    <div class="middle-area1" id="middle-area1" style="display: block;">
        <ul style="margin-top: 20px">
            <li>
                <div>
                    <span class="q">用户名：</span>
                    <span class="h">
                        <input type="text" readonly="readonly" value="${user.uName}"/>
                    </span>
                </div>
            </li>
            <li>
                <div>
                    <span class="q">手机号：</span>
                    <span class="h">
                        <input type="text" readonly="readonly" value="${user.uPhoneNumber}"/>
                    </span>
                </div>
            </li>
            <li>
                <div>
                    <span class="q">邮箱：</span>
                    <span class="h">
                        <input type="text" readonly="readonly" value="${user.uEmail}"/>
                    </span>
                </div>
            </li>
            <li>
                <div>
                    <span class="q">注册时间：</span>
                    <span class="h">
                        <input type="text" readonly="readonly" value="${user.uDate}"/>
                    </span>
                </div>
            </li>
            <li>
                <span class="q">性别：</span>
                <span class="h">
                    <input type="radio" value="0" onclick="return false;"
                    <c:if test="${user.uGender==0}">checked</c:if>
                           name="gender">男

                    <input type="radio" value="1" onclick="return false;"
                           <c:if test="${user.uGender==1}">checked</c:if>
                           name="gender">女
                </span>
            </li>
            <li>
                <span class="q">爱好：</span>
                <span class="h">
                        <input type="checkbox" name="hobby" onclick="return false;"
                               <%
                                    User user = (User)request.getAttribute("user");
                                    String hobbies = user.getuHobby();
                                    if (hobbies != null){
                                        if (hobbies.contains("1")){
                               %>
                                checked
                               <%
                                        }
                               %>
                               value="1">阅读
                        <input type="checkbox" name="hobby" onclick="return false;"
                                <%
                                        if (hobbies.contains("2")){
                               %>
                               checked
                               <%
                                        }
                               %>
                               readonly value="2">音乐
                        <input type="checkbox" name="bobby" onclick="return false;"
                                <%
                                        if (hobbies.contains("3")){
                               %>
                               checked
                               <%
                                        }
                                    }
                               %>
                               readonly value="3">运动
                    </span>
            </li>
            <li style="height: 100px">
                <span class="q" style="height: 100%">个人介绍：</span>
                <span class="h" style="height: 100%;">
                        <textarea name="message" readonly="readonly" cols="20" rows="3" style="resize:none;outline:none;">${user.uMessage}</textarea>
                    </span>
            </li>
        </ul>
    </div>
    <div class="middle-area2" id="middle-area2" style=" display: none;">
        <form action="UpdateUserServlet" method="post">
            <ul style="margin-top: 20px">
                <li>
                    <div>
                        <span class="q">用户名：</span>
                        <span class="h">
                            <input type="text" id="username" name="username" readonly="readonly" value="${user.uName}"/>
                        </span>
                    </div>
                </li>
                <li>
                    <div>
                        <span class="q">密码：</span>
                        <span class="h">
                            <input type="password" id="password" name="password" onblur="checkPassword()" onkeyup="checkPassword()" value="${user.uPassword}"/>
                            <span style="cursor: pointer" onclick="showPassword()" >显示</span>
                        </span>
                        <span id="password_tips"></span>
                    </div>
                </li>
                <li>
                    <div>
                        <span class="q">手机号：</span>
                        <span class="h">
                            <input type="text" id="phonenumber" name="phonenumber" onblur="checkPhoneNumber()" onkeyup="checkPhoneNumber()" value="${user.uPhoneNumber}"/>
                        </span>
                        <span id="phonenumber_tips"></span>
                    </div>
                </li>
                <li>
                    <div>
                        <span class="q">邮箱：</span>
                        <span class="h">
                            <input type="text" id="email" name="email"  onblur="checkEmail()" onkeyup="checkEmail()" value="${user.uEmail}"/>
                        </span>
                        <span id="email_tips"></span>
                    </div>
                </li>
                <li>
                    <div>
                        <span class="q">注册时间：</span>
                        <span class="h">
                            <input type="text" readonly="readonly" value="${user.uDate}"/>
                        </span>
                    </div>
                </li>
                <li>
                    <span class="q">性别：</span>
                    <span class="h">
                        <input type="radio" value="0" name="gender">男
                        <input type="radio" value="1" name="gender">女
                    </span>
                </li>
                <li>
                    <span class="q">爱好：</span>
                    <span class="h">
                        <input type="checkbox" name="hobby" value="1"/>阅读
                        <input type="checkbox" name="hobby" value="2"/>音乐
                        <input type="checkbox" name="hobby" value="3"/>运动
                    </span>
                </li>
                <li style="height: 50px">
                    <span class="q" style="height: 100%">个人介绍：</span>
                    <span class="h" style="height: 100%;">
                        <textarea name="message" cols="20" rows="3" style="resize:none;outline:none;"></textarea>
                    </span>
                </li>
                <div class="message-button">
                    <input type="submit" class="message-submit-button"  value="提交保存"/>
                </div>
            </ul>
        </form>
    </div>
</div>
</body>
</html>
