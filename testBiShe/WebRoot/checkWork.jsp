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
    <title>考勤</title>

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
            <h5>查询条件</h5>
        </div>
        <div class="ibox-content">

            <form role="form" class="form-inline">
                <div class="form-group">
                    <label for="s_stuffID">工号：</label>
                    <input type="text" placeholder="请输入工号" id="s_stuffID" class="form-control">
                    <label for="s_stuffName">姓名：</label>
                    <input type="text" placeholder="请输入姓名" id="s_stuffName" class="form-control">
                    <label for="s_stuffDepart">部门：</label>
                    <select name="s_stuffDepart" id="s_stuffDepart" class="form-control"></select>
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
            <h5>查询结果</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>

            </div>
        </div>

        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                            <table id="check_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>部门</th>

                                    <th>班次</th>
                                    <th>工时</th>
                                    <th>迟到/时</th>
                                    <th>旷工/时</th>
                                    <th>日期</th>

                                    <th>操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td>2</td>
                                    <td>sugar</td>
                                    <td>技术部</td>

                                    <td>白班</td>
                                    <td>8</td>
                                    <td>0</td>
                                    <td>0</td>
                                    <td>2017.05.14</td>
                                    <td>
                                        <button class="btn btn-info edit_btn" type="button">
                                            <i class="fa fa-pencil fa-fw"></i>编辑
                                        </button>
                                        <button class="btn btn-danger del_btn" type="button">
                                            <i class="fa fa-trash fa-fw"></i></i>删除
                                        </button>
                                    </td>
                                </tr>
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
    <h2>编辑考勤信息</h2>
    <form>
        <div class="form-group">
            <div class="col-sm-6">
                <label for="e_stuffID">工号:</label>
                <span id="e_stuffID"></span>
            </div>
            <div class="clearfix hidden-xs"></div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_stuffName">姓名:</label>
				<span id="e_stuffName"></span>
            </div>

            <div class="col-sm-6">
                <label for="e_stuffDepart">所在部门:</label>
				<span id="e_stuffDepart"></span>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_stuffShift">班次:</label>
                 <select name="e_stuffShift" id="e_stuffShift" class="form-control">
                        <option value="白班">白班</option>
                        <option value="夜班">夜班</option>
                </select>
            </div>
            <div class="col-sm-6">
                <label for="e_workHour">工时/时:</label>
                <input class="form-control" type="text" placeholder="请输入工时" id="e_workHour">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_workDate">日期:</label>
                <input class="form-control" type="date"id="e_workDate">
            </div>
			<div class="col-sm-6">
                <label for="e_lateHour">迟到/时:</label>
                <input class="form-control" type="text"id="e_lateHour">
            </div>
        </div>
        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_absentHour">旷工/时:</label>
                <input class="form-control" type="text"id="e_absentHour">
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
	
	findAllDepartmentInfo(); //获得 部门查询下拉列表
	findAllCheckInfos(); //获取所有考勤信息
	
	//编辑按钮 弹框
		$("#check_tbl").on('click','.edit_btn',function(){
			var  stuffID = $(this).parent("td").parent("tr").find("td").eq(0).text(); 
			var  stuffName =$(this).parent("td").parent("tr").find("td").eq(1).text();   
			var  stuffDepart =$(this).parent("td").parent("tr").find("td").eq(2).text();  
			var  stuffShift =$(this).parent("td").parent("tr").find("td").eq(3).text();   
			var  workHour =$(this).parent("td").parent("tr").find("td").eq(4).text();   
			var  lateHour =$(this).parent("td").parent("tr").find("td").eq(5).text();   
			var  absentHour=$(this).parent("td").parent("tr").find("td").eq(6).text();  			
			var  workDate = $(this).parent("td").parent("tr").find("td").eq(7).text();  
			
			
			$("#e_stuffID").text(stuffID);
			$("#e_stuffName").text(stuffName);
			$("#e_stuffDepart").text(stuffDepart);
			
			$("#e_stuffShift").val(stuffShift);
			$("#e_workHour").val(workHour);
			$("#e_lateHour").val(lateHour);
			$("#e_absentHour").val(absentHour);
			$("#e_workDate").val(workDate);
			
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
		$("#check_tbl").on('click','.del_btn',function(){
			var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
			
			sweetDel(stuffID);  //删除弹框 ，在弹框里执行删除操作
		}); 
		
	//查询按钮	
	$("#sel_btn").click(function(){
		var stuffID = $("#s_stuffID").val();
			var stuffName = $("#s_stuffName").val();
			var stuffDepart = $("#s_stuffDepart").val();
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllCheckInfos(); //获取所有考勤信息
			}else{
				findCheckInfoByCondition(stuffID,stuffName,stuffDepart);
			}
	});	
	
	
	
	//编辑提交按钮
	    $("#editSubmit_btn").click(function(){
			  var  stuffID= $("#e_stuffID").text();
			  var  stuffName= $("#e_stuffName").text();
			  var  stuffDepart= $("#e_stuffDepart").text();
			  var  stuffShift = $("#e_stuffShift").val();
			  var  workHour =$("#e_workHour").val();
			  var  lateHour = $("#e_lateHour").val();
			  var  absentHour=$("#e_absentHour").val();
			  var  workDate =$("#e_workDate").val();
			  
			  updateCheckInfo(stuffID,stuffName,stuffDepart,stuffShift,workHour,lateHour,absentHour,workDate);
		});
	
	//更新考勤信息
		function updateCheckInfo(stuffID,stuffName,stuffDepart,stuffShift,workHour,lateHour,absentHour,workDate){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/CheckInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "updateCheckInfo", //请求码
					"stuffName":stuffName, 
					"stuffID":stuffID, 
					"stuffDepart":stuffDepart,  
					"stuffShift":stuffShift,
					"workHour":workHour,
					"lateHour":lateHour,
					"absentHour":absentHour,
					"workDate":workDate
				},
				error: function () {
					alert("更新培训信息请求失败！");
				},
				success:function(data){
					$("#edit_closeBtn").click();
					var warn_str="修改考勤信息成功！";
	                var type_str="success";
				    sweetWarn(warn_str,type_str);
					
					findAllCheckInfos(); //获取所有考勤信息
				}
			})
		}
	
	
	
	
	//条件查询员工考勤信息
		function findCheckInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/CheckInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findCheckInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#check_tbl tbody");
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
                                    '<td>'+result[key].stuffShift+'</td>'+
                                    '<td>'+result[key].workHour+'</td>'+
                                    '<td>'+result[key].lateHour+'</td>'+
                                    '<td>'+result[key].absentHour+'</td>'+
									'<td>'+result[key].workDate+'</td>'+
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
	
		
		
	
	//单条删除
	function  delCheckInfo(stuffID){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/CheckInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delCheckInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				alert("删除人员请求成功！");
				
				findAllCheckInfos(); //获取所有考勤信息
			}
		});
	}
	
	//获取所有考勤信息
   function findAllCheckInfos(){
	   $.ajax({
				 url: "<%=request.getContextPath()%>/servlet/CheckInfoServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllCheckInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有考勤信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#check_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].stuffShift+'</td>'+
                                    '<td>'+result[key].workHour+'</td>'+
                                    '<td>'+result[key].lateHour+'</td>'+
                                    '<td>'+result[key].absentHour+'</td>'+
									'<td>'+result[key].workDate+'</td>'+
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
					var result = data.rows;
					var depSel=$("#s_stuffDepart"); //查询下拉列表
					depSel.empty();
					depSel.append(str1);
					 
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						depSel.append(depStr);
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
					delCheckInfo(stuffID);
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
   

