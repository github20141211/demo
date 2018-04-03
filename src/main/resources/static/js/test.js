var xmlHttp;
function createXMLHttpRequest() {
    if(window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}
function begin() {
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = processor;
    xmlHttp.open("GET", "test.xml");
    xmlHttp.send(null);
}
function processor() {
    if(xmlHttp.readyState == 4) {
        if(xmlHttp.status == 200) {
            alert("从服务器返回的内容为：" + xmlHttp.responseText);
        }
    }

}