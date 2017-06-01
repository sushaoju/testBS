<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>User ADD</title>
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
	    			<td>药品编号:</td>
	    			<td><input class="easyui-textbox" 
	    			type="text" name="ypbh"
	    			
	    			data-options="required:true" style="width:200px" value="03"></input></td>
                <tr>
	    			<td>药品名称:</td>
	    			<td><input class="easyui-textbox" 
	    			type="text" name="ypmc"
	    			
	    			data-options="required:true" style="width:200px" value="抗生素"></input></td>
	    		</tr>
	    		<tr>
	    			<td>数量:</td>
	    			<td><input type="text" name="sl"
	    			 data-options="required:false" style="width:200px" value="2"></td>
	    	</tr>	
	    	<tr>
	    			<td>总金额:</td>
	    			<td><input type="text" name="zje" value="40"> 
	    			
	    		</tr>	
	    			    	
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">付款</a>
	    	
	    </div>
	    </div>
	</div>
	
	
	<script>
		
		function submitForm(){
			
 
 location="http://127.0.0.1:8080/kczy/fk/fk.jsp";
 
}
	</script>
    
  </body>
</html>
