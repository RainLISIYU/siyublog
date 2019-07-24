function checkEssay(){
    var str = document.getElementById("essay").value;
    if (str.length === 0){
        alert("不能为空");
        return false;
    }
    return true;
}
function showPage1() {
    document.getElementById("middle-essay1").style.display = "block";
    document.getElementById("middle-essay2").style.display = "none";
}
function showPage2() {
    document.getElementById("middle-essay2").style.display = "block";
    document.getElementById("middle-essay1").style.display = "none";
}