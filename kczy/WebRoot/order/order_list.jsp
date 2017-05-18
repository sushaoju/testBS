<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>订单</title>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/pj.js"></script>
    
    <script type="text/javascript">
          $(function(){		
  			var toolbar = [{
			text:'增加',
				iconCls:'icon-add',
				handler:function(){
			    addSubPage('增加','<%=request.getContextPath()%>/order/order_list.jsp?id=' +id);
				}
			},{
				text:'Cut',
				iconCls:'icon-cut',
				handler:function(){alert('cut')}
			},'-',{
				text:'Save',
				iconCls:'icon-save',
				handler:function(){alert('save')}
			}];
			
  			$("#grid").datagrid({				
  				toolbar:toolbar,
  				pagination:true,
  				pageSize:10,
  				pageList:[10,20],
  				url:"<%=request.getContextPath()%>/servlet/OrderServlet?reqCode=findOrdersForPages",
  				columns:[[
  				    {field:"ck",checkbox:true},
  				    {title:"药品ID",field:"id",width:100,align:"center",hidden:true},
  					{title:"药品编号",field:"ypbh",width:100,align:"center"},
  					{title:"药品名称",field:"ypmc",width:150,align:"center"},
  					{title:"所属类别",field:"lb",width:150,align:"center"},
  					{title:"生产厂商",field:"sccs",width:150,align:"center"},
  					{title:"药品条码",field:"yptm",width:150,align:"center",hidden:true},
  					{title:"规格型号",field:"ggxh",width:150,align:"center"},
  					{title:"批准文号",field:"pzwh",width:150,align:"center",hidden:true},
  					{title:"备注",field:"bz",width:150,align:"center",hidden:true},
  					{title:"价格",field:"jg",width:150,align:"center"},
  					{title:"数量",field:"sl",width:150,align:"center"},
  					{title:"操作",field:"_op",width:160,formatter:function(value,row,index){
  					return '<a href="<%=request.getContextPath()%>/order/order_xq.jsp?id='+row.id+'">详情</a>&nbsp<a href="<%=request.getContextPath()%>/servlet/OrderServlet?reqCode=delOrder&id='+row.id+'">删除</a>';
  						return '<a href="javascript:void(0);" onclick = "sel(\' ' +row.id+ '\')">详情</a>  <a href="javascript:void(0);" onclick = "del(\' ' +row.id+ '\')">删除</a> ';
  					}}
  				]]
  			});
  		});
//操作中的快捷方式  		
        function sel(id){
                 alert(id);
                addSubPage('详情','<%=request.getContextPath()%>/order/order_xq.jsp?id=' +id);
           }

      function del(id){
                alert(id);
                addSubPage('删除','<%=request.getContextPath()%>/servlet/OrderServlet?reqCode=delOrder&id='+id);
           } 
    
    </script>

  </head>
  
  <body>
  <div class="easyui-panel" title="我的订单" style="width:95%">
   <div  style="padding:5px 10px;" id="22">
		药品名称: <input class="easyui-textbox" id="queryYpmc" style="width:110px">		
		<a href="javascript:void(0);" onclick="searchData()" 
			class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		<a href="javascript:void(0);" onclick="clearForm()" 
			class="easyui-linkbutton" >重置</a>	  
	</div>		
	</div>	
	<div id="grid" style="width:100%;height:350px"></div>
	<<h1><a href="<%=request.getContextPath()%>/index.jsp">返回首页</a><h1>
	 <script>
          var id=  '<%=request.getParameter("id")%>';	       
  
	        $(function(){	
			$("#ff").form("load","<%=request.getContextPath()%>/servlet/orderServlet?reqCode=findorderById&id="+id);
		});
	      
//搜索按钮	        
  		function searchData(){
  			$("#grid").datagrid("load",{
  			       ypmc:$("#queryYpmc").val() });
  		}
	      
//重置按钮
  		function clearForm(){
	          $("#22").form('clear');
	        }
//关闭	        
	   function shut(){
	       parent.$('#tt').tabs('close','购物车');
	    }
	</script>
  </body>
</html>
