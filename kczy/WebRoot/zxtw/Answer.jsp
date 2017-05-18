<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
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
  				url:"<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=findQuestionForpage",
  				columns:[[
  					{title:"",field:"ck",checkbox:true,align:"center"},
  					{title:"问题编号",field:"question_id",width:"100",align:"center"},
  					{title:"问题名称",field:"question_name",width:"120",align:"center"},
  					{title:"提问日期",field:"question_date",width:"120",align:"center"},
  					{title:"病人编号",field:"patient_id",width:"120",align:"center"},
  					{title:"病人姓名",field:"patient_name",width:"120",align:"center"},
  					{title:"病人帐号",field:"patient_account",width:"100",align:"center"},
  					{title:"操作",field:"——op",width:"120",formatter:function(value,row,index){
  					 return '<a href="<%=request.getContextPath()%>/zxtw/A_add.jsp">回答</a>'
  		}}
  						
  				]]
  			});
  			});
  	
  		function add(question_id){
  			addSubPage('问题答案信息','<%=request.getContextPath()%>/zxtw/A_add.jsp');
  		}
  		function update(question_id){
  			addSubPage('修改问题答案信息','<%=request.getContextPath()%>/servlet/AnswerServlet?reqCode=findAnswerByquestion_id&question_id='+question_id);
  		}
  		function searchData(){
  		
  			$("#grid").datagrid("load",{
				question_id:$("#queryquestion_id").val(),
				
				
				}
			);
  		}
  		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
  </head>
  
  <body>
  <input type="hidden" name="reqCode" value="findQuestionForpage">
	<div style="margin:20px 0;"></div>
	<div id="ff" style="padding:2px 5px;">
		检索条件：
		问题编号: <input class="easyui-textbox" style="width:110px" id="queryquestion_id" name="question_id">
		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="searchData()">搜索</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    <h1><a href="<%=request.getContextPath()%>/index2.jsp">back</a><h1>
	</div>
	<div id="grid" style="width:100%;height:250px"></div>
	<div></div>
	
	
	
</body>

</html>
