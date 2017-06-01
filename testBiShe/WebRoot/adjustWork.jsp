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
    <title>调休、加班、请假</title>
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
   
 <!--调休 start-->
	   <div class="wrapper wrapper-content animated fadeInDown">
	   
		   <!--编辑区 start-->
		    <div>
		        <div class="ibox-title">
		            <h5>调休查询条件</h5>
		        </div>
		        <div class="ibox-content">
		
		            <form role="form" class="form-inline">
		                <div class="form-group">
		
		                    <input type="text" placeholder="请输入工号" id="s1_stuffID" class="form-control">
		                    <input type="text" placeholder="请输入姓名" id="s1_stuffName" class="form-control">
		                    <select name="s1_stuffDepart1" id="s1_stuffDepart" class="form-control">
		                        
		                    </select>
		
		
		                </div>
		                <div class="form-group" style="margin-top: 10px">
		                    <button id="sel_btn1" class="btn btn-info" type="button" style="position:relative;top:-5px"><i class="fa fa-search fa-fw"></i>查询</button>
		                    <button id="add_btn1" class="btn btn-primary" type="button" style="position:relative;top:-5px"><i class="fa fa-plus fa-fw"></i>增加
		                    </button>
		                </div>
		
		            </form>
		
		        </div>
		    </div>
		    <!--编辑区 end-->
		
		    <!--查询结果区 start-->
		    <div class="ibox">
		
		        <div class="ibox-title">
		            <h5>调休结果</h5>
		            <div class="ibox-tools">
		                <a class="collapse-link">
		                    <i class="fa fa-chevron-up"></i>
		                </a>
		
		            </div>
		        </div>
		
		        <div class="ibox-content">
		            <div class="row row-lg">
		                <div class="col-sm-12">
		                            <table id="adjustRest_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
		                                <thead>
		                                <tr>
		                                    <th>工号</th>
		                                    <th>姓名</th>
		                                    <th>部门</th>
		
											<th>调休类型</th>
		                                    <th>调休前日期</th>
		                                    <th>调休后日期</th>
		
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
<!--调休 end-->	  
	
	
<!--加班 start-->	    
	     <div class="wrapper wrapper-content animated fadeInDown">
	   
			   <!--编辑区 start-->
			    <div>
			        <div class="ibox-title">
			            <h5>加班查询条件</h5>
			        </div>
			        <div class="ibox-content">
			
			            <form role="form" class="form-inline">
			                <div class="form-group">
			
			                    <input type="text" placeholder="请输入工号" id="s2_stuffID" class="form-control">
			                    <input type="text" placeholder="请输入姓名" id="s2_stuffName" class="form-control">
			                    <select name="s2_stuffDepart" id="s2_stuffDepart" class="form-control">
			                        
			                    </select>
			
			
			                </div>
			                <div class="form-group" style="margin-top: 10px">
			                    <button id="sel_btn2" class="btn btn-info" type="button" style="position:relative;top:-5px"><i class="fa fa-search fa-fw"></i>查询</button>
			                    <button id="add_btn2" class="btn btn-primary" type="button" style="position:relative;top:-5px"><i class="fa fa-plus fa-fw"></i>增加
			                    </button>
			                </div>
			
			            </form>
			
			        </div>
			    </div>
			    <!--编辑区 end-->
			
			    <!--查询结果区 start-->
			    <div class="ibox">
			
			        <div class="ibox-title">
			            <h5>加班结果</h5>
			            <div class="ibox-tools">
			                <a class="collapse-link">
			                    <i class="fa fa-chevron-up"></i>
			                </a>
			
			            </div>
			        </div>
			
			        <div class="ibox-content">
			            <div class="row row-lg">
			                <div class="col-sm-12">
			                            <table id="over_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
			                                <thead>
			                                <tr>
			                                    <th>工号</th>
			                                    <th>姓名</th>
			                                    <th>部门</th>
			                                    
			                                    <th>开始日期</th>
			                                    <th>结束日期</th>
												<th>工时/时</th>
												
												<th>加班原因</th>
			                                    <th>金额</th>
												<th>审批人</th>
												
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
   
 <!--加班 end-->	    
   
  <!--请假 start-->	
  <div class="wrapper wrapper-content animated fadeInDown">
	   
			   <!--编辑区 start-->
			    <div>
			        <div class="ibox-title">
			            <h5>请假查询条件</h5>
			        </div>
			        <div class="ibox-content">
			
			            <form role="form" class="form-inline">
			                <div class="form-group">
			
			                    <input type="text" placeholder="请输入工号" id="s3_stuffID" class="form-control">
			                    <input type="text" placeholder="请输入姓名" id="s3_stuffName" class="form-control">
			                    <select name="s3_stuffDepart" id="s3_stuffDepart" class="form-control">
			                        
			                    </select>
			
			
			                </div>
			                <div class="form-group" style="margin-top: 10px">
			                    <button id="sel_btn3" class="btn btn-info" type="button" style="position:relative;top:-5px"><i class="fa fa-search fa-fw"></i>查询</button>
			                    <button id="add_btn3" class="btn btn-primary" type="button" style="position:relative;top:-5px"><i class="fa fa-plus fa-fw"></i>增加
			                    </button>
			                </div>
			
			            </form>
			
			        </div>
			    </div>
			    <!--编辑区 end-->
			
			    <!--查询结果区 start-->
			    <div class="ibox">
			
			        <div class="ibox-title">
			            <h5>请假结果</h5>
			            <div class="ibox-tools">
			                <a class="collapse-link">
			                    <i class="fa fa-chevron-up"></i>
			                </a>
			
			            </div>
			        </div>
			
			        <div class="ibox-content">
			            <div class="row row-lg">
			                <div class="col-sm-12">
			                            <table id="leave_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
			                                <thead>
			                                <tr>
			                                    <th>工号</th>
			                                    <th>姓名</th>
			                                    <th>部门</th>
			                                    
			                                    <th>开始日期</th>
			                                    <th>结束日期</th>
												<th>工时/时</th>
												
												<th>请假原因</th>
												<th>审批人</th>
			                                    <th>金额</th>
												
												
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
  <!--请假 end-->	    
    
    
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
	
	
	findAllDepartmentInfo();//获得 部门查询下拉列表
	
	
	/* 调休 start*/
	findAllAdjustRestInfos(); //获取所有的调休信息
	
		//单条删除 按钮
			$("#adjustRest_tbl").on('click','.del_btn1',function(){
				var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
				
				sweetDel(delAdjustRestInfo(stuffID));  //删除弹框 ，在弹框里执行删除操作
			});
			
	    //搜索按钮
		$("#sel_btn1").click(function(){
			var stuffID = $("#s1_stuffID").val();
			var stuffName = $("#s1_stuffName").val();
			var stuffDepart="";
			if($("#s1_stuffDepart").val()==""){
			    stuffDepart ="";
			}else{
			 stuffDepart = $("#s1_stuffDepart").find("option:selected").text();
			}
		    
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllAdjustRestInfos();
			}else{
				findAdjustRestInfoByCondition(stuffID,stuffName,stuffDepart);
			}
			
		});
		
		//条件查询员工调休信息
		function findAdjustRestInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/AdjustRestServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findAdjustRestInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#adjustRest_tbl tbody");
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
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].adjustType+'</td>'+
                                    '<td>'+result[key].adjustBefore+'</td>'+
                                    '<td>'+result[key].adjustAfter+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn1" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn1" type="button">'+
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
		
		
			
			
			
		
		//单条删除
		function delAdjustRestInfo(stuffID){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/AdjustRestServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delAdjustRestInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				
				findAllAdjustRestInfos(); //获取所有的调休信息
			}
		});
			
		}
	
	
	    //获取所有的调休信息
		function findAllAdjustRestInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/AdjustRestServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllAdjustRestInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的调休信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#adjustRest_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].adjustType+'</td>'+
                                    '<td>'+result[key].adjustBefore+'</td>'+
                                    '<td>'+result[key].adjustAfter+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn1" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn1" type="button">'+
                                    '        <i class="fa fa-trash fa-fw"></i></i>删除'+
                                    '    </button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});
						 
				 }	
			});
			
		}
	
	/* 调休 end*/
	
	/* 加班 start*/
	findAllOverWorkInfos(); //获取所有的加班信息
	
		//单条删除 按钮
			$("#over_tbl").on('click','.del_btn2',function(){
				var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
				
				sweetDel(delOverWorkInfo(stuffID));  //删除弹框 ，在弹框里执行删除操作
			});
			
	    //搜索按钮
		$("#sel_btn2").click(function(){
			var stuffID = $("#s2_stuffID").val();
			var stuffName = $("#s2_stuffName").val();
			var stuffDepart="";
			if($("#s2_stuffDepart").val()==""){
			    stuffDepart ="";
			}else{
			 stuffDepart = $("#s2_stuffDepart").find("option:selected").text();
			}
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllOverWorkInfos();
			}else{
				findOverWorkInfoByCondition(stuffID,stuffName,stuffDepart);
			}
			
		});
		
		//条件查询员工加班信息
		function findOverWorkInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/OverWorkServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findOverWorkInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#over_tbl tbody");
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
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].overworkStart+'</td>'+
                                    '<td>'+result[key].overworkEnd+'</td>'+
                                    '<td>'+result[key].overworkHours+'</td>'+
                                    '<td>'+result[key].overworkReason+'</td>'+
                                    '<td>'+result[key].overworkMoney+'</td>'+
                                    '<td>'+result[key].overworkApprover+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn2" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn2" type="button">'+
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
		
		
			
			
			
		
		//单条删除
		function delOverWorkInfo(stuffID){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/OverWorkServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delOverWorkInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				
				findAllOverWorkInfos(); //获取所有的调休信息
			}
		});
			
		}
	
	
	    //获取所有的加班信息
		function findAllOverWorkInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/OverWorkServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllOverWorkInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的加班信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#over_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                     '<td>'+result[key].overworkStart+'</td>'+
                                    '<td>'+result[key].overworkEnd+'</td>'+
                                    '<td>'+result[key].overworkHours+'</td>'+
                                    '<td>'+result[key].overworkReason+'</td>'+
                                    '<td>'+result[key].overworkMoney+'</td>'+
                                    '<td>'+result[key].overworkApprover+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn2" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn2" type="button">'+
                                    '        <i class="fa fa-trash fa-fw"></i></i>删除'+
                                    '    </button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});
						 
				 }	
			});
			
		}
	
	/* 加班 end*/
	
	/* 请假 start*/
	findAllWorkLeaveInfos(); //获取所有的请假信息
	
		//单条删除 按钮
			$("#leave_tbl").on('click','.del_btn3',function(){
				var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
				
				sweetDel(delWorkLeaveInfo(stuffID));  //删除弹框 ，在弹框里执行删除操作
			});
			
	    //搜索按钮
		$("#sel_btn3").click(function(){
			var stuffID = $("#s3_stuffID").val();
			var stuffName = $("#s3_stuffName").val();
			var stuffDepart="";
			if($("#s3_stuffDepart").val()==""){
			    stuffDepart ="";
			}else{
			 stuffDepart = $("#s3_stuffDepart").find("option:selected").text();
			}
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllWorkLeaveInfos();
			}else{
				findWorkLeaveInfoByCondition(stuffID,stuffName,stuffDepart);
			}
			
		});
		
		//条件查询员工请假信息
		function findWorkLeaveInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/WorkLeaveServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findWorkLeaveInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#leave_tbl tbody");
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
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].leaveBegin+'</td>'+
                                    '<td>'+result[key].leaveEnd+'</td>'+
                                    '<td>'+result[key].leaveHours+'</td>'+
                                    '<td>'+result[key].leaveReason+'</td>'+
                                    '<td>'+result[key].approver+'</td>'+
                                    '<td>'+result[key].leaveMoney+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn3" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn3" type="button">'+
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
		
		
			
			
			
		
		//单条删除
		function delWorkLeaveInfo(stuffID){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/WorkLeaveServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delWorkLeaveInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				
				findAllWorkLeaveInfos(); //获取所有的调休信息
			}
		});
			
		}
	
	
	    //获取所有的请假信息
		function findAllWorkLeaveInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/WorkLeaveServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllWorkLeaveInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的请假信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#leave_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                     '<td>'+result[key].leaveBegin+'</td>'+
                                    '<td>'+result[key].leaveEnd+'</td>'+
                                    '<td>'+result[key].leaveHours+'</td>'+
                                    '<td>'+result[key].leaveReason+'</td>'+
                                    '<td>'+result[key].approver+'</td>'+
                                    '<td>'+result[key].leaveMoney+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn3" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '    <button class="btn btn-danger del_btn3" type="button">'+
                                    '        <i class="fa fa-trash fa-fw"></i></i>删除'+
                                    '    </button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});
						 
				 }	
			});
			
		}
	/* 请假 end*/
	
	
	
	
	
	
	//获得 部门查询下拉列表
		function findAllDepartmentInfo() {
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findAllDepartmentInfos", //请求码
				},
				error: function () {
					alert("全部部门信息数据请求失败！");
				},
				success: function (data) {
					var depStr='';   //查询下拉框  插入字符串
					var str1=$('<option value="">全部</option>');  //查询下拉框  全部选项
					var str2=$('<option value="">全部</option>');  //查询下拉框  全部选项
					var str3=$('<option value="">全部</option>');  //查询下拉框  全部选项
					var result = data.rows;
					var depSel1=$("#s1_stuffDepart"); //查询下拉列表
					depSel1.empty();
					depSel1.append(str1);
					var depSel2=$("#s2_stuffDepart"); //查询下拉列表
					depSel2.empty();
					depSel2.append(str2);
					var depSel3=$("#s3_stuffDepart"); //查询下拉列表
					depSel3.empty();
					depSel3.append(str3);
					
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						depSel1.append(depStr);
					});
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						depSel2.append(depStr);
					});
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						
						depSel3.append(depStr);
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
		function sweetDel(func,stuffID){
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
					func;
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
