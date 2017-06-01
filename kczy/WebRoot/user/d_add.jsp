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
    <div class="easyui-panel" title="注册医生用户" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
			<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
				<input type="hidden" name="reqCode" value="adddoctor" />
				<table cellpadding="5" align="center">
					<tr>
						
						<td>帐号:</td>
						<td><input class="easyui-textbox" type="text" name="account"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>	
					<tr>	
						<td>密码:</td>
						<td><input class="easyui-textbox" type="password" name="pwd"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						
						<td>姓名:</td>
						<td><input class="easyui-textbox" type="text" name="d_name"
							data-options="required:false" style="width:200px" ></input>
						</td>
					</tr>	
					<tr>
						<td>级别:</td>
						<td><input  type="radio" name="jibie" value="会员">会员
						<input  type="radio" name="jibie" value="非会员">非会员
						</td>
					</tr>
					<tr>
						
						<td>年龄:</td>
						<td><input class="easyui-textbox" type="text" name="age"
							data-options="required:false" style="width:200px"></input>
						</td>
					</tr>	
					<tr>
						<td>性别</td>
   						<td>
   						<input type="radio" name="sex" value="男"/>男
   						<input type="radio" name="sex" value="女"/>女
   						</td>
					</tr>
					<tr>
						
						<td>电话:</td>
						<td><input class="easyui-textbox" type="text" name="phone"
							data-options="required:false" style="width:200px"></input>
						</td>
					</tr>	
					<tr>
						<td>地址:</td>
						<td><input class="easyui-textbox" type="text" name="address"
							data-options="required:false" style="width:200px"></input>
						</td>
					</tr>
					<tr>
						<td>科室编号:</td>
						<td><input class="easyui-textbox" type="text" name="ksbh"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>	
					<tr>
						<td>所在科室:</td>
						<td><input class="easyui-textbox" type="text" name="szks"
							data-options="required:false" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>职称:</td>
   						<td>
   						<input type="radio" name="zc" value="教授"/>教授
   						<input type="radio" name="zc" value="副教授"/>副教授
   						</td>
   					</tr>	
					<tr>
						<td>所在医院:</td>
						<td><input class="easyui-textbox" type="text" name="szyy"
							data-options="required:false" style="width:200px"></input>
						</td>
					</tr>
				</table>
				
			</form>
			<div style="text-align:center;padding:5px" >
			<input  type="checkbox" name="c" data-options="required:true" value="我已阅读并同意相关服务条款和隐私政策"/>我已阅读并同意相关服务条款和隐私政策<br>
			 	<a href="javascript:void(0)"   class="easyui-linkbutton" onclick="addpatient()">新增</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="shut()">关闭</a>
				<a href="<%=request.getContextPath()%>/login/d_login.jsp" class="easyui-linkbutton" data-options="plain:true" >登录</a> 
          	</div>
		</div>
	</div>

	<script>
	    function shut(){
	       parent.$('#tt').tabs('close','新增管理用户');
	    }
	
		$(function(){	
			$("#ssgs").attr("readonly",true);
		});
		
		
		function addpatient(){
			$('#ff').form('submit',{
				url:"<%=request.getContextPath()%>/servlet/DoctorServlet?reqCode=adddoctor",
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
