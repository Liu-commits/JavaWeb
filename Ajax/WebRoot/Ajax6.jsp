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
    
    <title>My JSP 'Ajax6.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<c:url value='ajax-lib/ajaxutils.js'/>"></script>
<script type="text/javascript">
window.onload = function(){
	var btn = document.getElementById("btn");
	btn.onclick = function(){
		ajax(
		{
			url:"<c:url value='/DServlet'/>",
			type:"json",
			callback:function(data){
				document.getElementById("h3").innerHTML = data.name+","+data.age+","+data.sex;
			}
		}
		);
	};

}
</script>
  </head>
  
  <body>
  <button id="btn">点击这里</button>
	<h1>演示自己封装的工具</h1>
	<h3 id="h3"></h3>
  </body>
</html>
