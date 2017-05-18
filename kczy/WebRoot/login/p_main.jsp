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
			<font face="黑体" size=6 color="white">简医家V1.0&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
			<font face="黑体" size=2 color="white">您好，</font>
			<font face="黑体" size=6 color="red"><%=account%></font>
			<font face="仿宋体" size=2 color="white">欢迎您使用系统!</font>
			<%=chnDate %>&nbsp;
			<font face="黑体" size=3 color="white">
			<a href="#" class="easyui-linkbutton" data-options="plain:true">修改信息</a>&nbsp;
			<a href="<%=request.getContextPath()%>/login/login.jsp" class="easyui-linkbutton" 
				data-options="plain:true">退出</a></font>
	</div>
			
	<div data-options="region:'west',split:false,title:'系统菜单'" 
			style="width:170px">
			<div id="aa" class="easyui-accordion" data-option="fit:true" >
				<div title="自主购药" data-options="iconCls:'icon-stock'" style="overflow:auto;padding:10px;">
				<ul>
						
							<a href="javascript:addPanel('感冒发烧','<%=request.getContextPath()%>/zzxy/ganmaoDrug_list.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">感冒发烧</a>						
							<a href="javascript:addPanel('呼吸系统','<%=request.getContextPath()%>/zzxy/huxiDrug_list.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-admin'">呼吸系统</a>						
							<a href="javascript:addPanel('消化系统','<%=request.getContextPath()%>/zzxy/xiaohuaDrug_list.jsp')" class="easyui-linkbutton"data-options="plain:true,iconCls:'icon-roles'">消化系统</a>
						    <a href="javascript:addPanel('心脑血管','<%=request.getContextPath()%>/zzxy/xinnaoDrug_list.jsp')" class="easyui-linkbutton"data-options="plain:true,iconCls:'icon-roles'">心脑血管</a>
						    <a href="javascript:addPanel('外用常备','<%=request.getContextPath()%>/zzxy/waiyongDrug_list.jsp')" class="easyui-linkbutton"data-options="plain:true,iconCls:'icon-roles'">外用常备</a>
						    <a href="javascript:addPanel('滋补保健','<%=request.getContextPath()%>/zzxy/baojianDrug_list.jsp')" class="easyui-linkbutton"data-options="plain:true,iconCls:'icon-roles'">滋补保健</a>
						    
					</ul>
				
				</div>
				<div title="网上问诊" data-options="iconCls:'icon-finance'" style="overflow:auto;padding:10px;">
				<ul>
						
						<a href="javascript:addPanel('病人挂号','<%=request.getContextPath()%>/ks/ksgl.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">病人挂号</a>
						<a href="javascript:addPanel('病人视频问诊','<%=request.getContextPath()%>/sp/ksp.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">病人视频问诊</a>
					</ul>
				
				</div>
				<div title="用户管理" data-options="iconCls:'icon-finance'" style="overflow:auto;padding:10px;">
					<ul>
						
						<a href="javascript:addPanel('病人信息','<%=request.getContextPath()%>/user/patient.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-analysis'">病人列表</a>
					</ul>
				</div>
				<div title="在线提问" data-options="iconCls:'icon-system'" style="overflow:auto;padding:10px;">
					<ul>
						
							
						
							<a href="javascript:addPanel('提问问题管理','<%=request.getContextPath()%>/zxtw/Question.jsp')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-admin'">提问问题管理</a>
							<a href="javascript:addPanel('问题回顾','<%=request.getContextPath()%>/zxtw/Review.jsp')" class="easyui-linkbutton"data-options="plain:true,iconCls:'icon-roles'">问题回顾</a>
						
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
			<font face="宋体" size=6 color="red">&nbsp;&nbsp;网络看病是互联网时代的特有产物，它打破了时空、地域限制，
			使得世界各地的“专家会诊”成为现实。它降低了交通成本，推进了“医术”的繁荣和发展，
			从而进一步增进了世界的科学技术和文化情感的交融。</font><br>
			<img src="<%=request.getContextPath()%>/image/2.jpg">
			<img src="<%=request.getContextPath()%>/image/3.jpg">
			<img src="<%=request.getContextPath()%>/image/4.jpg">
			<img src="<%=request.getContextPath()%>/image/5.jpg">
			
		</div>
	</div>
	
	</body>
</html>
	
