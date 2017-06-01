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
    <title>员工薪资</title>

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
                        <option value="0">技术部</option>
                        <option value="1">财务部</option>
                    </select>

                    <button  id="sel_btn" class="btn btn-info" type="button"><i class="fa fa-search fa-fw"></i>查询</button>

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
                            <table id="salary_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>部门</th>
									<th>岗位</th>

                                    <th>基本工资</th>
                                    <th>扣除</th>
                                    <th>奖励</th>
                                    <th>补贴</th>
                                    <th>实发工资</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                </tbody>
                            </table>
                </div>
            </div>
        </div>
    </div>
    <!--查询结果区 end-->
</div>


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
	
	//搜索部门下拉列表
	findAllDepartmentInfo();
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
		
		
		
	//获取全部信息
	findAllSalaryInfos();
	
	//获取所有的薪资信息
		function findAllSalaryInfos(){
			$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/SalaryInfoServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllSalaryInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有的薪资信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#salary_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].stuffDuty+'</td>'+
                                    '<td>'+result[key].basicSalary+'</td>'+
                                    '<td>'+result[key].delSalary+'</td>'+
                                    '<td>'+result[key].addSalary+'</td>'+
                                    '<td>'+result[key].accountAwce+'</td>'+
                                    '<td>'+result[key].fSalary+'</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});
						 
				 }	
			});
			
		}
		
	
	
	//查询按钮
	$("#sel_btn").click(function(){
			var stuffID = $("#s_stuffID").val();
			var stuffName = $("#s_stuffName").val();
			var stuffDepart="";
			if($("#s_stuffDepart").val()==""){
			    stuffDepart ="";
			}else{
			 stuffDepart = $("#s_stuffDepart").find("option:selected").text();
			}
			
			if(stuffID==""&&stuffName==""&&stuffDepart==""){
				findAllSalaryInfos();
			}else{
				findSalaryInfoByCondition(stuffID,stuffName,stuffDepart);
			}
			
		});
		
	
	
	//条件查询员工奖惩信息
		function findSalaryInfoByCondition(stuffID,stuffName,stuffDepart){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/SalaryInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findSalaryInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#salary_tbl tbody");
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
                                   '<td>'+result[key].stuffDuty+'</td>'+
                                    '<td>'+result[key].basicSalary+'</td>'+
                                    '<td>'+result[key].delSalary+'</td>'+
                                    '<td>'+result[key].addSalary+'</td>'+
                                    '<td>'+result[key].accountAwce+'</td>'+
                                    '<td>'+result[key].fSalary+'</td>'+
                        '</tr>');									
						tbl.append(tbl_str);						
				});
				}
					
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
		
		
		
	
});


</script>

</body>
</html>
   
	
