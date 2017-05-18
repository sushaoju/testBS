<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>详情</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  
	</head>
  <body>
	
	<div class="easyui-panel" title="详情管理" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
		<%String patientName =request.getParameter("patientName"); %>
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    
	    	<input type="hidden" name="reqCode" value="addUser"/>
	    	<table cellpadding="5">
	    	<tr>
	    	        <td>您的账号:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="p_account" data-options="required:true"></td>
	    	</tr>	
	    	<tr>
	    	        <td>挂号费:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="ghf" data-options="required:true"></td>
	    	</tr>	
	    	<tr>
	    	        <td>问诊费:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="wzfy" data-options="required:true"></td>
	    	</tr>
	    	<tr>
	    	        <td>处方单金额:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="cfdje" data-options="required:true"></td>
	    	</tr>
	    	<tr>
	    	        <td>总金额:</td>
	    			
	    			<td><input class="easyui-textbox"  type="text" name="zje" data-options="required:true"></td>
	    	</tr>		
	    	
	    	
	    			<td>挂号科室:</td>
	    			<td><input class="easyui-textbox" type="text" name="sgks" data-options="required:true" style="width:200px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>您挂号的医生:</td>
	    			<td><input class="easyui-textbox" type="text" name="d_name" 
	    				 data-options="required:true" style="width:200px"></input></td>
                </tr>
	    		<tr>
	    		    <td>药品名称:</td>
	    			<td><input class="easyui-textbox" type="text" name="ypmc" 
	    				 data-options="required:true" style="width:200px"></input></td>
	    		</tr>
	    		
	    		
	    	</table>
	    </form>
	   
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
			
			$("#ff").form("load","<%=request.getContextPath()%>/servlet/fkServlet?reqCode=findfkdById&id="+id);
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
