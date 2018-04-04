<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'index.jsp' starting page, edit by myeclipse, edit by github</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="./static/jquery/jquery.min.js"></script>
	<script src="./js/index.js"></script>
  </head>
  <body>
   <div class="userInfo">
   	<br><label>学号：&nbsp;&nbsp;</label><input name="stuId" type="text" value=""/><br>
   	<br><label>姓名：&nbsp;&nbsp;</label><input name="stuName" type="text" value=""/><br>
   	<br><label>手机号码：</label><input name="phone" type="text" value=""/><br>
   	<br><label>身份证号：</label><input name="idNumber" type="text" value=""/><br>
   	<br><button id="queryBtn">查询</button><button id="saveBtn">保存</button><br>
   </div>
  </body>
</html>
