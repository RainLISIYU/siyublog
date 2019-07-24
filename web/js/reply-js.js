function showReply(eId) {
    var str = document.getElementById("siyu-body-reply-content"+eId).style.display;

    if (str == "none") {
        document.getElementById("siyu-body-reply-content"+eId).style.display = "block";
        document.getElementById("reply-button"+eId).innerHTML = "收起";
    }else{
        document.getElementById("siyu-body-reply-content"+eId).style.display = "none";
        document.getElementById("reply-button"+eId).innerHTML = "回复";
    }
}
function checkReply(eId) {
    var str = document.getElementById("reply"+eId).value;
    if (str.length === 0){
        alert("回复不能为空!");
        return false;
    }
    return true;
}

function checkSession(uName){
    if (uName == null){
        alert("登陆后继续");
        return true;
    }
    return true;
}