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
  	  		
  				$("#grid").datagrid({
  								
  				pagination:true,
  				pageSize:8,
  				pageList:[8,18],
  				collapsible:true,
  				url:"<%=request.getContextPath()%>/servlet/fkServlet?reqCode=findAllFkds",
  				columns:[[
  					{title:"付款Id",field:"id",width:60,align:"center"},
  					{title:"病人账号",field:"p_account",width:"100",align:"center"},
  					
  					{title:"挂号费",field:"ghf",width:"100",align:"center"},
  					
  					{title:"问诊费用",field:"wzfy",width:"120",align:"center"},
  					
  					{title:"处方单金额",field:"cfdje",width:"120",align:"center"},
  					{title:"总金额",field:"zje",width:"120",align:"center"},
  					{title:"所挂科室",field:"sgks",width:"100",align:"center",hidden:true},
  					{title:"问诊医生姓名",field:"d_name",width:"100",align:"center",hidden:true},
  					{title:"药品名称",field:"ypmc",width:"100",align:"center",hidden:true},
  					{title:"操作",field:"——op",width:"120",formatter:function(value,row,index){
  						return '<a href="javascript:void(0);" onclick="update(\''+row.id+'\')">双击查看详情</a>';}}
  				]],
  			
  				  onDblClickRow:function(index,rowData){
	           		$("#grid1").datagrid({
	           		 title:"付款单"+rowData.id+"的明细如下所示：",
	     			
	     			pagination:true,
	          			pageList:[5,10],
	          			url:"<%=request.getContextPath()%>/servlet/fkServlet?reqCode=findfkdmxById&id="+rowData.id,
	           			columns:[[
	           		{title:"付款Id",field:"id",width:60,align:"center"},
  					{title:"病人账号",field:"p_account",width:"100",align:"center"},
  					
  					{title:"挂号费",field:"ghf",width:"100",align:"center"},
  					
  					{title:"问诊费用",field:"wzfy",width:"120",align:"center"},
  					
  					{title:"处方单金额",field:"cfdje",width:"120",align:"center"},
  					{title:"总金额",field:"zje",width:"120",align:"center"},
  					{title:"所挂科室",field:"sgks",width:"100",align:"center"},
  					{title:"问诊医生姓名",field:"d_name",width:"100",align:"center"},
  					{title:"药品名称",field:"ypmc",width:"100",align:"center"},	             		
	           			]]
	              	});
	              	}
	            })
	            })
  				
  			
  			
  			
  		
  		function update(id){
  		alert('确认选择？');
  			addSubPage('选择医生','<%=request.getContextPath()%>/fk/fkxq.jsp?id='+id);
  		}
  		function searchData(){
  			$("#grid").datagrid("load",{
  			        p_account:$("#queryp_account").val()
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
		病人账号: <input class="easyui-textbox" style="width:110px" id="queryp_account" >

		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="searchData()">搜索</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
	<div id="grid" style="width:100%;height:250px"></div>
   <div id="grid1" style="width:100%;height:250px"></div>
	
  </body>
</html>
