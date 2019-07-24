<%--
  Created by IntelliJ IDEA.
  User: 梁思禹
  Date: 2019/5/23
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link rel="stylesheet" href="<%request.getContextPath();%>/css/registe_css.css"/>
    <script rel="script" src="<%request.getContextPath();%>/js/registe-js.js"></script>
</head>
<body style="background: bisque;">
<form action="RegisteServlet" method="post" onsubmit="return checkAll()">
    <div class="body">
        <div class="title" style="background: url(<%request.getContextPath();%>/image/image1.jpg)">
            <span class="title_word">博客注册</span>
        </div>
        <div class="center" style="background: url(<%request.getContextPath();%>/image/image.jpg);">
            <div class="center_body">
                <div class="center_body_title">
                    <span>用户注册</span>
                </div>
                <ul>
                    <li>
                        <div>
                            <span class="q">用户名：</span>
                            <span class="h">
                                <input type="text" id="username" name="username" onblur="checkName()&&checkUNameExist()" onkeyup="checkName()"/>
                            </span>
                            <span id="name_tips"></span>
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
                    <li>
                        <div>
                            <span class="q">确认密码：</span>
                            <span class="h">
                                <input type="password" id="dpassword" name="dpassword" onblur="checkDPassword()" onkeyup="checkDPassword()"/>
                            </span>
                            <span id="dpassword_tips"></span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <span class="q">手机号：</span>
                            <span class="h">
                                <input type="phonenumber" id="phonenumber" name="phonenumber" onblur="checkPhoneNumber()" onkeyup="checkPhoneNumber()"/>
                            </span>
                            <span id="phonenumber_tips"></span>
                        </div>
                    </li>
                    <li>
                        <div>
                            <span class="q">邮箱：</span>
                            <span class="h">
                                <input type="email" id="email" name="email" onblur="checkEmail()" onkeyup="checkEmail()"/>
                            </span>
                            <span id="email_tips"></span>
                        </div>
                    </li>
                </ul>
                <div class="button" >
                    <input type="submit" name="user_registe" value="注&nbsp;&nbsp;&nbsp;&nbsp;册"/>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
