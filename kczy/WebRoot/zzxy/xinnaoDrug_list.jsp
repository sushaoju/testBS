<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>心脑血管</title>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/ui/themes/icon.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/ui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/pj.js"></script>
    
    <script type="text/javascript">
          $(function(){		
  			var toolbar = [{
			text:'添加到购物车',
				iconCls:'icon-add',
				handler:function(){
					addSubPage('添加到购物车','<%=request.getContextPath()%>/cart/cart_list.jsp?id=' +id);
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
  				pageSize:5,
  				pageList:[5,10],
  				url:"<%=request.getContextPath()%>/servlet/XNDrugServlet?reqCode=findDrugsForPages",
  				columns:[[
  				    {field:"ck",checkbox:true},
  				    {title:"药品ID",field:"id",width:100,align:"center",hidden:true},
  					{title:"药品编号",field:"ypbh",width:100,align:"center",hidden:false},
  					{title:"药品名称",field:"ypmc",width:150,align:"center"},
  					{title:"所属类别",field:"lb",width:150,align:"center"},
  					{title:"生产厂商",field:"sccs",width:150,align:"center"},
  					{title:"药品条码",field:"yptm",width:150,align:"center",hidden:true},
  					{title:"规格型号",field:"ggxh",width:150,align:"center"},
  					{title:"批准文号",field:"pzwh",width:150,align:"center",hidden:true},
  					{title:"备注",field:"bz",width:150,align:"center",hidden:true},
  					{title:"价格",field:"jg",width:150,align:"center"},
  					{title:"操作",field:"_op",width:200,formatter:function(value,row,index){
  						return '<a href="<%=request.getContextPath()%>/zzxy/xndrug_xq.jsp?id='+row.id+'">药品详情</a>&nbsp<a href="<%=request.getContextPath()%>/cart/xncart_add.jsp?id='+row.id+'">加入购物车</a>&nbsp<a href="<%=request.getContextPath()%>/buy/xndrug_buy.jsp?id='+row.id+'">立即购买</a>';
  					}}
  				]]
  			});
  		});
//操作中的快捷方式  		
        function sel(id){
                 alert(id);
                 addSubPage('药品详情','<%=request.getContextPath()%>/zzxy/xndrug_xq.jsp?id=' +id);
           }
  		function addcart(id){
  			addSubPage('加入购物车','<%=request.getContextPath()%>/cart/xncart_add.jsp?id=' +id);
  		}
  		function buy(id){
                 alert(id);
                 addSubPage('立即购买','<%=request.getContextPath()%>/buy/xndrug_buy.jsp?id=' +id);
           }
//重置按钮
  		function clearForm(){
	          $("#22").form('clear');
	        }
//搜索按钮	        
  		function searchData(){
  			$("#grid").datagrid("load",{
  			       ypmc:$("#queryYpmc").val() });
  		}
    
    </script>

  </head>
  
  <body>
    <div  style="padding:5px 10px;" id="22">
		药品名称: <input class="easyui-textbox" id="queryYpmc" style="width:110px">		
		<a href="javascript:void(0);" onclick="searchData()" 
			class="easyui-linkbutton" iconCls="icon-search">搜索</a>
		<a href="javascript:void(0);" onclick="clearForm()" 
			class="easyui-linkbutton" >重置</a>	
	   <a href="<%=request.getContextPath()%>/cart/cart_list.jsp" 
			class="easyui-linkbutton" >我的购物车</a>
	  <a href="<%=request.getContextPath()%>/order/order_list.jsp"  
			class="easyui-linkbutton" >我的订单</a>
	</div>		
	
	<div id="grid" style="width:100%;height:350px"></div>
  </body>
</html>
