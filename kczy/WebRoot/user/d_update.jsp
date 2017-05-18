<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jyj.entity.Doctor" %>

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
  	<% Doctor doctor=(Doctor)request.getAttribute("doctor"); %>
    <form  id="ff" method="post">
  	<input type="hidden" name="reqCode" value="updatedoctor">
    <table  style="width:100%" border="0" bordercolor="#99ccff" cellspacing="0">
    
		<tr>
		<td align="right">病人编号：</td><td><input type="text" name="id" value="<%=doctor.getId() %>" ></td>
		</tr>
		<tr>
		<td align="right">帐号：</td><td><input type="text"  name="account" value="<%=doctor.getAccount() %>"></td>
		</tr>
		<tr>
		<td align="right">密码：</td><td><input type="password" name="pwd" value="<%=doctor.getPwd() %>"></td>
		</tr>
		<tr>
		<td align="right">姓名：</td><td><input type="text" name="d_name" value="<%=doctor.getD_name() %>"></td>
		</tr>
		<tr>
		<td align="right">级别：</td><td><input type="text" name="jibie" value="<%=doctor.getJibie() %>"></td>
		</tr>
		<tr>
		<td align="right">年龄：</td><td><input type="text" name="age" value="<%=doctor.getAge() %>"></td>
		</tr>
		<tr>
		<td align="right">性别：</td><td><input type="text" name="sex" value="<%=doctor.getSex() %>"></td>
		</tr>
		<tr>
		<td align="right">电话：</td><td><input type="text" name="phone" value="<%=doctor.getPhone() %>"></td>
		</tr>
		<tr>
		<td align="right">地址：</td><td><input type="text" name="address" value="<%=doctor.getAddress() %>"></td>
		</tr>
		<tr>
		<td align="right">科室编号：</td><td><input type="text" name="ksbh" value="<%=doctor.getKsbh() %>"></td>
		</tr>
		<tr>
		<td align="right">所在科室：</td><td><input type="text" name="szks" value="<%=doctor.getSzks() %>"></td>
		</tr>
		<tr>
		<td align="right">职称：</td><td><input type="text" name="zc" value="<%=doctor.getZc() %>"></td>
		</tr>
		<tr>
		<td align="right">所在医院：</td><td><input type="text" name="szyy" value="<%=doctor.getSzyy() %>"></td>
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
				url:"<%=request.getContextPath()%>/servlet/DoctorServlet",
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
