<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Ajax3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}

	window.onload = function(){
	//监听用户名失去焦点事件
	var userEle = document.getElementById("usernameEle");
	userEle.onblur = function(){
		//得到异步对象
		xmlHttp = createXMLHttpRequest();
		//打开
		xmlHttp.open("POST","<c:url value='/VUsername'/>",true);
		//设置头
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//发送内容
		xmlHttp.send("username=" + userEle.value);
		xmlHttp.onreadystatechange = function(){
		
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			
				var text = xmlHttp.responseText;
				var span = document.getElementById("error");
				if(text == "1"){
					
					
					span.innerHTML = "用户名已存在";
				}else{
				
					span.innerHTML = "用户名可用";
				}
				
				
				
			
			
			
			}
		
		
		}
	}
	
	}
	
	</script>
  </head>
  
  <body>
    <h2>用户名的校验</h2>
   <form action="" method="post">
   用户名：<input type="text" name="username" id="usernameEle"><span id="error"></span><br/>
   密     码：   <input type="passowrd" id="password" name="password"><br/>
   <input type="submit" value="注册">
   </form>
  </body>
</html>
