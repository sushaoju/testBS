<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ui/themes/icon.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/ui/jquery.easyui.min.js"></script>
    
    <script type="text/javascript">
    function addPanel(titles,url){    
    	if($("#tt").tabs("exists",titles)){
    		$("#tt").tabs("select",titles);
    		}else{
    			var content='<iframe src="'+url+'" frameborder="0" scrolling="auto" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title: titles,
					content: content,
					closable: true
				});
			}}
    	    	   	
    </script>
	
  </head>
  <body class="easyui-layout">
  <%
    		Date currentDate=new Date();
    		SimpleDateFormat sf =new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
    		String chnDate=sf.format(currentDate);
     		%>
     		<%String account=request.getParameter("account"); %>
     		<%String id=request.getParameter("userId"); %>
	<div data-options="region:'north',border:false" 
			style="height:60px;background:#6699ff;padding:10px">
			<font face="仿宋体" size=6 color="white">简医家V2.0&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
			<font face="宋体" size=2 color="white">您好，</font>
			<font face="仿宋体" size=2 color="red"><%=account%></font>
			<font face="宋体" size=2 color="white">欢迎您使用系统!</font>
			<%=chnDate %>&nbsp;
			<font face="仿宋体" size=2 color="white">
			<a href="#" class="easyui-linkbutton" data-options="plain:true">修改信息</a>&nbsp;
			<a href="<%=request.getContextPath()%>/login/login.jsp" class="easyui-linkbutton" 
				data-options="plain:true">退出</a></font>
	</div>
			
	<div data-options="region:'west',split:false,title:'系统菜单'" 
			style="width:170px">
			<div id="aa" class="easyui-accordion" data-option="fit:true" >
		
				<ul>
						
						<a href="javascript:addPanel('付款单查看','<%=request.getContextPath()%>/fk/fkd.jsp')" 
						class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">付款单查看</a>
						<a href="javascript:addPanel('医生列表','<%=request.getContextPath()%>/user/doctor.jsp')" 
						class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">医生列表</a>
						<a href="javascript:addPanel('病人信息','<%=request.getContextPath()%>/user/patient.jsp')" 
						class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">病人列表</a>
					</ul>				
				</div>
			</div>
			
			
	</div>	
			
	<div data-options="region:'south',border:false" 
			style="height:40px;background:#A9FACD;padding:10px;">
			<center>Welcome to JYJ</center>
	</div>
			
	<div data-options="region:'center'">
		<div id="tt" class="easyui-tabs" data-options="border:false,fit:true" 	
			style="width:100%;height:100%">
			
			<div title="首页" style="padding:10px" >
			<font face="宋体" size=4 color="red">&nbsp;&nbsp我们可以对医生与病人进行增加、删除、修改</font>
			<img src="<%=request.getContextPath()%>/image/admin.jpg" width="100%" height="100%">
			</div>
			
		</div>
	</div>
	</body>
</html>
	
