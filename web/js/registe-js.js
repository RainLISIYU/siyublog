function checkName() {
    var str = document.getElementById("username").value;
    var reg = /^[a-zA-Z]+[0-9a-zA-Z]+$/;
    if (reg.test(str) && str.length > 6 && str.length < 12){
        document.getElementById("name_tips").innerHTML = "";
        return true;
    }else{
        document.getElementById("name_tips").innerHTML = "" +
            "<font color='red'>用户名不规范</font>";
        return false;
    }
}

function checkPassword() {
    var str = document.getElementById("password").value;
    var reg = /^[0-9a-zA-Z\u4e00-\u9fa5]+$/;
    if (reg.test(str) && str.length > 6 && str.length < 12){
        document.getElementById("password_tips").innerHTML = "";
        return true;
    }else{
        document.getElementById("password_tips").innerHTML = "" +
            "<font color='red'>密码不符</font>";
        return false;
    }
}

function checkPhoneNumber() {
    var str = document.getElementById("phonenumber").value;
    var reg = /^1[34578]\d{9}$/;
    if (reg.test(str) && str.length > 6 && str.length < 12){
        document.getElementById("phonenumber_tips").innerHTML = "";
        return true;
    }else{
        document.getElementById("phonenumber_tips").innerHTML = "" +
            "<font color='red'>输入正确手机号</font>";
        return false;
    }
}

function checkEmail() {
    var str = document.getElementById("email").value;
    var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    if (reg.test(str) && str.length > 6){
        document.getElementById("email_tips").innerHTML = "";
        return true;
    }else{
        document.getElementById("email_tips").innerHTML = "" +
            "<font color='red'>输入正确的邮箱</font>";
        return false;
    }
}

function checkDPassword() {
    var str1 = document.getElementById("password").value;
    var str2 = document.getElementById("dpassword").value;
    var reg = /^[0-9a-zA-Z\u4e00-\u9fa5]+$/;
    if (reg.test(str2) && str2.length > 6 && str2.length < 12){
        document.getElementById("dpassword_tips").innerHTML = "";
    }else{
        document.getElementById("dpassword_tips").innerHTML = "" +
            "<font color='red'>密码不符合规范</font>";
        return false;
    }
    if (str1 === str2){
        return true;
    }else{
        document.getElementById("dpassword_tips").innerHTML = "" +
            "<font color='red'>两次密码不同</font>";
    }

}

function showPage1() {
    document.getElementById("middle-area1").style.display = "block";
    document.getElementById("middle-area2").style.display = "none";
}
function showPage2() {
    document.getElementById("middle-area2").style.display = "block";
    document.getElementById("middle-area1").style.display = "none";
}
function checkAll() {
    if (checkName()&& checkPassword()&& checkDPassword()&& checkPhoneNumber()&& checkEmail()){
        alert("注册成功，将跳转登陆界面");
        return true;

    }else{
        return false;
    }
}

function ajaxFunction() {
    var xmlHttp;
    try {
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("浏览器不支持AJAX");
                return false;
            }
        }
    }
    return xmlHttp;
}

function checkUNameExist() {
    var xmlHttp = ajaxFunction();
    xmlHttp.open("post","CheckUserNameServlet",true);
    xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlHttp.send("uName="+document.getElementById("username").value);
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
            var num = xmlHttp.responseText;
            if (num === "1"){
                document.getElementById("name_tips").innerHTML = "<font color='red'>用户名已被使用</font>";
                return false;
            }
        }
    };
    return true;
}
