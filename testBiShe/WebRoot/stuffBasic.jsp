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
    <title>员工基本信息</title>

    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
	<!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
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
                    <!--<label for="stuffID" class="sr-only">工号</label>-->
                    <label for="stuffID">工号:</label>
                    <input type="text" placeholder="请输入用户名" id="stuffID" class="form-control">
                </div>

                <div class="form-group">
                    <label for="stuffName">姓名:</label>
                    <input type="text" placeholder="请输入用户名" id="stuffName" class="form-control">
                </div>

                <div class="form-group">
                    <label for="department_name">部门名称:</label>

                    <select name="department_name" id="department_name" class="form-control"
                            style="display:inline-block;width:150px">
                    </select>
                </div>

                <button id="sel_btn" class="btn btn-info" type="button"><i class="fa fa-search fa-fw"></i>查询</button>
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
                            <table id="stuff_tbl" class="table table-striped table-hover" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>部门</th>
                                    <th>职务</th>
                                    <th>任职状态</th>
                                    <th>联系方式</th>

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
        </div>
    </div>
    <!--查询结果区 end-->
</div>


<!--编辑按钮 弹框-->
<div id="edit_box">
    <h2>编辑员工信息</h2>
    <form>
        <div class="form-group">
            <label class="col-sm-2" for="e_stuffID">工号:</label>
            <span class="col-sm-10" id="e_stuffID"></span>
            <br>
        </div>
        <div class="clearfix hidden-xs"></div>

        <div class="col-sm-6">
            <label for="e_stuffName">姓名:</label>
            <input class="form-control" type="text" placeholder="请输入用户名" id="e_stuffName" maxlength=64>
        </div>
        <div class="col-sm-6">
            <label for="e_stuffBirth">出生日期:</label>
            <input class="form-control" type="date" placeholder="请输入出生日期" id="e_stuffBirth" maxlength=10>
        </div>
        <div class="clearfix hidden-xs"></div>

		
        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_sex">性别:</label>
                <select name="e_sex" id="e_sex" class="form-control">
                    <option value="M">男</option>
                    <option value="F">女</option>
                </select>
            </div>
            <div class="col-sm-6">
                <label for="e_stuffNation">民族:</label>
                <input class="form-control" type="text" placeholder="请输入民族" id="e_stuffNation" maxlength=15>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>
		
		
        <div class="from-group">
            <div class="col-sm-12">
                <label for="e_stuffAddress">籍贯:</label>
                <input class="form-control" type="text" placeholder="请输入籍贯" id="e_stuffAddress" maxlength=50>
            </div>              
        </div>
        <div class="clearfix hidden-xs"></div>
		
	
	
		<div class="from-group">
        <div class="col-sm-6">
            <label for="stuffTel">手机号:</label>
            <input class="form-control" type="text" placeholder="请输入手机号" id="stuffTel"
			    maxlength=11 onkeyup="this.value=this.value.replace(/\D/g,'')">
        </div>
        <div class="col-sm-6">
            <label for="e_stuffEdu">学历:</label>
            <select name="e_stuffEdu" id="e_stuffEdu" class="form-control">
                <option value="研究生以上">研究生以上</option>
                <option value="研究生">研究生</option>
                <option value="本科">本科</option>
                <option value="专科">专科</option>
            </select>
        </div>
		</div>
		<div class="clearfix hidden-xs"></div>
		
		
		
        <div class="from-group">
            <div class="col-sm-12">
                <label for="e_stuffEmail">邮箱: </label>
                <input class="form-control" type="email" placeholder="请输入邮箱" id="e_stuffEmail" maxlength=64>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>
		
		
		
		 <div class="from-group">
            <div class="col-sm-12">
                <label for="e_stuffColleage">毕业院校: </label>
                <input class="form-control" type="text" placeholder="请输入毕业院校" id="e_stuffColleage" maxlength=20>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>
		
		
		<div class="from-group">
            <div class="col-sm-12">
                <label for="e_stuffProfession">专业: </label>
                <input class="form-control" type="text" placeholder="请输入专业" id="e_stuffProfession" maxlength=20>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>
		
		
		<div class="from-group">	
        <div class="col-sm-6">
            <label for="e_stuffGrade">职称:</label>
            <input class="form-control" type="text" placeholder="请输入职称" id="e_stuffGrade" maxlength=50>
	    </div>
            <div class="col-sm-6">
                <label for="stuffWedding">婚况:</label>
				<select name="e_wedding" id="stuffWedding" class="form-control">
                <option value="0">未婚</option>
                <option value="1">已婚</option>
            </select>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>
		
		
      <div class="from-group">
            <div class="col-sm-12">
                <label for="e_stuffSkill">技能:</label>
            <input class="form-control" type="text" placeholder="请输入技能" id="e_stuffSkill" maxlength=100>
            </div>
        </div>
        <div class="clearfix hidden-xs"></div>

		
        <div class="from-group">
            <div class="col-sm-6 text-center">
                <button id="edit_submitBtn" class="btn btn-primary btn-lg" type="button">确定</button>
            </div>
            <div class="col-sm-6 text-center">
                <button id="edit_closeBtn" class="btn btn-default btn-lg" type="button">取消</button>
            </div>
        </div>
    </form>

</div>


<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="js/content.min.js?v=1.0.0"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="js/demo/bootstrap-table-demo.min.js"></script>

<script>

   
	
	$(function(){
		 //编辑按钮 弹框
		$("#stuff_tbl").on('click','.edit_btn',function () {
			var stuffId=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
			$("#e_stuffID").text(stuffId); //工号
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
			var stuffId=$("#e_stuffID").text();
			findStuffInfoById(stuffId); //根据ID 查询员工基本信息
		}
		$("#edit_closeBtn").click(function () {
			$(".layui-layer-close2").click();
		});

		//详情按钮 跳转
		$("#stuff_tbl").on('click','.detail_btn',function () {
			var stuffId=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
			localStorage.setItem("stuffId",stuffId);
			location.href = "staffBasicDetail.jsp";
		});
		
		
		
		
		
		
		
		findAllDepartmentInfo();//获得 部门查询下拉列表
		findAllStuffInfos();  //获取所有员工基本信息
		
		$("#sel_btn").click(function(){
			var sel_id=$("#stuffID").val();
			var sel_name=$("#stuffName").val();
			var sel_dep=$("#department_name").find("option:selected").text();
			if(sel_id==""&&sel_name==""&&sel_dep==""){
				findAllStuffInfos();
			}else{
				findStuffInfoByCondition(sel_id,sel_name,sel_dep);
			}
		});
		
		
		$("#edit_submitBtn").click(function(){
			var stuffId = $("#e_stuffID").text(); //工号
			var stuffName = $("#e_stuffName").val();
			var stuffBirth = $("#e_stuffBirth").val();
			var stuffsex = $("#e_sex").val();
			var stuffNation = $("#e_stuffNation").val();
			var stuffAddress = $("#e_stuffAddress").val();
			var stuffTel = $("#stuffTel").val();
			var stuffEdu = $("#e_stuffEdu").val();
			var stuffEmail = $("#e_stuffEmail").val();
			var stuffColleage = $("#e_stuffColleage").val();
			var stuffProfession = $("#e_stuffProfession").val();
			var stuffGrade = $("#e_stuffGrade").val();
			var stuffWedding = $("#stuffWedding").val();
			var stuffSkill = $("#e_stuffSkill").val();
			
			
			var regPhone = /^1[34578]\d{9}$/; // 手机号正则
            var regEmail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;  // 邮箱正则
		    var warn_str="";
		    var type_str="warning";
		    if($.trim(stuffName)==''){warn_str="请输入正确格式的姓名";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffBirth)==''){warn_str="请输入正确格式的出生日期";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffNation)==''){warn_str="请输入正确格式的民族";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffAddress)==''){warn_str="请输入正确格式的地址";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffTel)=='' || !regPhone.test(stuffTel)){warn_str="请输入正确格式的电话";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffEmail)=='' || !regEmail.test(stuffEmail)){warn_str="请输入正确格式的邮箱";sweetWarn(warn_str,type_str);return false;}
			if($.trim(stuffColleage)==''){warn_str="请输入正确格式的毕业院校";sweetWarn(warn_str,type_str);return false;}
		    if($.trim(stuffProfession)==''){warn_str="请输入正确格式的专业";sweetWarn(warn_str,type_str);return false;}
			
			
			
			updateStuffInfo(stuffId,stuffName,stuffBirth,stuffsex,stuffNation,stuffAddress,stuffTel,stuffEdu,stuffEmail,stuffColleage,stuffProfession,stuffGrade,stuffWedding,stuffSkill);
		    
		});
		
		//修改 员工基本信息表
		function updateStuffInfo(stuffId,stuffName,stuffBirth,stuffsex,stuffNation,stuffAddress,stuffTel,stuffEdu,stuffEmail,stuffColleage,stuffProfession,stuffGrade,stuffWedding,stuffSkill){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "updateStuffInfo", //请求码
					"stuffId":stuffId,
					"stuffName":stuffName, //姓名
					"stuffBirth":stuffBirth,
					"stuffSex":stuffsex, 
					"stuffNation":stuffNation, 
					"stuffAddress":stuffAddress,
					"stuffTel":stuffTel,
					"stuffEmail":stuffEmail,
					"stuffEdu":stuffEdu,
					"stuffColleage":stuffColleage,
					"stuffProfession":stuffProfession,
					"stuffGrade":stuffGrade,
					"stuffWedding":stuffWedding,
					"stuffSkill":stuffSkill
				},
				error: function () {
					alert("修改人员名单数据请求失败！");
				},
				success:function(data){
					$("#edit_closeBtn").click();
					sweetWarn("员工信息修改成功","success");
				}
			});
		}
		
		//根据ID 查询员工基本信息
		function findStuffInfoById(stuffID){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "findStuffInfoById", //请求码
					"stuffID":stuffID
				},
				error: function () {
					alert("根据ID查询员工基本信息请求失败！");
				},
				success:function(data){
					var data= JSON.parse(data);
					
					$("#e_stuffName").val(data.stuffName);
					$("#e_stuffBirth").val(data.stuffBirth);
					$("#e_sex").val(data.stuffSex);
					$("#e_stuffNation").val(data.stuffNation);
					$("#e_stuffAddress").val(data.stuffAddress);
					$("#stuffTel").val(data.stuffTel);
					$("#e_stuffEdu").val(data.stuffEdu);
					$("#e_stuffEmail").val(data.stuffEmail);
					$("#e_stuffColleage").val(data.stuffColleage);
					$("#e_stuffProfession").val(data.stuffProfession);
					$("#e_stuffGrade").val(data.stuffGrade);
					$("#stuffWedding").val(data.stuffWedding);
					$("#e_stuffSkill").val(data.stuffSkill);									
				}
			});
			
		}
		
		
		
		
		//条件查询员工基本信息
		function findStuffInfoByCondition(stuffId,stuffName,depName){
			$.ajax({
			url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
			type: "post",
			cache: false,
			dataType: "json",
			data: {
				"reqCode": "findStuffInfoByCondition", //请求码
				"stuffName":stuffName, //姓名
				"stuffId":stuffId, //工号
				"depName":depName  //部门ID
			},
			error: function () {
				alert("条件查询人员名单数据请求失败！");
			},
			success:function(data){
				var tbl=$("#stuff_tbl tbody");
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
                                    '<td>'+result[key].stuffSex+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].stuffDuty+'</td>'+
                                    '<td>'+result[key].stuffStatus+'</td>'+
                                    '<td>'+result[key].stuffTel+'</td>'+
                                    '<td>'+
                                    '<button class="btn btn-info edit_btn" type="button">'+
                                    '    <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '</button>'+
                                    '<button class="btn btn-primary detail_btn" type="button">'+
                                    '    <i class="fa fa-list fa-fw"></i>详情'+
                                    '</button>'+
                                    '</td>'+
                        '</tr>');									
						tbl.append(tbl_str);						
				});
				}
			}	
				
		});
		}
		
		
		//获取所有员工基本信息
		function findAllStuffInfos(){
			$.ajax({
				url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findAllStuffInfos", //请求码
				},
				error: function () {
					alert("获取所有员工基本信息请求失败！");
				},
				success:function(data){
					var tbl=$("#stuff_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var stuff_result = data.rows1;
					var job_result = data.rows2;
				    tbl.empty();
					
					for(var i=0;i<stuff_result.length;i++){
						var stuffDepart_j=job_result[i].stuffDepart;
						var stuffDuty_j=job_result[i].stuffDuty;
						var stuffStatus_j=job_result[i].stuffStatus;
						
						stuff_result[i].stuffDepart=stuffDepart_j;
						stuff_result[i].stuffDuty=stuffDuty_j;
						stuff_result[i].stuffStatus=stuffStatus_j;
					}
					
					$(stuff_result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+stuff_result[key].stuffID+'</td>'+
                                    '<td>'+stuff_result[key].stuffName+'</td>'+
                                    '<td>'+stuff_result[key].stuffSex+'</td>'+
                                    '<td>'+stuff_result[key].stuffDepart+'</td>'+
                                    '<td>'+stuff_result[key].stuffDuty+'</td>'+
                                    '<td>'+stuff_result[key].stuffStatus+'</td>'+
                                    '<td>'+stuff_result[key].stuffTel+'</td>'+
                                    '<td>'+
                                    '<button class="btn btn-info edit_btn" type="button">'+
                                    '    <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '</button>'+
                                    '<button class="btn btn-primary detail_btn" type="button">'+
                                    '    <i class="fa fa-list fa-fw"></i>详情'+
                                    '</button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
					});		               
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
					var depSel=$("#department_name"); //查询下拉列表
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
		
	
	
	});
</script>
</body>
</html>
