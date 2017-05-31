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
    <title>应聘人员名单</title>

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
            <h5>应聘人员查询条件</h5>
            <a class="pull-right" href="recruitInfo.jsp">返回招聘信息<<</a>
        </div>
        <div class="ibox-content">
            <form role="form" class="form-inline">
                <div class="form-group">
                    <input type="text" placeholder="请输入姓名" id="recruitName" class="form-control">

                        <label for="demandJob">应聘职位:</label>
                        <select name="demandJob" id="demandJob"
                        class="form-control" style="display:inline-block;width:150px">
                        <option value="">全部</option>
                        </select>
                </div>

                <button   id="ap_selBtn"  class="btn btn-info" type="button"><i class="fa fa-search fa-fw"></i>查询</button>
                </button>
                <button id="ap_delBtn" class="btn btn-danger" type="button"><i class="fa fa-trash-o fa-fw"></i>删除
                </button>
            </form>
        </div>
    </div>
    <!--编辑区 end-->

    <!--查询结果区 start-->
    <div class="ibox">

        <div class="ibox-title">
            <h5>应聘人员查询结果</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>

            </div>
        </div>

        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <table class="table table-striped table-hover" data-mobile-responsive="true" id="applicantTbl">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>年龄</th>

                            <th>学历</th>
                            <th>应聘职位</th>
                            <th>工作经验</th>
                            <th>技能</th>

                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody></tbody>
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
    // 录用按钮
	$("#applicantTbl").on('click','.edit_btn',function(){
		
		var apId=$(this).parent("td").parent("tr").find("td").eq(0).text();   //应聘人编号
		var apName=$(this).parent("td").parent("tr").find("td").eq(1).text();   //应聘人姓名
		var apEdu=$(this).parent("td").parent("tr").find("td").eq(3).text();   //应聘人学历
		var apDuty=$(this).parent("td").parent("tr").find("td").eq(4).text();   //应聘职位
		var apSkill=$(this).parent("td").parent("tr").find("td").eq(6).text();   //技能
		
		var apObject={
			'apId':apId,
			'apEdu':apEdu,
			'apDuty':apDuty,
			'apSkill':apSkill
		}
		localStorage.setItem("apObject",JSON.stringify(apObject))
        location.href = "hiringYou.jsp";
    });
</script>

<script type="text/javascript">
$(function(){

    findAllApplicantInfos();  //全部应聘人员名单
	
	//查询 按钮
	$("#ap_selBtn").click(function(){
        var recruitName=$("#recruitName").val();   //应聘人姓名
        var demandJob=$("#demandJob").val();  //应聘职位
        var reqCodeValue="findApplicantInfoByCondition"; //请求码
		if(recruitName==''&&demandJob==''){
			findAllApplicantInfos();
		}else{
			findApplicantInfoByCondition(recruitName,demandJob,reqCodeValue); //条件查询人员名单   
		}
		    
	});
	
	//单条删除按钮
	$("#applicantTbl").on('click','.del_btn',function(){
		var appID = $(this).parent("td").parent("tr").find("td").eq(0).text();         
		delApplicantInfo(appID);
	});
	
	//单条删除
	function delApplicantInfo(appID){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/ApplicantInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "delApplicantInfo", //请求码
				"id":appID, //应聘人ID
			},
			error:function () {
				alert("删除人员请求失败！");
			},
			success:function(data){
				var warn_str="删除人员成功！";
	            var type_str="success";
				sweetWarn (str,type);
				findAllApplicantInfos();
			}
		});
	}
	
	
	//条件查询人员名单
	function findApplicantInfoByCondition(recruitName,demandJob,reqCodeValue){	
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/ApplicantInfoServlet",
			type: "post",
			cache: false,
			dataType: "json",
			data: {
				"reqCode": reqCodeValue, //请求码
				"recruitName":recruitName, //应聘人姓名
				"demandJob":demandJob //应聘职位
			},
			error: function () {
				alert("条件查询人员名单数据请求失败！");
			},
			success:function(data){
				var appInfoStr = '';   //表格  插入字符串
				var appTbl = $("#applicantTbl tbody");  //表格 tbody
				var result = data.rows;
				var total=data.total 
				appTbl.empty();
				
				if(total== 0){
					var warn_str="找不到符合查询条件的数据！";
	                var type_str="warning";
				    sweetWarn(warn_str,type_str);
				}else{
					$(result).each(function(key){
					appInfoStr=$('<tr>'+
                        '<td>'+result[key].id+'</td>'+
                        '<td>'+result[key].apName+'</td>'+
                        '<td>'+result[key].apAge+'</td>'+
                        '<td>'+result[key].apEdu+'</td>'+
                        '<td>'+result[key].apDuty+'</td>'+
                        '<td>'+result[key].apExperience+'</td>'+
                        '<td>'+result[key].apSkill+'</td>'+
                        '<td>'+                
                        '  <button class="btn btn-info edit_btn" type="button">'+
                        '      <i class="fa fa-arrow-up fa-fw"></i>录用'+
                        '  </button>'+
                        '  <button class="btn btn-danger del_btn" type="button">'+
                        '      <i class="fa fa-trash fa-fw"></i></i>删除'+
                        '  </button>'+
                        '</td>'+
                        '</tr>');									
						appTbl.append(appInfoStr);						
				});
				}
				
			}	
				
		});
	}
	
	
	//全部应聘人员名单
	function findAllApplicantInfos(){
      $.ajax({
		  url: "<%=request.getContextPath()%>/servlet/ApplicantInfoServlet",
			type: "post",
			cache: false,
			dataType: "json",
			data: {
				"reqCode": "findAllApplicantInfos", //请求码
			},
			error: function () {
				alert("全部应聘人员名单数据请求失败！");
			},
			success:function(data){
				var appInfoStr = '';   //表格  插入字符串
                var jobStr='';   //应聘职位下拉框  插入字符串
                var str1=$('<option value="">全部</option>');  //查询下拉框  全部选项
                var result = data.rows;
				var appTbl = $("#applicantTbl tbody");  //表格 tbody
				var jobSel=$("#demandJob"); //查询下拉列表
				var jobArr=[]; //应聘职位数组
				
				appTbl.empty();
				jobSel.empty();
				jobSel.append(str1);
				
				$(result).each(function(key){
					appInfoStr=$('<tr>'+
                        '<td>'+result[key].id+'</td>'+
                        '<td>'+result[key].apName+'</td>'+
                        '<td>'+result[key].apAge+'</td>'+
                        '<td>'+result[key].apEdu+'</td>'+
                        '<td>'+result[key].apDuty+'</td>'+
                        '<td>'+result[key].apExperience+'</td>'+
                        '<td>'+result[key].apSkill+'</td>'+
                        '<td>'+                
                        '  <button class="btn btn-info edit_btn" type="button">'+
                        '      <i class="fa fa-arrow-up fa-fw"></i>录用'+
                        '  </button>'+
                        '  <button class="btn btn-danger del_btn" type="button">'+
                        '      <i class="fa fa-trash fa-fw"></i></i>删除'+
                        '  </button>'+
                        '</td>'+
                        '</tr>');
						
						jobArr.push(result[key].apDuty);
						appTbl.append(appInfoStr);
				});
				
				jobArr=$.unique(jobArr);
				
				for(var i=0;i<jobArr.length;i++){
					jobStr=$('<option value="'+jobArr[i]+'">'+jobArr[i]+'</option>');
					jobSel.append(jobStr);
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
  