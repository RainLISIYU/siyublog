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
            "<font color='red'>密码不符合规范</font>"
        return false;
    }
}

function checkAll() {
    if (checkName() && checkPassword()){
        return true;
    }else{
        return false;
    }
}


