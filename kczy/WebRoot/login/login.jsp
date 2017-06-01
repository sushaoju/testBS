<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
  </head>
  
  <body background="../image/y.jpg">
  <img src="../image/7.jpg">
    <div id="dlg" class="easyui-dialog" title="登录" data-options="closed:false" 
     style="width:450px;height:290px;padding:10px">   
    <form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post">
    <p>
    <img src="../image/1.jpg" / align="left">
    <font face="黑体" size=5 color="purple" weight:bold>欢迎来到简医家 !<h2><br><br></font>

<div align="right">
<a href="<%=request.getContextPath()%>/login/p_login.jsp" class="easyui-linkbutton" data-options="plain:true">患者登录</a>
<a href="<%=request.getContextPath()%>/user/p_add.jsp" class="easyui-linkbutton" data-options="plain:true">患者注册</a><br>   
<a href="<%=request.getContextPath()%>/login/d_login.jsp" class="easyui-linkbutton" data-options="plain:true" >医生登录</a> 
<a href="<%=request.getContextPath()%>/user/d_add.jsp" class="easyui-linkbutton" data-options="plain:true">医生注册</a><br> 
<a href="<%=request.getContextPath()%>/login/a_login.jsp" class="easyui-linkbutton" data-options="plain:true">管理员登录</a>


</div>
   
    </p>
    </form>
    </div>
    
  </body>
</html>
