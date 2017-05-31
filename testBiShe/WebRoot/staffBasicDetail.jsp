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
    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，
    她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <title>员工基本信息详情</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="css_mine/personnelManagement.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInDown">
    <div id="staff_detail" class="ibox">
        <div class="ibox-content">
            <h1>
            员工信息详情
             <a class="pull-right" href="stuffBasic.jsp" style="font-size: 13px"> 返回员工基本信息表<<</a>
            </h1>
            <h3>1、员工基本信息</h3>
            <div class="row">
                <div class="col-sm-4">工号：<span id="stuffId"></span></div>
                <div class="col-sm-4">姓名：<span id="stuffName"></span></div>
                <div class="col-sm-4">性别：<span id="stuffSex"></span></div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">出生日期：<span id="stuffBirth"></span></div>
                <div class="col-sm-4">民族：<span id="stuffNation"></span></div>
                <div class="col-sm-4">地址：<span id="stuffAddress"></span></div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">婚况：<span id="stuffWedding"></span></div>
                <div class="col-sm-4">电话：<span id="stuffTel"></span></div>
                <div class="col-sm-4">邮箱：<span id="stuffEmail"></span></div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">职称：<span id="stuffGrade"></span></div>
                <div class="col-sm-8">技能：<span id="stuffSkill"></span></div>
                <div class="clearfix hidden-xs"></div>
            </div>

            <h3>2、员工教育背景信息</h3>
            <div class="row">
                <div class="col-sm-4">毕业院校：<span id="stuffColleage"></span></div>
                <div class="col-sm-4">专业：<span id="stuffProfession"></span></div>
                <div class="col-sm-4">学历：<span id="stuffEdu"></span></div>
                <div class="clearfix hidden-xs"></div>
            </div>

            <h3>3、员工岗位信息</h3>
            <div class="row">
                <div class="col-sm-4">所在部门：<span id="stuffDepart"></span></div>
                <div class="col-sm-4">职务：<span id="stuffDuty"></span></div>
                <div class="col-sm-4">任职状态：<span id="stuffStatus"></span></div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">入职日期：<span id="stuffEntryDate"></span></div>
                <div class="col-sm-4">合同开始日期：<span id="contractBegin"></span></div>
                <div class="col-sm-4">合同结束日期：<span id="contractEnd"></span></div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">薪酬：<span id="stuffMoney"></span></div>
                <div class="col-sm-4">调岗日期：<span id="adjustJob"></span></div>
                <div class="col-sm-4">调薪日期：<span id="adjustMoney"></span></div>
                <div class="clearfix hidden-xs"></div>
            </div>
        </div>
    </div>

</div>


<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/content.min.js?v=1.0.0"></script>
<script>
$(function(){	
	var stuffId= localStorage.getItem("stuffId")  //员工ID
	$("#stuffId").text(stuffId);
	findStuffInfoById(stuffId); //根据id查 员工基本信息表
	findJobInfoById(stuffId); //根据id查 员工岗位信息表
	
	
	//根据id查 员工基本信息表
	function findStuffInfoById(stuffId){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findStuffInfoById", //请求码
					"stuffID": stuffId
				},
				error: function () {
					alert("获取所有员工基本信息请求失败！");
				},
			success:function(data){
				$("#stuffAddress").text(data.stuffAddress);
				$("#stuffBirth").text(data.stuffBirth);
				$("#stuffColleage").text(data.stuffColleage);
				$("#stuffEdu").text(data.stuffEdu);
				$("#stuffEmail").text(data.stuffEmail);
				$("#stuffGrade").text(data.stuffGrade);
				$("#stuffName").text(data.stuffName);
				$("#stuffNation").text(data.stuffNation);
				$("#stuffProfession").text(data.stuffProfession);
				$("#stuffSkill").text(data.stuffSkill);
				$("#stuffTel").text(data.stuffTel);
				
				if(data.stuffSex=='M'){
					$("#stuffSex").text("男");
				}else{
					$("#stuffSex").text("nv");
				}
				
				if(data.stuffSex=='0'){
					$("#stuffWedding").text("未婚");
				}else{
					$("#stuffWedding").text("已婚");
				}	
			}
		});
	}
	
	//根据id查 员工岗位信息表
	function findJobInfoById(stuffId){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findJobInfoById", //请求码
					"stuffID": stuffId
				},
				error: function () {
					alert("全部员工岗位信息表请求失败！");
				},
			success:function(data){
				$("#adjustJob").text(data.adjustJob);
				$("#adjustMoney").text(data.adjustMoney);
				$("#contractBegin").text(data.contractBegin);
				$("#contractEnd").text(data.contractEnd);
				$("#stuffDepart").text(data.stuffDepart);
				$("#stuffDuty").text(data.stuffDuty);
				$("#stuffEntryDate").text(data.stuffEntryDate);
				$("#stuffMoney").text(data.stuffMoney);
				$("#stuffStatus").text(data.stuffStatus);
			}
		});
		
	}
	
	
});
</script>
</body>
</html>