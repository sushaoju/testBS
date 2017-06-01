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
    <title>培训管理</title>

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

                    <input type="text" placeholder="请输入工号" id="s_stuffID" class="form-control">
                    <input type="text" placeholder="请输入姓名" id="s_stuffName" class="form-control">
                    <select name="s_stuffDepart" id="s_stuffDepart" class="form-control">
                        
                    </select>


                </div>
                <div class="form-group" style="margin-top: 10px">
                    <button id="sel_btn" class="btn btn-info" type="button" style="position:relative;top:-5px"><i class="fa fa-search fa-fw"></i>查询</button>
                    <button id="add_btn" class="btn btn-primary" type="button" style="position:relative;top:-5px"><i class="fa fa-plus fa-fw"></i>增加
                    </button>
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
                            <table id="train_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>部门</th>

									<th>培训类型</th>
                                    <th>开始日期</th>
                                    <th>结束日期</th>
									
                                    <th>老师</th>
                                    <th>结果</th>

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
                <label for="e_trainType">培训类型:</label>
				<input id="e_trainType" class="form-control" type="text"></span>
            </div>
        </div>
		<div class="clearfix hidden-xs"></div>
		 <div class="from-group">
		    <div class="col-sm-6">
                <label for="e_trainBegin">开始时间:</label>
                <input class="form-control" type="date"  id="e_trainBegin">
            </div>
			<div class="col-sm-6">
                <label for="e_trainEnd">结束时间:</label>
                <input class="form-control" type="date"  id="e_trainEnd">
            </div>
		</div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_trainTeacher">讲师:</label>
                <input class="form-control" type="text" placeholder="请输入讲师" id="e_trainTeacher">
            </div>
			<div class="col-sm-6">
                <label for="e_trainResult">结果:</label>
                <input class="form-control" type="text" placeholder="请输入结果" id="e_trainResult">
            </div>
			
        </div>
		
       
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


<!--增加弹框 start-->
<div id="add_box">
    <h2>增加培训信息</h2>
    <form>

        <div class="form-group">
            <div class="col-sm-6">
                <label for="a_stuffID">编号:</label>
				<input id="a_stuffID" class="form-control" type="text">
            </div>
            <div class="clearfix hidden-xs"></div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_stuffName">姓名:</label>
				<span id="a_stuffName"></span>
            </div>

            <div class="col-sm-6">
                <label for="a_stuffDepart">所在部门:</label>
				<span id="a_stuffDepart"></span>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_trainType">培训类型:</label>
				<input id="a_trainType" class="form-control" type="text">
            </div>
        </div>
			<div class="clearfix hidden-xs"></div>
			
		 <div class="from-group">
		    <div class="col-sm-6">
                <label for="a_trainBegin">开始时间:</label>
                <input class="form-control" type="date"  id="a_trainBegin">
            </div>
			<div class="col-sm-6">
                <label for="a_trainEnd">结束时间:</label>
                <input class="form-control" type="date"  id="a_trainEnd">
            </div>
		</div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_trainTeacher">讲师:</label>
                <input class="form-control" type="text" placeholder="请输入讲师" id="a_trainTeacher">
            </div>			
        </div>
		<div class="clearfix hidden-xs"></div>

        <div class="from-group">
            <div class="col-sm-6 text-center">
                <button class="btn btn-primary btn-lg" type="button" id="addSubmit_btn">增加</button>

            </div>
            <div class="col-sm-6 text-center">
                <button id="add_closeBtn" class="btn btn-default btn-lg" type="button">取消</button>
            </div>
        </div>
    </form>
</div>
<!--增加弹框 end-->


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
		//编辑按钮 弹框
		$("#train_tbl").on('click','.edit_btn',function(){
			var  stuffID = $(this).parent("td").parent("tr").find("td").eq(0).text(); 
			var  stuffName =$(this).parent("td").parent("tr").find("td").eq(1).text();   
			var  stuffDepart =$(this).parent("td").parent("tr").find("td").eq(2).text();  
			var  trainType =$(this).parent("td").parent("tr").find("td").eq(3).text();   
			var  trainBegin =$(this).parent("td").parent("tr").find("td").eq(4).text();   
			var  trainEnd =$(this).parent("td").parent("tr").find("td").eq(5).text();   
			var  trainTeacher=$(this).parent("td").parent("tr").find("td").eq(6).text();  			
			var  trainReault = $(this).parent("td").parent("tr").find("td").eq(7).text();  
			
			
			$("#e_stuffID").text(stuffID);
			$("#e_stuffName").text(stuffName);
			$("#e_stuffDepart").text(stuffDepart);
			$("#e_trainType").val(trainType);
			$("#e_trainBegin").val(trainBegin);
			$("#e_trainEnd").val(trainEnd);
			$("#e_trainTeacher").val(trainTeacher);
			$("#e_trainResult").val(trainReault);
			
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
	
	
		//增加按钮 弹框
		$("#add_btn").click(function(){
			alertAddBox();
		});
		
		function alertAddBox() {
			layer.open({
				type: 1,
				closeBtn: true,
				title: false,
				area: ['600px', '400px'],
				shadeClose: false, //点击遮罩不关闭
				content: $('#add_box')
			});
	
			$("#add_box").show();
		}
		$("#add_closeBtn").click(function () {
			$(".layui-layer-close2").click();
		});
		
		
		findAllTrainInfos();//获取所有的培训信息
		findAllDepartmentInfo();//获得 部门查询下拉列表
		
		//单条删除 按钮
		$("#train_tbl").on('click','.del_btn',function(){
			var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
			
			sweetDel(stuffID);  //删除弹框 ，在弹框里执行删除操作
		});
		
		
		//编辑提交按钮
	    $("#editSubmit_btn").click(function(){
			  var  stuffID= $("#e_stuffID").text();
			  var  stuffName= $("#e_stuffName").text();
			  var  stuffDepart= $("#e_stuffDepart").text();
			  var  trainType = $("#e_trainType").val();
			  var  trainBegin = $("#e_trainBegin").val();
			  var  trainEnd = $("#e_trainEnd").val();
			  var  trainTeacher = $("#e_trainTeacher").val();
			  var  trainReault = $("#e_trainResult").val();
			  
			  updateTrainInfo(stuffID,stuffName,stuffDepart,trainType,trainBegin,trainEnd,trainTeacher,trainReault);
		});
		
		
		
		//增加弹框  工号失去焦点
		$("#a_stuffID").blur(function(){
			var stuffID=$("#a_stuffID").val();
			findJobInfoById(stuffID);//根据id 查询员工岗位信息表
		});
		
		
		//增加提交按钮
		$("#addSubmit_btn").click(function(){
			  var  stuffID= $("#a_stuffID").val();
			  var  stuffName= $("#a_stuffName").text();
			  var  stuffDepart= $("#a_stuffDepart").text();
			  var  trainType = $("#a_trainType").val();
			  var  trainBegin = $("#a_trainBegin").val();
			  var  trainEnd = $("#a_trainEnd").val();
			  var  trainTeacher = $("#a_trainTeacher").val();
			  var  trainReault = $("#a_trainResult").val();
			  
			var type_str="warning";
			if($.trim(stuffID)==''){warn_str="请输入正确格式的员工工号";sweetWarn(warn_str,type_str);return false;}
			
			addTrainInfo(stuffID,stuffName,stuffDepart,trainType,trainBegin,trainEnd,trainTeacher,trainReault)
		});
		
		//搜索按钮
		$("#sel_btn").click(function(){
			var stuffID = $("#s_stuffID").val();
			var stuffName = $("#s_stuffName").val();
			var stuffDepart="";
			if($("#s2_stuffDepart").val()==""){
			    stuffDepart ="";
			}else{
			 stuffDepart = $("#s2_stuffDepart").find("option:selected").text();
			}
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllTrainInfos();
			}else{
				findTrainInfoByCondition(stuffID,stuffName,stuffDepart);
			}
			
		});
		
		
		
		
		//条件查询员工培训信息
		function findTrainInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/TrainInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findTrainInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#train_tbl tbody");
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
                                    '<td>'+result[key].trainType+'</td>'+
                                    '<td>'+result[key].trainBegin+'</td>'+
                                    '<td>'+result[key].trainEnd+'</td>'+
                                    '<td>'+result[key].trainTeacher+'</td>'+
									'<td>'+result[key].trainResult+'</td>'+
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
		
		
		
		
		
		
		
		
		
		//增加培训信息
		function addTrainInfo(stuffID,stuffName,stuffDepart,trainType,trainBegin,trainEnd,trainTeacher,trainReault){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/TrainInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "addTrainInfo", //请求码
					"stuffName":stuffName, 
					"stuffID":stuffID, 
					"stuffDepart":stuffDepart,  
					"trainType":trainType,
					"trainBegin":trainBegin,
					"trainEnd":trainEnd,
					"trainTeacher":trainTeacher,
					"trainResult":trainReault
				},
				error: function () {
					alert("增加培训信息请求失败！");
				},
				success:function(data){
					$("#add_closeBtn").click();
					var warn_str="增加培训信息操作成功！";
	                var type_str="success";
				    sweetWarn(warn_str,type_str);
					
					findAllTrainInfos();
				}
			})
		}
		
		
		//更新培训信息
		function updateTrainInfo(stuffID,stuffName,stuffDepart,trainType,trainBegin,trainEnd,trainTeacher,trainReault){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/TrainInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "updateTrainInfo", //请求码
					"stuffName":stuffName, 
					"stuffID":stuffID, 
					"stuffDepart":stuffDepart,  
					"trainType":trainType,
					"trainBegin":trainBegin,
					"trainEnd":trainEnd,
					"trainTeacher":trainTeacher,
					"trainResult":trainReault
				},
				error: function () {
					alert("更新培训信息请求失败！");
				},
				success:function(data){
					$("#edit_closeBtn").click();
					var warn_str="修改培训信息请求成功！";
	                var type_str="success";
				    sweetWarn(warn_str,type_str);
					
					findAllTrainInfos();
				}
			})
		}
		
		
		
		
		//单条删除培训信息
		function delTrainInfo(stuffID){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/TrainInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delTrainInfo", //请求码
				"stuffID":stuffID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				
				findAllTrainInfos()
			}
		});
		}
		
		
		//获取所有的培训信息
		function findAllTrainInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/TrainInfoServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllTrainInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的培训信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#train_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].trainType+'</td>'+
                                    '<td>'+result[key].trainBegin+'</td>'+
                                    '<td>'+result[key].trainEnd+'</td>'+
                                    '<td>'+result[key].trainTeacher+'</td>'+
									'<td>'+result[key].trainResult+'</td>'+
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
		
		
		
		//根据id 查询员工岗位信息表
		function findJobInfoById(stuffID){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "findJobInfoById", //请求码
					"stuffID":stuffID
				},
				error: function () {
					alert("根据id 查询员工岗位信息请求失败！");
				},
				success:function(data){
					if(data=="null"||data==null){
						alert("查询不到此员工");
						$("#a_stuffID").val("");
						return false;
					}else{
						var data=JSON.parse(data);
						$("#a_stuffName").text(data.stuffName);
			            $("#a_stuffDepart").text(data.stuffDepart);
						
					}	
				}
			})
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
					delTrainInfo(stuffID);
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
 
	
