<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户检查</title>
    <script type="text/javascript" src="/js/checkUser.js"></script>
</head>
<body>
用户检查
    <#--<#list userList as item>-->
        <#--${item!}<br/>-->
    <#--</#list>-->

<form name="form1" action="saveUser" method="POST">
    请输入注册用户名
    <input name="loginName" type="text" id="loginName">
    <input type="button" name="checkLoginName" value="有效性检查" onclick="beginCheck()">
    <input type="submit" value="提交" />
</form>
</body>
</html>