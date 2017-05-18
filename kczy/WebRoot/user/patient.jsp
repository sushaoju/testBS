<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>系统用户列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  		<script type="text/javascript" src="<%=request.getContextPath()%>/js/pj.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			var toolbar = [{
			text:'新增',
				iconCls:'icon-add',
				handler:function(){
					addSubPage('新增管理用户','<%=request.getContextPath()%>/user/p_add.jsp');
				}
			},{
				text:'Cut',
				iconCls:'icon-cut',
				handler:function(){alert('cut')}
			},'-',{
				text:'Save',
				iconCls:'icon-save',
				handler:function(){alert('save')}
			}];
  			// 构建grid
  			$("#grid").datagrid({
  				toolbar:toolbar,
  				pagination:true,
  				pageSize:8,
  				pageList:[8,16],
  				url:"<%=request.getContextPath()%>/servlet/PatientServlet?reqCode=findPatientForPage",
  				columns:[[
  					{title:"病人编号",field:"id",width:100,align:"center"},
  					{title:"帐号",field:"account",width:100,align:"center"},
  					{title:"密码",field:"pwd",width:100,align:"center"},
  					{title:"姓名",field:"name",width:100,align:"center"},
  					{title:"级别",field:"jibie",width:100,align:"center"},
  					{title:"年龄",field:"age",width:100,align:"center"},
  					{title:"性别",field:"sex",width:100,align:"center"},
  					{title:"电话",field:"number",width:100,align:"center"},
  					{title:"地址",field:"address",width:150,align:"center"},
  					{title:"操作",field:"_op",width:160,formatter:function(value,row,index){
  						return '<a href="javascript:void(0);" onclick="del(\''+row.id+'\')">删除</a>   <a href="javascript:void(0);" onclick="update(\''+row.id+'\')">修改</a>';
  					}}
  				]]
  			});
  			
  		});
  		
  		function del(id){
  			addSubPage('删除管理用户','<%=request.getContextPath()%>/servlet/PatientServlet?reqCode=delpatient&id='+id)
  		}
  		function update(id){
  			addSubPage('修改管理用户','<%=request.getContextPath()%>/servlet/PatientServlet?reqCode=findPatientByid&id='+id);
  		}
  		function searchUsers(){
  			$("#grid").datagrid("load",{
  				id:$("#queryid").val(),
  			});
  			
  		}
  	
  	</script>
  
  </head>
  
  <body>
  	  <div  style="padding:5px 10px;">
  	  	病人编号: <input class="easyui-textbox" id="queryid" style="width:110px">
		
		
		<a href="javascript:void(0);" onclick="searchUsers()" 
			class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</div>
  	<div id="grid"></div>
    
  </body>
</html>
