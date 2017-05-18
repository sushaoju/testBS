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
  
  <body background="../image/9.jpg">
    <div id="dlg" class="easyui-dialog" title="登录" data-options="closed:false" style="background-image:url(<%=request.getContextPath() %>/image/9.jpg);width:400px;height:200px;padding:10px">
    <form action="<%=request.getContextPath()%>/servlet/A_LoginServlet" method="post">
    <p>
    <label>管理员帐号：</label>
    <input type="text" name="account">
    </p>
    <p>
    <label>密&nbsp;&nbsp;码：</label>
    <input type="password" name="pwd">
    </p>
    <p>
    <input type="submit" name="login">
    </p>
    </form>
    </div>  
  </body>
</html>
