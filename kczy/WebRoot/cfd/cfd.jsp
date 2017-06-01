<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cfd ADD</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  
	</head>
  <body>
	
	<div class="easyui-panel" title="处方单" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<input type="hidden" name="reqCode" value="addCfd"/>
	    	<table cellpadding="5">
	    	
	    	<tr>
	    			<td>医生编号:</td>
	    			<td><input class="easyui-textbox" 
	    			type="text" name="d_id"
	    			
	    			data-options="required:true" style="width:200px" ></input></td>
                <tr>
                <tr>
	    			<td>病人编号:</td>
	    			<td><input class="easyui-textbox" 
	    			type="text" name="p_id"
	    			
	    			data-options="required:true" style="width:200px" ></input></td>
                <tr>
                
	    		
	    			<td>药品名称:</td>
	    			<td><input class="easyui-textbox" 
	    			type="text" name="ypmc"
	    			
	    			data-options="required:true" style="width:200px" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>数量:</td>
	    			<td><input type="text" name="ypsl"
	    			 data-options="required:false" style="width:200px"></td>
	    	</tr>	
	    	<tr>
	    			<td>总金额:</td>
	    			<td><input type="text" name="zje" > 
	    			
	    		</tr>	
	    			    	
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a>
	    	<h1><a href="<%=request.getContextPath()%>/index2.jsp">back</a><h1>
	    </div>
	    </div>
	</div>
	
	<script>
		var id= '<%=request.getParameter("id")%>';
		function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/CfdServlet?reqCode=addcfd",
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
