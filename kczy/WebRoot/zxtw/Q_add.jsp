<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Q_add.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/demo.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    <div class="easyui-panel" title="新增问题信息" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
			<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
				<input type="hidden" name="reqCode" value="addquestion" />
				<table cellpadding="5">
					<tr>
						<td>问题编号:</td>
						<td><input class="easyui-textbox" type="text" name="question_id"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>问题名称:</td>
						<td><input class="easyui-textbox" type="text" name="question_name"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>提问日期:</td>
						<td><input class="easyui-textbox" type="text" name="question_date"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>病人编号:</td>
						<td><input class="easyui-textbox" type="text" name="patient_id"
							data-options="required:false" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>病人姓名:</td>
						<td><input class="easyui-textbox" type="text" name="patient_name"
							data-options="required:false" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>病人帐号:</td>
						<td><input class="easyui-textbox" type="text" name="patient_account"
							data-options="required:false" style="width:200px"></input>
						</td>
					</tr>
				</table>
			</form>
			<div style="text-align:left;padding:5px">
			 	<a href="javascript:void(0)"   class="easyui-linkbutton" onclick="addquestion()">新增</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="shut()">关闭</a>
				<h1><a href="<%=request.getContextPath()%>/index.jsp">返回到首页</a><h1>
          	</div>
		</div>
	</div>

	<script>
	    function shut(){
	       parent.$('#tt').tabs('close','新增问题');
	    }
	
		$(function(){	
			$("#ssgs").attr("readonly",true);
		});
		
		
		function addquestion(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=addquestion",
								onSubmit : function() {
									return $(this).form('enableValidation')
											.form('validate');
								},
								success : function(data) {
									$.messager.alert('提示', data, 'info');
									$('#ff').form('clear');
								}
							});
		     }


	</script>
  </body>
</html>
