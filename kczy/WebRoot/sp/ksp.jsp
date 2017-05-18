<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
var c=0 
var t 
function timedCount() 
{ 

document.getElementById('txt').value=c 
c=c+1 
t=setTimeout("timedCount()",1000) 
} 
function stopCount() 
{ 
clearTimeout(t)  
}
 
 function addcf(){
 
 var d_id=document.getElementById("text").value;
 if(d_id=="1"){
 location="http://127.0.0.1:8080/kczy/cfd/cfd1.jsp";
 }
 if(d_id=="2"){
 location="http://127.0.0.1:8080/kczy/cfd/cfd2.jsp";
 }
 if(d_id=="3"){
 location="http://127.0.0.1:8080/kczy/cfd/cfd3.jsp";
 }
}
function show(){

  $("#s").show();
}

</script>
</head>

<body>
<style type="text/css">
body{background-color:pink}</style> 


	
	
		<input type="text" name="text" id="text" >*****请输入医生id*****
		<input type="button" name="button" id="button" value="开始" onclick="timedCount()" onDblClick="show()" />
		<input type="button" name="button" id="button1" value="打开视频"  onClick="show()" /> 
		<input type="text" id="txt"> 
		<input type="button" value="关闭视频" onClick="stopCount()"> 
		<input type="button" value="我要处方单"  onClick="addcf()">
		<div  style="padding:5px 10px;" id="ff">
  	             <a href="javascript:void(0);" onclick="addcf()" iconCls="icon-search"
			class="easyui-linkbutton" ></a>
			</div>
			<div id="s" style="dispaly:none">
			<h1><a href="<%=request.getContextPath()%>/index.jsp">返回到首页</a><h1>
			<img src="<%=request.getContextPath()%>/image/d.jpg" width="700" height="700">
			</div>
	
			
</body>
</html>
