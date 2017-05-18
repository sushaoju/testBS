<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
       <title>滋补保健药品详情</title>
       <link rel="stylesheet" type="text/css"
	            href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
      <link rel="stylesheet" type="text/css"
	           href="<%=request.getContextPath()%>/ui/themes/icon.css">
     <script type="text/javascript"
	              src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
     <script type="text/javascript"
	              src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
</head>

  
  <body>
    <div class="easyui-panel" title="滋补保健药品详情" style="width:95%">
		<div style="padding:10px 60px 20px 60px">
			<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
				<input type="hidden" name="reqCode" value="xqDrug" />
				<table cellpadding="5">
					<tr>
						<td>药品编号:</td>
						<td><input class="easyui-textbox" type="text" name="ypbh"
							data-options="required:true" style="width:200px"></input>
						</td>
						<td>药品名称:</td>
						<td><input class="easyui-textbox" type="text" name="ypmc"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
					<tr>
						<td>类别:</td>
						<td><input class="easyui-textbox" type="text" name="lb"
							data-options="required:true" style="width:200px"></input>
						</td>
						<td>生产厂商:</td>
						<td><input class="easyui-textbox" type="text" name="sccs"
							data-options="required:true" style="width:200px" ></input>
					   </td>
					</tr>
					<tr>
						<td>药品条码:</td>
						<td><input class="easyui-textbox" type="text" name="yptm"
							data-options="required:true" style="width:200px" ></input>
						</td>
						<td>规格型号:</td>
						<td><input class="easyui-textbox" type="text" name="ggxh"
							data-options="required:true" style="width:200px"></input>
					  </td>
					</tr>
					<tr>
						<td>批准文号:</td>
						<td><input class="easyui-textbox" type="text" name="pzwh"
							data-options="required:true" style="width:200px" ></input>
						</td>
						<td>备注:</td>
						<td><input class="easyui-textbox" type="text" name="bz"
							data-options="required:true" style="width:200px" ></input>
						</td>
					</tr>
				</table>
			</form>
			<div style="text-align:left;padding:5px">
				<a href="<%=request.getContextPath()%>/zzxy/baojianDrug_list.jsp" class="easyui-linkbutton" >关闭</a>
           </div>
		</div>
	</div>

    <script>
          var id=  '<%=request.getParameter("id")%>';	      
	      
	   
	  
	        $(function(){	
			$("#ff").form("load","<%=request.getContextPath()%>/servlet/BDrugServlet?reqCode=findBDrugById&id="+id);
		});
	      
	      
	      function cleargdrug() {
			$('#ff').form('clear');
		}
	</script>
	
  </body>
</html>
