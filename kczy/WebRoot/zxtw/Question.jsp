<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'xjdj.jsp' starting page</title>
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
				text:'增加',
				iconCls:'icon-add',
				handler:function(){addSubPage('新增问题','<%=request.getContextPath()%>/zxtw/Q_add.jsp');}
			},'-',{
				text:'修改',
				iconCls:'icon-update',
				handler:function(){alert('update')
			},
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
  					{title:"操作",field:"——op",width:"150",formatter:function(value,row,index){
  					       return '<a href="<%=request.getContextPath()%>/zxtw/Q_add.jsp">我要提问</a>&nbsp<a href="<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=delquestion&question_id='+row.question_id+'")>删除</a>&nbsp<a href="<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=findQuestionByquestion_id&question_id='+row.question_id+'")>修改</a>';
  		}}
  				]]
  			});
  			});
  		function del(question_id){
  			//alert(wldwbh);
  			addSubPage('删除问题信息','<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=delquestion&question_id='+question_id);
  		}
  		function update(question_id){
  			addSubPage('问题信息','<%=request.getContextPath()%>/servlet/QuestionServlet?reqCode=findQuestionByquestion_id&question_id='+question_id);
  		}
  		
  	
  		function searchData(){
  			$("#grid").datagrid("load",{
  			        question_id:$("#queryquestion_id").val(),
  					
  				});
  		}
  		function clearForm(){
			$('#ff').form('clear');
		}
	</script>

  </head>
  
  <body>
    <input type="hidden" name="reqCode" value="">
	<div style="margin:20px 0;"></div>
	<div id="ff" style="padding:2px 5px;">
		检索条件：
		问题编号: <input class="easyui-textbox" style="width:110px" id="queryquestion_id" >

		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="searchData()">搜索</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
	<div id="grid" style="width:100%;height:250px"></div>
	<div></div>
  </body>
</html>
