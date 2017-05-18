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
  				pageSize:5,
  				pageList:[5,10],
  				collapsible:true,
  				url:"<%=request.getContextPath()%>/servlet/ksglServlet?reqCode=findAllKss",
  				columns:[[
  					{title:"用户Id",field:"id",width:60,align:"center",hidden:true},
  					{title:"科室编号",field:"ksbh",width:"100",align:"center"},
  					{title:"科室名称",field:"ksmc",width:"120",align:"center"},
  				
  					{title:"操作",field:"——op",width:"120",formatter:function(value,row,index){
  						return '<a href="<%=request.getContextPath()%>/ys/ys.jsp?ksbh='+row.ksbh+'">选择科室</a>';}}
  				]]
  			});
  			});
  		
  		function update(ksbh){
  		alert('确认选择？');
  			addSubPage('选择医生','<%=request.getContextPath()%>/ys/ys.jsp?ksbh='+ksbh);
  		}
  		function searchData(){
  			$("#grid").datagrid("load",{
  			        ksbh:$("#queryksbh").val()
  					//xjrq:$("#queryxjrq").val(),
  					//ksmc:$("#queryksmc").val()
  					
  				});
  		}
  		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
	
	

  </head>
  
  <body background"../image/7.jpg">
    <input type="hidden" name="reqCode" value="findPjsForPages">
	<div style="margin:20px 0;"></div>
	<div id="ff" style="padding:2px 5px; background:pink;color:pink">
		检索条件：
		科室编号: <input class="easyui-textbox" style="width:110px" id="queryksbh" >

		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="searchData()">搜索</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
	<div id="grid" style="width:100%;height:250px"></div>
	<article class="broad" style="border-bottom:none; margin-bottom:0px;">
  <h1 class="title">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp问诊规则</h1>
	<div class="ct" color:blue">
	<p class="depics"><b class="sq"></b>1.每日8点整开始问诊&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp 2.每日23点整结束问诊</p>
	
	<p class="depics"><b class="sq"></b>3.挂号费专家号8元.普通号5元 &nbsp &nbsp &nbsp &nbsp 4.如需帮助，可拨打客服400-2202-2209</p>
	<p class="depics"><b class="sq"></b></p>
	
	</div>
	</article>
	
  </body>
</html>
