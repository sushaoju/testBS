<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>User ADD</title>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
	
  </head>
  <body>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<div class="easyui-panel" title="付款管理" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    
 	    	<input type="hidden" name="reqCode" value="addFk">
	    	<table cellpadding="5">
	    	<tr>
	    			<td>请输入账号:</td>
	    			<td><input  type="text" name="p_account" value="" id="p_account"></input></td>
	    		</tr>
	    		<tr>
	    			<td>请输入挂号费:</td>
	    			<td><input  type="text" name="ghf" value="" id="ghf"></input></td>
	    		</tr>
	    		<tr>
	    			<td>请输入问诊费用:</td>
	    			<td><input type="text" name="wzfy" id="wzfy"></input></td>
	    		</tr>
	    		<tr>
	    			<td>请输入处方单金额:</td>
	    			<td><input type="text" name="cfdje" id="cfdje"></input></td>
	    		</tr>
	    		<tr>
	    			<td>
	    			  
                      <input type="button" value="总金额"  onclick="sum();"/>
                      
	    			</td>
	    			<td><input type="text" name="zje" value="" readonly="true" id="zje"/></td>
		       </tr>
	    			    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">付款</a>
	    	<h1><a href="<%=request.getContextPath()%>/index.jsp">返回到首页</a><h1>
	    	
	    </div>
	    </div>
	</div>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="自定义面板" style="width:95%" data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true"></div>
	<script>
	function sum() {	var ghf = document.getElementById("ghf").value;	
  var wzfy = document.getElementById("wzfy").value;	
  var cfdje = document.getElementById("cfdje").value;
  document.getElementById("zje").value = parseInt(ghf)+parseInt(wzfy)+parseInt(cfdje);}</script>
	</script>
	<script>
	
	
		function submitForm(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/fkServlet?reqCode=addFkd",
				onSubmit:function(){
					
					return $(this).form('enableValidation').form('validate');
				},
				success:function(data){
					$.messager.alert('提示',data,'info');
					$('#ff').form('clear');
				}
				
			});
		}
		
		
	</script>
  	
  </body>
</html>
