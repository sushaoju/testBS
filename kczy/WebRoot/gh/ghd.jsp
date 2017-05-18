<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>挂号单</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  
	</head>
  <body>
	
	<div class="easyui-panel" title="开处方管理" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
		<%String patientName =request.getParameter("patientName"); %>
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    
	    	<input type="hidden" name="reqCode" value="addUser"/>
	    	<table cellpadding="5">
	    	<tr>
	    	        <td>请正确填写您的账号:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="p_account" data-options="required:true"></td>
	    	</tr>	
	    	<tr>
	    	        <td>请正确填写您的年龄:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="p_age" data-options="required:true"></td>
	    	</tr>	
	    	<tr>
	    	        <td>请正确填写您的性别:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="p_sex" data-options="required:true"></td>
	    	</tr>
	    	<tr>
	    	        <td>请正确填写您的地址:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="p_address" data-options="required:true"></td>
	    	</tr>		
	    	
	    		<tr>
	    			<td>您挂号的医生:</td>
	    			<td><input class="easyui-textbox" type="text" name="d_name" 
	    				 data-options="required:true" style="width:200px"></input></td>
                </tr>
	    			<td>挂号科室:</td>
	    			<td><input class="easyui-textbox" type="text" name="szks" data-options="required:true" style="width:200px"></input></td>
	    		</tr>
	    		<tr>
	    		    <td>医生所在医院:</td>
	    			<td><input class="easyui-textbox" type="text" name="szyy" 
	    				 data-options="required:true" style="width:200px"></input></td>
	    		</tr>
	    		
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">打印</a>
	    	<h1><a href="<%=request.getContextPath()%>/index.jsp">返回到首页</a><h1>
	    </div>
	    </div>
	</div>
	
	
	<script>
		var id= '<%=request.getParameter("id")%>';
		
		$(function(){
			$("#js").combobox({
				url:'<%=request.getContextPath()%>/servlet/RoleServlet?reqCode=findAllRols',
				valueField:'jsbh',
				textField:'jsmc'
			});
			
			$("#ff").form("load","<%=request.getContextPath()%>/servlet/YsglServlet?reqCode=findysById&id="+id);
		});
		
		function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/GhglServlet?reqCode=addghd",
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					$.messager.alert('提示',data,'info');
					//$('#ff').form('clear');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
    
  </body>
</html>
