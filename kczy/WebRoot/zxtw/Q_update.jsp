<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jyj.entity.Question" %>

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
  	<% Question question=(Question)request.getAttribute("question"); %>
    <form  id="ff" method="post">
  	<input type="hidden" name="reqCode" value="updatequestion">
    <table  style="width:100%" border="0" bordercolor="#99ccff" cellspacing="0">
    
		<tr>
		<td align="right">问题编号：</td><td><input type="text" name="question_id" value="<%=question.getQuestion_id() %>" ></td>
		</tr>
		<tr>
		<td align="right">问题名称：</td><td><input type="text"  name="question_name" value="<%=question.getQuestion_name() %>"></td>
		</tr>
		<tr>
		<td align="right">提问日期：</td><td><input type="text" class="easyui-datebox" name="question_date" value="<%=question.getQuestion_date() %>"></td>
		</tr>
		<tr>
		<td align="right">病人编号：</td><td><input type="text" name="patient_id" value="<%=question.getPatient_id() %>"></td>
		</tr>
		<tr>
		<td align="right">病人姓名：</td><td><input type="text" name="patient_name" value="<%=question.getPatient_name() %>"></td>
		</tr>
		<tr>
		<td align="right">病人帐号：</td><td><input type="text" name="patient_account" value="<%=question.getPatient_account() %>"></td>
		</tr>
	</table>
</form>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="shut();">关闭</a>
	    	<h1><a href="<%=request.getContextPath()%>/index.jsp">返回到首页</a><h1>
	    </div>
	    <script>
	function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/QuestionServlet",
				onSubmit:function(){
					
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					$.messager.alert('提示',data,'info');
				}
				
			});
		}
		function shut(){
		window.parent.$("#tt").tabs("close","问题信息")}
		
		</script>
  </body>
</html>
