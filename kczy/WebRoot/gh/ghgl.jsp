<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'ksgl.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/pj.js"></script>
	
	<script type="text/javascript">
  		$(function(){
  			var toolbar = [{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){alert('search')}
				},{
				text:'查看详情',
				iconCls:'icon-add',
				handler:function(){addSubPage('选择科室','<%=request.getContextPath()%>/ks/ks_add.jsp');}
			},'-',{
				text:'批量删除',
				iconCls:'icon-delete',
				handler:function(){alert('delete')}
			},'-',{
				text:'导出EXCEL',
				iconCls:'icon-save',
				handler:function(){alert('save')}
			}];
			$("#grid").datagrid({
  				toolbar: toolbar,  				
  				pagination:true,
  				pageSize:8,
  				pageList:[8,20],
  				collapsible:true,
  				url:"<%=request.getContextPath()%>/servlet/GhglServlet?reqCode=findAllGhd",
  				columns:[[
  					{title:"挂号序号",field:"g_id",width:60,align:"center"},
  					{title:"病人账号",field:"p_account",width:"100",align:"center"},
  					{title:"病人年龄",field:"p_age",width:"120",align:"center"},
  					{title:"病人性别",field:"p_sex",width:60,align:"center"},
  					{title:"病人所在地址",field:"p_address",width:160,align:"center"},
  					{title:"医生姓名",field:"d_name",width:"100",align:"center"},
  					{title:"医生科室",field:"szks",width:"120",align:"center"},
  					{title:"医生来自医院",field:"szyy",width:"100",align:"center"},
  				]]
  			});
  			});
  		function del(ksbh){
  			//alert(wldwbh);
  			addSubPage('删除科室','<%=request.getContextPath()%>/servlet/KsglServlet?reqCode=delKs&ksbh='+ksbh);
  		}
  		function update(ksbh){
  		alert('确认选择？');
  			addSubPage('选择医生','<%=request.getContextPath()%>/ys/ys.jsp?ksbh='+ksbh);
  		}
  		function searchData(){
  			$("#grid").datagrid("load",{
  			        g_id:$("#queryg_id").val()
  					//xjrq:$("#queryxjrq").val(),
  					//ksmc:$("#queryksmc").val()
  					
  				});
  		}
  		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
	
	

  </head>
  
  <body>
    <input type="hidden" name="reqCode" value="findPjsForPages">
	<div style="margin:20px 0;"></div>
	<div id="ff" style="padding:2px 5px;">
		检索条件：
		挂号序号: <input class="easyui-textbox" style="width:110px" id="queryg_id" >

		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="searchData()">搜索</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
	<div id="grid" style="width:100%;height:250px"></div>
	<div>
	<h1><a href="<%=request.getContextPath()%>/index2.jsp">back</a><h1>
	</div>
	
	
  </body>
</html>
