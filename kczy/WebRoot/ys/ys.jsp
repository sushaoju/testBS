<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jyj.entity.Ys" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'user_list.jsp' starting page</title>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/pj.js"></script>
  	<script type="text/javascript">
  	 var ksbh= '<%=request.getParameter("ksbh")%>';
  	 
  		$(function(){
  			var toolbar = [
  			{
			    text:'新增',
				iconCls:'icon-add',
				handler:function(){
					addSubPage('新增角色','<%=request.getContextPath()%>/jsgl/jsgl_add.jsp');}
			},{
				text:'Cut',
				iconCls:'icon-cut',
				handler:function(){alert('cut')}
			},'-',{
				text:'Save',
				iconCls:'icon-save',
				handler:function(){alert('save')}
			}
			];
			
  			$("#grid").datagrid({  				
  				toolbar:toolbar,
  				pagination:true,
  				pageSize:5,
  				pageList:[5,10],
  				url:"<%=request.getContextPath()%>/servlet/YsglServlet?reqCode=findysByKsbh&ksbh="+ksbh,
  				columns:[[
                    {field:"ck",checkbox:true},				
  					{title:"医生id",field:"id",width:60,align:"center"},
  					{title:"医生姓名",field:"d_name",width:60,align:"center"},
  					{title:"医生年龄",field:"age",width:60,align:"center"},
  					{title:"医生性别",field:"sex",width:60,align:"center"},
  					{title:"医生联系方式",field:"phone",width:100,align:"center"},
  					{title:"医生地址",field:"address",width:80,align:"center"},
  					{title:"科室编号",field:"ksbh",width:60,align:"center"},
  					{title:"所在科室",field:"szks",width:60,align:"center"},
  					{title:"职称",field:"zc",width:60,align:"center"},
  					{title:"所在医院",field:"szyy",width:100,align:"center"},
  					{title:"操作",field:"_op",width:160,formatter:function(value,row,index){
  						return '<a href="<%=request.getContextPath()%>/gh/ghd.jsp?id='+row.id+'">我要挂号</a>';
  					}}
  				]]
  			});
  		});
  		
  	function update(id){
  		    alert('欢迎挂号');
  			addSubPage('挂号单','<%=request.getContextPath()%>/gh/ghd.jsp?id='+id);
  		}
  	
  		
  		function clearForm(){
  		$("#ff").form('clear');}
  		function searchData(){
  			$("#grid").datagrid("load",{
  			        id:$("#queryYsbh").val(),
  					d_name:$("#queryYsmc").val()
  					
  				});
  		}


  	</script>
  </head>
  <body>
   
  	<div  style="padding:5px 10px;" id="ff">
  	            医生编号: <input class="easyui-textbox" id="queryYsbh" style="width:110px">
		医生名称: <input class="easyui-textbox" id="queryYsmc" style="width:110px">
		
		<a href="javascript:void(0);" onclick="searchData()"   iconCls="icon-search"
			class="easyui-linkbutton" >搜索</a>
		<a href="javascript:void(0);" onclick="clearForm()"  class="easyui-linkbutton" iconCls="easyui-linkbutton">重置</a>				
	</div>
	
	<div id="grid" style="width:100%;height:350px"></div>
  </body>
</html>