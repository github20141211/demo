var xmlHttp;
function createXMLHttpRequest() {
    if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function beginCheck() {
    //var tempLoginName = document.all.loginName.value;
    var tempLoginName = document.getElementById("loginName").value;
    if(tempLoginName == "") {
        alert("对不起，请您输入注册名");
        return;
    }

    alert("输入的用户为" + tempLoginName);
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = processor;
    xmlHttp.open("POST", "/checkUser/" + tempLoginName);
    xmlHttp.send(null);
}

function processor() {
    var responseContext;
    if(xmlHttp.readyState == 4) {
        if(xmlHttp.status == 200) {
            responseContext = xmlHttp.responseText;
            if(responseContext.indexOf("true")!=-1) {
                alert("恭喜您，该注册名有效");
            }else {
                alert("对不起，该注册名已经被使用");
            }
        }
    }
}