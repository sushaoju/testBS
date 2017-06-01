<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    
    <title>系统管理</title>
    
    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="css_mine/personnelManagement.css">
  </head>
  
  <body class="gray-bg">
  <div class="wrapper wrapper-content animated fadeInDown">
	   
		   <!--编辑区 start-->
		    <div>
		        <div class="ibox-title">
		            <h5>系统用户查询条件</h5>
		        </div>
		        <div class="ibox-content">
		
		            <form role="form" class="form-inline">
		                <div class="form-group">
		                    <input type="text" placeholder="请输入工号" id="s_stuffID" class="form-control">
		                    <input type="text" placeholder="请输入姓名" id="s_stuffName" class="form-control">
		                </div>
		                <div class="form-group" style="margin-top: 10px">
		                    <button id="sel_btn" class="btn btn-info" type="button" style="position:relative;top:-5px"><i class="fa fa-search fa-fw"></i>查询</button>
		               </div>
		
		            </form>
		
		        </div>
		    </div>
		    <!--编辑区 end-->
		
		    <!--查询结果区 start-->
		    <div class="ibox">
		
		        <div class="ibox-title">
		            <h5>系统用户查询结果</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		            </div>
		        </div>
		
		        <div class="ibox-content">
		            <div class="row row-lg">
		                <div class="col-sm-12">
		                            <table id="sys_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
		                                <thead>
		                                <tr>
		                                    <th>工号</th>
		                                    <th>姓名</th>
		
											<th>账号</th>
		                                    <th>密码</th>
		                                    <th>注册日期</th>
		
		                                    <th>操作</th>
		                                </tr>
		                                </thead>
		
		                                <tbody>
		                                </tbody>
		                            </table>
		                </div>
		            </div>
		        </div>
		    </div>
		    <!--查询结果区 end-->
	  </div>

<!--编辑弹框 start-->
<div id="edit_box">
    <h2>编辑培训信息</h2>
    <form>
        <div class="form-group">
            <div class="col-sm-6">
                <label for="e_stuffID">工号:</label>
                <span id="e_stuffID"></span>
            </div>
           <div class="col-sm-6">
                <label for="e_stuffName">姓名:</label>
				<span id="e_stuffName"></span>
            </div>
           </div>
		<div class="clearfix hidden-xs"></div>      

		
		 <div class="from-group">
		    <div class="col-sm-6">
                <label for="e_account">账号:</label>
                <input class="form-control" type="text"  id="e_account">
            </div>
			<div class="col-sm-6">
                <label for="e_password">密码:</label>
                <input class="form-control" type="text"  id="e_password">
            </div>
		</div>
		<div class="clearfix hidden-xs"></div> 
              
        <div class="from-group">
            <div class="col-sm-6 text-center">
                <button class="btn btn-primary btn-lg" type="button" id="editSubmit_btn">修改</button>

            </div>

            <div class="col-sm-6 text-center">
                <button id="edit_closeBtn" class="btn btn-default btn-lg" type="button">取消</button>
            </div>
        </div>
    </form>
</div>
<!--编辑弹框 end-->



<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<script src="js/content.min.js?v=1.0.0"></script>
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="js/demo/bootstrap-table-demo.min.js"></script>


<script>
$(function(){
	findAllAdminInfos(); //获取所有的系统用户信息
	
	//编辑按钮 弹框
		$("#sys_tbl").on('click','.edit_btn',function(){
			var  stuffID = $(this).parent("td").parent("tr").find("td").eq(0).text(); 
			var  stuffName =$(this).parent("td").parent("tr").find("td").eq(1).text();   
			var  account =$(this).parent("td").parent("tr").find("td").eq(2).text();  
			var  password =$(this).parent("td").parent("tr").find("td").eq(3).text();   
						
			
			$("#e_stuffID").text(stuffID);
			$("#e_stuffName").text(stuffName);
			$("#e_account").val(account);
			$("#e_password").val(password);
						
			alertEditBox();			
		});
		
		function alertEditBox() {
			layer.open({
				type: 1,
				closeBtn: true,
				title: false,
				area: ['600px', '400px'],
				shadeClose: false, //点击遮罩不关闭
				content: $('#edit_box')
			});
	
			$("#edit_box").show();
		}
		$("#edit_closeBtn").click(function () {
			$(".layui-layer-close2").click();
		});
	
	
	
	//单条删除 按钮
		$("#sys_tbl").on('click','.del_btn',function(){
			var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
			
			sweetDel(stuffID);  //删除弹框 ，在弹框里执行删除操作
		});
		
		
	//搜索按钮
		$("#sel_btn").click(function(){
			var stuffID = $("#s_stuffID").val();
			var stuffName = $("#s_stuffName").val();
		
			if(stuffID==""&&stuffName==""){
				findAllAdminInfos(); //获取所有的系统用户信息
			}else{
				findAdminInfoByCondition(stuffID,stuffName);
			}
			
		});	
		
		//编辑提交按钮
	    $("#editSubmit_btn").click(function(){
			var stuffID = $("#e_stuffID").text();
			var  account = $("#e_account").val(account);
			var  password = $("#e_password").val(password);
			
			var type_str="warning";
			if($.trim(account)==''){warn_str="请输入正确格式的账号";sweetWarn(warn_str,type_str);return false;}
			if($.trim(password)==''){warn_str="请输入正确格式的密码";sweetWarn(warn_str,type_str);return false;}
			
		    updateAdminInfo(stuffID,account,password);
		});
		
		//更新系统用户信息
		function updateAdminInfo(stuffID,account,password){
		
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/AdminInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "updateAdminInfo", //请求码
					"stuffID":stuffID, 
					"account":account,  
					"password":password
				},
				error: function () {
					alert("更新系统用户信息请求失败！");
				},
				success:function(data){
					$("#edit_closeBtn").click();
					var warn_str="修改系统用户信息成功！";
	                var type_str="success";
				    sweetWarn(warn_str,type_str);
					
					findAllAdminInfos(); //获取所有的系统用户信息
				}
			})
		}
		
		
		
		
		
		
		//条件查询系统用户信息
		function findAdminInfoByCondition(stuffID,stuffName){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/AdminInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findAdminInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#sys_tbl tbody");
					var tbl_str='';   //插入字符串
					var result = data.rows;
					var total = data.total;
					tbl.empty();	
				
				if(total== 0){
					var warn_str="找不到符合查询条件的数据！";
	                var type_str="warning";
				    sweetWarn(warn_str,type_str);
				}else{
					$(result).each(function(key){
					tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].account+'</td>'+
                                    '<td>'+result[key].password+'</td>'+
                                    '<td>'+result[key].resignDate+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn" type="button">'+
                                    '        <i class="fa fa-trash fa-fw"></i></i>删除'+
                                    '    </button>'+
                                    '</td>'+
                        '</tr>');									
						tbl.append(tbl_str);						
				});
				}
					
				}
			});
		}
		
		
		
		
	
	
	//单条删除培训信息
		function delAdminInfo(stuffID){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/AdminInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delAdminInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				findAllAdminInfos(); //获取所有的系统用户信息
			}
		});
		}
	
	
	
	//获取所有的系统用户信息
		function findAllAdminInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/AdminInfoServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllAdminInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的系统用户信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#sys_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].account+'</td>'+
                                    '<td>'+result[key].password+'</td>'+
                                    '<td>'+result[key].resignDate+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn" type="button">'+
                                    '        <i class="fa fa-trash fa-fw"></i></i>删除'+
                                    '    </button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});
						 
				 }	
			});
			
		}
		
		//sweetalert 弹框（一个确定按钮）
		function sweetWarn(str,type){
			swal({
				title:"提示",
				text:str,
				type:type
			})
		}
		
		//sweetalert 弹框（删除）
		function sweetDel(stuffID){
			swal({
				title: "您确定要删除这条信息吗",
				text: "删除后将无法恢复，请谨慎操作！",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: "#DD6B55",
				confirmButtonText: "删除",
				closeOnConfirm: false
			}, function (isConfirm) {
				if(isConfirm){
					delAdminInfo(stuffID);
					
					swal("删除成功！","您已经永久删除了这条信息。","success")
				}else{
					swal("已取消","您取消了删除操作！","error");
				}
				
			});
		}
		
		
		
});
</script>


</body>
</html>
