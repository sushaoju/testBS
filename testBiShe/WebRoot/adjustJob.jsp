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
    <title>员工岗位信息</title>

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

                    <button class="btn btn-info" type="button" id="sel_btn"><i class="fa fa-search fa-fw"></i>查询</button>
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
                            <table id="adjustJob_tbl" data-mobile-responsive="true" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>工号</th>
                                    <th>姓名</th>

                                    <th>部门</th>
                                    <th>岗位</th>
                                    <th>任职状态</th>
									<th>薪资</th>
                                    <th>调岗日期</th>
                                    <th>调薪日期</th>

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


<!--编辑弹框 start-->
<div id="edit_box">
    <h2>编辑调岗信息</h2>
    <form>
        <div class="form-group">
            <div class="col-sm-6">
                <label for="e_stuffID">工号:</label>
                <span id="e_stuffID"></span>
            </div>
			
			<div class="col-sm-6">
                <label for="e_stuffName">姓 名 :</label>
				<span id="e_stuffName"></span>
            </div>           
        </div>
		<div class="clearfix hidden-xs"></div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_stuffDepart">所在部门:</label>
                <select name="e_stuffDepart" id="e_stuffDepart" class="form-control">
                </select>
            </div>
			<div class="col-sm-6">
                <label for="e_stuffDuty">岗 位 :</label>
                <input class="form-control" type="text" placeholder="请输入岗位" id="e_stuffDuty">
            </div>
        </div>
		<div class="clearfix hidden-xs"></div>

		
        <div class="from-group">           
            <div class="col-sm-6">
                <label for="e_adjustJob">调岗时间:</label>
                <input class="form-control" type="date" placeholder="请输入调岗时间" id="e_adjustJob">
            </div>
			<div class="col-sm-6">
                <label for="e_adjustMoney">调薪时间:</label>
                <input class="form-control" type="date" placeholder="请输入调薪时间" id="e_adjustMoney">
            </div>
        </div>
		<div class="clearfix hidden-xs"></div>
		
		<div class="from-group">
			<div class="col-sm-6">
                <label for="e_adjustMoney">薪资:</label>
                <input class="form-control" type="text" placeholder="请输入调薪时间" id="e_money">
            </div>
			 <div class="col-sm-6">
                    <label for="e_stuffStatus">任职状态：</label>
                    <select name="e_stuffStatus" id="e_stuffStatus" class="form-control">
                        <option value="试用期">试用期</option>
                        <option value="实习期">实习期</option>
                        <option value="正式员工">正式员工</option>
                    </select>
                </div>
        </div>
		<div class="clearfix hidden-xs"></div>
		
		
		<div class="from-group">           
            <div class="col-sm-6">
                <label for="e_contractBegin">劳动合同开始日期:</label>
                <input class="form-control" type="date" placeholder="请输入劳动合同开始日期" id="e_contractBegin">
            </div>
			<div class="col-sm-6">
                <label for="e_contractEnd">劳动合同开始日期:</label>
                <input class="form-control" type="date" placeholder="请输入劳动合同开始日期" id="e_contractEnd">
            </div>
        </div>
		<div class="clearfix hidden-xs"></div>
	    <span id="e_id"></span>
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

<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
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
	
	
    var stuffDepart_g = "";
	 var stuffIdArr = [];  //员工工号 数组
	//编辑按钮 弹框
	$("#adjustJob_tbl").on('click','.edit_btn',function(){
		var stuffID=$(this).parent("td").parent("tr").find("td").eq(0).text();   //员工工号
		var stuffName=$(this).parent("td").parent("tr").find("td").eq(1).text();   
		var stuffDepart=$(this).parent("td").parent("tr").find("td").eq(2).text(); 
        var stuffDuty=$(this).parent("td").parent("tr").find("td").eq(3).text(); 
		var stuffStatus=$(this).parent("td").parent("tr").find("td").eq(4).text(); 		
		var stuffMoney=$(this).parent("td").parent("tr").find("td").eq(5).text(); 
		var adjustJob=$(this).parent("td").parent("tr").find("td").eq(6).text(); 
		var adjustMoney=$(this).parent("td").parent("tr").find("td").eq(7).text(); 
		var id=$(this).parent("td").parent("tr").find("td").eq(8).text();
		
		$("#e_stuffID").text(stuffID);
		$("#e_stuffName").text(stuffName);
		$("#e_stuffDuty").val(stuffDuty);
		$("#e_money").val(stuffMoney);
		$("#e_adjustJob").val(adjustJob);
		$("#e_adjustMoney").val(adjustMoney);
		$("#e_adjustMoney").val(adjustMoney);
		$("#e_stuffStatus").val(stuffStatus);
		$('#e_id').text(id);
		
		stuffDepart_g=stuffDepart;
		
		alertEditBox();
		
		
	});
	
    function alertEditBox() {
        layer.open({
            type: 1,
            closeBtn: true,
            title: false,
            area: ['600px', '350px'],
            shadeClose: false, //点击遮罩不关闭
            content: $('#edit_box')
        });

        $("#edit_box").show();
    }
    $("#edit_closeBtn").click(function () {
        $(".layui-layer-close2").click();
    });	
	
	
	findAllDepartmentInfo();//获得 部门查询下拉列表
	findAllJobInfos();//获取所有 岗位信息表
	
	
	
	
	
	
	
	//查询按钮
	$("#sel_btn").click(function(){
		var stuffID = $("#s_stuffID").val();
		var stuffName = $("#s_stuffName").val();
		var stuffDepart = $("#s_stuffDepart").val();
		
		if(stuffID==""&&stuffName==""&&stuffDepart==""){
			findAllJobInfos();
		}else{
			findJobInfoByCondition(stuffID,stuffName,stuffDepart);
		}
	});
	
	
	
	
	//编辑弹框 提交按钮
	$("#editSubmit_btn").click(function(){
		var id=parseInt($("#e_id").text());
	
		
		var stuffName= $("#e_stuffName").text();
		var stuffDuty = $("#e_stuffDuty").val();
		var adjustJob = $("#e_adjustJob").val();
		var adjustMoney = $("#e_adjustMoney").val();
		var stuffMoney = $("#e_money").val();
		var stuffStatus = $("#e_stuffStatus").val();
		var stuffDepart = $("#e_stuffDepart").find("option:selected").text();
		var contractBegin= $("#e_contractBegin").val();
		var contractEnd= $("#e_contractEnd").val();
		var stuffIDD="";
		 stuffIDD=$("#e_stuffID").text();
		
		
		
		if(stuffDepart!=stuffDepart_g){
			var stuffDepart2=$("#e_stuffDepart").val();
			var stuffID2 = createStuffId(stuffDepart2);
			
			stuffIDD=stuffID2;
	   }
		
		var type_str="warning";
		if($.trim(stuffDuty)==''){warn_str="请输入正确格式的岗位";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffMoney)==''){warn_str="请输入正确格式的薪资";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffDepart)==''){warn_str="请输入部门";sweetWarn(warn_str,type_str);return false;}
		
		
		
		updateJobInfo(id,stuffIDD,stuffDepart,stuffDuty,stuffStatus,stuffMoney,adjustJob,adjustMoney,contractBegin,contractEnd);
		
	});
	
	
	//更新岗位信息表
	function updateJobInfo(id,stuffID,stuffDepart,stuffDuty,stuffStatus,stuffMoney,adjustJob,adjustMoney,contractBegin,contractEnd){
		$.ajax({
				url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
				type: "post",
				cache: false,
				dataType: "text",
				data: {
					"reqCode": "updateJobInfo", //请求码
					"id":id,
					"stuffID":stuffID,
					"stuffDepart":stuffDepart, 
					"stuffDuty":stuffDuty, 
					"stuffStatus":stuffStatus, 
					"stuffMoney":stuffMoney,
					"adjustJob":adjustJob,
					"adjustMoney":adjustMoney,
					"contractBegin":contractBegin,
					"contractEnd":contractEnd
				},
				error: function () {
					alert("更新岗位信息表请求失败！");
				},
				success:function(data){
					$("#edit_closeBtn").click();
					var warn_str="更新岗位信息表请求成功！";
	                var type_str="success";
				    sweetWarn(warn_str,type_str);
					findAllJobInfos();//获取所有 岗位信息表
				}
			})
	}
	
	
	
	//生成员工工号
	function createStuffId(idStr){
		var selStuffId_arr=[];  //符合要求的完整 stuffID
		var selIdNum_arr=[];  //符合要求的数字部分 stuffID
		var idStr_length=idStr.length;
		
		//查找固定字符开头的字符串 TODO...
		for(var i=0;i<stuffIdArr.length;i++){
			if(stuffIdArr[i].indexOf(idStr)==0){
               selStuffId_arr.push(stuffIdArr[i]);
			}
		}

		if(selStuffId_arr.length==0){
			return idStr+'001';
		}else{
				//切割 字母和数字 
			for(var i=0;i<selStuffId_arr.length;i++){
				var num=selStuffId_arr[i].substr(idStr_length);
				num=parseInt(num);
				selIdNum_arr.push(num);
			}		
			//找到最大数字后加1  
			selIdNum_arr.sort();
			var idNum_next=selIdNum_arr[selIdNum_arr.length-1]+1;	
			var stuffId_next='';		
			//判断数字长度  补全3位数  拼接数字和字母
			if((idNum_next-10) >= 0){
				stuffId_next=idStr+'0'+idNum_next;
			}else{
				stuffId_next=idStr+'00'+idNum_next;
			}
			
			return stuffId_next;
		}
	
	}
	
	
	//条件查询岗位信息表
	function findJobInfoByCondition(stuffID,stuffName,stuffDepart){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
				type: "post",
				cache: false,
				dataType: "json",
				data: {
					"reqCode": "findJobInfoByCondition", //请求码
					"stuffName":stuffName, //姓名
					"stuffID":stuffID, //工号
					"stuffDepart":stuffDepart  //部门
				},
				error: function () {
					alert("条件查询人员名单数据请求失败！");
				},
				success:function(data){
					var tbl=$("#adjustJob_tbl tbody");
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
										'<td>'+result[key].stuffStatus+'</td>'+
										'<td>'+result[key].stuffMoney+'</td>'+
										'<td>'+result[key].adjustJob+'</td>'+
										'<td>'+result[key].adjustMoney+'</td>'+
										'<td style="display:none">'+result[key].id+'</td>'+
										'<td>'+
										'    <button class="btn btn-info edit_btn" type="button">'+
										'        <i class="fa fa-pencil fa-fw"></i>编辑'+
										'    </button>'+
										'</td>'+
							'</tr>');									
							tbl.append(tbl_str);						
						});
					}
				}
		})
	}
	
	
	//获取所有 岗位信息表
	function findAllJobInfos(){
		$.ajax({
				 url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
				 type: "post",
				 cache: false,
				 dataType: "json",
				 data: {
				 	"reqCode": "findAllJobInfos", //请求码
				 },
				 error: function () {
				 	alert("获取所有 岗位信息请求失败！");
				 },
				 success:function(data){
					var tbl=$("#adjustJob_tbl tbody");
				    var tbl_str='';   //插入字符串
				    var result = data.rows;
				    tbl.empty();
					
					$(result).each(function (key) {		
						tbl_str=$('<tr>'+
                                    '<td>'+result[key].stuffID+'</td>'+
                                    '<td>'+result[key].stuffName+'</td>'+
                                    '<td>'+result[key].stuffDepart+'</td>'+
                                    '<td>'+result[key].stuffDuty+'</td>'+
                                    '<td>'+result[key].stuffStatus+'</td>'+
                                    '<td>'+result[key].stuffMoney+'</td>'+
                                    '<td>'+result[key].adjustJob+'</td>'+
									'<td>'+result[key].adjustMoney+'</td>'+
									'<td style="display:none">'+result[key].id+'</td>'+
                                    '<td>'+
                                    '    <button class="btn btn-info edit_btn" type="button">'+
                                    '        <i class="fa fa-pencil fa-fw"></i>编辑'+
                                    '    </button>'+
                                    '</td>'+
                                '</tr>');
						tbl.append(tbl_str);
						stuffIdArr[key]=result[key].stuffID;
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
					var depEdit= $("#e_stuffDepart");  //编辑弹框 部门下拉
					depSel.empty();
					depEdit.empty();
					depSel.append(str1);
					depEdit.append(str1);
					 
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						depSel.append(depStr);
					});
					$(result).each(function (key) {
						depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
						
						depEdit.append(depStr);
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
    
