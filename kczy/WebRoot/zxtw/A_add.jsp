<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jyj.entity.Answer" %>

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
  	
    <form  id="ff" method="post">
  	<input type="hidden" name="reqCode" value="addanswer">
    <table  style="width:100%" border="0" bordercolor="#99ccff" cellspacing="0">
    
		<tr>
		<td align="right">问题编号：</td><td><input type="text" name="question_id"  ></td>
		</tr>
		<tr>
		<td align="right">答案名称：</td><td><input type="text" name="answer_name" "></td>
		</tr>
		<tr>
		<td align="right">回答日期：</td><td><input type="text" class="easyui-datebox" name="answer_date" ></td>
		</tr>
		<tr>
		<td align="right">医生编号：</td><td><input type="text" name="doctor_id" ></td>
		</tr>
		<tr>
		<td align="right">医生姓名：</td><td><input type="text" name="doctor_name" ></td>
		</tr>
		<tr>
		<td align="right">医生帐号：</td><td><input type="text" name="doctor_account" ></td>
		</tr>
	</table>
</form>
		<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    	<h1><a href="<%=request.getContextPath()%>/index2.jsp">返回</a></h1>
	    </div>
	    <script>
	function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/AnswerServlet?reqCode=addanswer",
				onSubmit:function(){
					
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					$.messager.alert('提示',data,'info');
				}
				
			});
		}
		function shut(){
		window.parent.$("#tt").tabs("close","问题答案信息")}
		
		</script>
  </body>
</html>
