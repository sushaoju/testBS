<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jyj.entity.Patient" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/pj.js"></script>
  </head>
  
  <body>
  	<% Patient patient=(Patient)request.getAttribute("patient"); %>
    <form  id="ff" method="post">
  	<input type="hidden" name="reqCode" value="updatepatient">
    <table  style="width:100%" border="1" bordercolor="#99ccff" cellspacing="0">
    
		<tr>
		<td align="right">病人编号：</td><td><input type="text" name="id" value="<%=patient.getId() %>" ></td>
		</tr>
		<tr>
		<td align="right">帐号：</td><td><input type="text"  name="account" value="<%=patient.getAccount() %>"></td>
		</tr>
		<tr>
		<td align="right">密码：</td><td><input type="password" name="pwd" value="<%=patient.getPwd() %>"></td>
		</tr>
		<tr>
		<td align="right">姓名：</td><td><input type="text" name="name" value="<%=patient.getName() %>"></td>
		</tr>
		<tr>
		<td align="right">级别：</td><td><input type="text" name="jibie" value="<%=patient.getJibie() %>"></td>
		</tr>
		<tr>
		<td align="right">年龄：</td><td><input type="text" name="age" value="<%=patient.getAge() %>"></td>
		</tr>
		<tr>
		<td align="right">性别：</td><td><input type="text" name="sex" value="<%=patient.getSex() %>"></td>
		</tr>
		<tr>
		<td align="right">电话：</td><td><input type="text" name="number" value="<%=patient.getNumber() %>"></td>
		</tr>
		<tr>
		<td align="right">地址：</td><td><input type="text" name="address" value="<%=patient.getAddress() %>"></td>
		</tr>
	</table>
</form>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="shut();">关闭</a>
	    </div>
	    <script>
	function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/PatientServlet",
				onSubmit:function(){
					
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					$.messager.alert('提示',data,'info');
				}
				
			});
		}
		function shut(){
		window.parent.$("#tt").tabs("close","修改管理用户")}
		
		</script>
  </body>
</html>
