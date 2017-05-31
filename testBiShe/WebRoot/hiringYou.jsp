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

    <title>填写录用信息</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="css_mine/personnelManagement.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInDown">
    <div id="staff_detail" class="ibox">
        <div class="ibox-content">
            <h1>
                填写员工录用信息
                <a class="pull-right" href="recruitInfo.jsp" style="font-size: 13px"> 返回招聘信息<<</a>
                <a class="pull-right" href="applicantInfo.jsp" style="font-size: 13px;margin-right: 10px" id="back">返回应聘人员名单<<</a>
            </h1>
            <h3>1、员工基本信息</h3>
            <div class="row">
                <div class="col-sm-4">
                    <label for="hire_stuffName">姓名:</label>
                    <input class="form-control" type="text" placeholder="请输入姓名" id="hire_stuffName" maxlength=64>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffBirth">出生日期：</label>
                    <input class="form-control" type="date" placeholder="请输入出生日期" id="hire_stuffBirth" maxlength=10>
                </div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">
                    <label for="hire_sex">性别：</label>
                    <select name="hire_sex" id="hire_sex" class="form-control">
                        <option value="M">男</option>
                        <option value="F">女</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffNation">民族：</label>
                    <input class="form-control" type="text" placeholder="请输入民族" id="hire_stuffNation" maxlength=15>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffAdd">地址：</label>
                    <input class="form-control" type="text" placeholder="请输入地址" id="hire_stuffAdd" maxlength=50>
                </div>
                <div class="clearfix hidden-xs"></div>
                <div class="col-sm-4">
                    <label for="hire_wedding">婚况:</label>
                    <select name="hire_wedding" id="hire_wedding" class="form-control">
                        <option value="0">未婚</option>
                        <option value="1">已婚</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffTel">电话:</label>
                    <input class="form-control" type="text" placeholder="请输入电话" id="hire_stuffTel"
					maxlength=11 onkeyup="this.value=this.value.replace(/\D/g,'')">
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffEmail">邮箱:</label>
                    <input class="form-control" type="email" placeholder="请输入邮箱" id="hire_stuffEmail" maxlength=64>
                </div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">
                    <label for="hire_stuffGrad">职称:</label>
                    <input class="form-control" type="text" placeholder="请输入职称" id="hire_stuffGrad" maxlength=50>
                </div>
                <div class="col-sm-8">
                    <label for="hire_stuffSkill">技能:</label>
                    <input class="form-control" type="text" placeholder="请输入技能" id="hire_stuffSkill" maxlength=100>
                </div>
                <div class="clearfix hidden-xs"></div>
            </div>

            <h3>2、员工教育背景信息</h3>
            <div class="row">
                <div class="col-sm-4">
                    <label for="hire_stuffColleage">毕业院校:</label>
                    <input class="form-control" type="text" placeholder="请输入毕业院校" id="hire_stuffColleage" maxlength=20>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffProfession">专业:</label>
                    <input class="form-control" type="text" placeholder="请输入专业" id="hire_stuffProfession" maxlength=20>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffEdu">学历:</label>
                    <select name="hire_stuffEdu" id="hire_stuffEdu" class="form-control">
                        <option value="研究生以上">研究生以上</option>
                        <option value="研究生">研究生</option>
                        <option value="本科">本科</option>
                        <option value="专科">专科</option>
                    </select>
                </div>
                <div class="clearfix hidden-xs"></div>
            </div>

            <h3>3、员工岗位信息</h3>
            <div class="row">
                <div class="col-sm-4">
                    <label for="hire_stuffEdu">所在部门:</label>
                    <select name="hire_stuffDepart" id="hire_stuffDepart" class="form-control">
                        
                    </select>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffDuty">职务:</label>
                    <input class="form-control" type="text" placeholder="请输入职务" id="hire_stuffDuty" maxlength=20>
                </div>
                <div class="col-sm-4">
                    <label for="hire_stuffStatus">任职状态：</label>
                    <select name="hire_stuffStatus" id="hire_stuffStatus" class="form-control">
                        <option value="试用期">试用期</option>
                        <option value="实习期">实习期</option>
                        <option value="正式员工">正式员工</option>
                    </select>
                </div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">
                    <label for="hire_stuffEntryDate">入职日期：</label>
                    <input class="form-control" type="date" placeholder="请输入入职日期" id="hire_stuffEntryDate">
                </div>
                <div class="col-sm-4">
                    <label for="hire_contractBegin">合同开始日期：</label>
                    <input class="form-control" type="date" placeholder="请输入合同开始日期" id="hire_contractBegin">
                </div>
                <div class="col-sm-4">
                    <label for="hire_contactEnd">合同结束日期：</label>
                    <input class="form-control" type="date" placeholder="请输入合同结束日期" id="hire_contactEnd">
                </div>
                <div class="clearfix hidden-xs"></div>

                <div class="col-sm-4">
                    <label for="hire_stuffMoney">薪酬：</label>
                    <input class="form-control" type="text" placeholder="请输入薪酬" id="hire_stuffMoney" 
					        maxlength=8   onkeyup="clearNoNum(this)" >
                </div>
                <div class="clearfix hidden-xs"></div>

                <br><br>
                <div class="col-sm-6 text-center">
                    <button id="hire_btn" class="btn btn-primary btn-lg" type="button">确定</button>
                </div>
                <div class="col-sm-6 text-center">
                    <button id="cancel_btn" class="btn btn-default btn-lg" type="button">取消</button>
                </div>
                <div class="clearfix hidden-xs"></div>
            </div>
        </div>
    </div>

</div>

<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<!--<script src="js/plugins/layer/layer.min.js"></script>-->
<script src="js/content.min.js?v=1.0.0"></script>
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<script>

	//薪酬校验
	function clearNoNum(obj){  
        //修复第一个字符是小数点 的情况.  
        if(obj.value !=''&& obj.value.substr(0,1) == '.'){  
            obj.value="";  
        }  
          
        obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
        obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的       
        obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");      
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数       
        if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额  
            if(obj.value.substr(0,1) == '0' && obj.value.length == 2){  
                obj.value= obj.value.substr(1,obj.value.length);      
            }  
        }      
    } 
	

$(function(){
	findDepartment(); //获得部门下拉列表
	findStuffId();  //获得员工工号
    var stuffIdArr = [];  //员工工号 数组
	
	var getApObject=JSON.parse(localStorage.getItem("apObject"));	
	$("#hire_stuffName").val(getApObject.apName);   //姓名
	$("#hire_stuffDuty").val(getApObject.apDuty);  //职位
	$("#hire_stuffSkill").val(getApObject.apSkill);   //技能
	var apId= getApObject.apId  //ID
	
	//学历
	if(getApObject.apEdu=="专科"){$("#hire_stuffEdu").val("3");}
	else if(getApObject.apEdu=="本科"){$("#hire_stuffEdu").val("2");}
	else if(getApObject.apEdu=="研究生"){$("#hire_stuffEdu").val("1");}
	else if(getApObject.apEdu=="研究生以上"){$("#hire_stuffEdu").val("0");}
	
	//录用取消按钮
	$("#cancel_btn").click(function(){
		window.location.href="applicantInfo.jsp"
	});
	
	//录用确定按钮 弹框
    $("#hire_btn").click(function () {
				
		var stuffName=$("#hire_stuffName").val();   //姓名
		var stuffBirth=$("#hire_stuffBirth").val();  //出生日期
		var stuffSex=$("#hire_sex").val();    //性别
		var stuffNation=$("#hire_stuffNation").val();  //民族
		var stuffAddress=$("#hire_stuffAdd").val();  //籍贯
		var stuffTel=$("#hire_stuffTel").val();   //联系方式
		var stuffEmail=$("#hire_stuffEmail").val();	//邮箱	
		var stuffEdu=$("#hire_stuffEdu").val();	//学历	
		var stuffColleage=$("#hire_stuffColleage").val();  //毕业院校	
		var stuffProfession=$("#hire_stuffProfession").val();  //专业
		var stuffGrade=$("#hire_stuffGrad").val();  //职称
		var stuffWedding=$("#hire_wedding").val();  //婚况
		var stuffSkill=$("#hire_stuffSkill").val();	  //技能

		var stuffDepartId=$("#hire_stuffDepart").val();	  //部门ID
		var stuffDepart=$("#hire_stuffDepart").find("option:selected").text();	  //部门名称
		var stuffDuty=$("#hire_stuffDuty").val();	  //职务
		var stuffStatus=$("#hire_stuffStatus").val();	  //任职状态
		var stuffEntryDate=$("#hire_stuffEntryDate").val();	  //入职日期
		var contractBegin=$("#hire_contractBegin").val();	  //劳动合同开始日期
		var contractEnd=$("#hire_contactEnd").val();	  //劳动合同结束日期
		var stuffMoney=$("#hire_stuffMoney").val();	  //薪酬
		var adjustJob="";	  //调岗日期
		var adjustMoney="";	  //调薪日期	
	    var stuffID=createStuffId(stuffDepartId);   //工号


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
		if($.trim(stuffSkill)==''){warn_str="请输入正确格式的技能";sweetWarn(warn_str,type_str);return false;}
		
		if($.trim(stuffColleage)==''){warn_str="请输入正确格式的毕业院校";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffProfession)==''){warn_str="请输入正确格式的专业";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffDuty)==''){warn_str="请输入正确格式的职务";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffEntryDate)==''){warn_str="请输入正确格式的入职日期";sweetWarn(warn_str,type_str);return false;}
		if($.trim(stuffMoney)==''){warn_str="请输入正确格式的薪酬";sweetWarn(warn_str,type_str);return false;}
		
		
		
		sweetdangerfn();
		
		//sweetalert 弹框（确定、取消）
		function sweetdangerfn (){
			 swal({
				title: "您确定要录用吗",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: "#A5DC86",
				confirmButtonText: "录用",
				cancelButtonText: "取消",
				closeOnConfirm: false
			}, function (isConfirm) {
				if (isConfirm) {
					addStuffInfo(stuffID,stuffName,stuffBirth,stuffSex,stuffNation,stuffAddress,
						 stuffTel,stuffEmail,stuffEdu,stuffColleage,stuffProfession,
						 stuffGrade,stuffWedding,stuffSkill);  //添加 员工基本信息表
			
			        addJobInfo(stuffID,stuffName,stuffDepart,stuffDuty,
					   stuffStatus,stuffEntryDate,contractBegin,contractEnd,stuffMoney,adjustMoney,adjustJob);  //添加 岗位信息表
					swal("录用成功！", "哈哈，又多了一个小伙伴。", "success");
					delApplicantInfo(apId);
					$("#hire_stuffName").val("");   //姓名
					$("#hire_stuffBirth").val("");  //出生日期
					$("#hire_stuffNation").val("");  //民族
					$("#hire_stuffAdd").val("");   //联系方式
					$("#hire_stuffEmail").val("");	//邮箱	
					$("#hire_stuffEdu").val("");	//学历	
					$("#hire_stuffColleage").val("");  //毕业院校	
					$("#hire_stuffProfession").val("");  //专业
					$("#hire_stuffGrad").val("");  //职称
					$("#hire_stuffSkill").val("");	  //技能
		
					$("#hire_stuffDuty").val("");	  //职务
					$("#hire_stuffEntryDate").val("");	  //入职日期
					$("#hire_contractBegin").val("");	  //劳动合同开始日期
					$("#hire_contactEnd").val("");	  //劳动合同结束日期
					$("#hire_stuffMoney").val("");	  //薪酬
				} else {
					swal("已取消", "您取消了录用操作！", "error")
				}
				
			});
		};
    });
	
	
	//单条  删除  应聘人员信息表
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
			
			}
		});
	}
	
	
	
	//添加到员工基本信息表
	function addStuffInfo(stuffID,stuffName,stuffBirth,stuffSex,stuffNation,stuffAddress,
					 stuffTel,stuffEmail,stuffEdu,stuffcolleage,stuffProfession,
					 stuffGrade,stuffWedding,stuffSkill){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/StuffInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data:{
				"reqCode": "addStuffInfo", //请求码
				"stuffID":stuffID,
				"stuffName":stuffName,
				"stuffBirth":stuffBirth,
				"stuffSex":stuffSex,
				"stuffNation":stuffNation,
				"stuffAddress":stuffAddress,
				"stuffTel":stuffTel,
				"stuffEmail":stuffEmail,
				"stuffEdu":stuffEdu,
				"stuffColleage":stuffcolleage,
				"stuffProfession":stuffProfession,
				"stuffGrade":stuffGrade,
				"stuffWedding":stuffWedding,
				"stuffSkill":stuffSkill
			},
			error: function () {
				alert("添加到员工基本信息请求失败！");
			},
			success:function(data){
			}
		});				 
	}
	
	//添加到岗位信息表
	function addJobInfo(stuffID,stuffName,stuffDepart,stuffDuty,stuffStatus,stuffEntryDate,
						contractBegin,contractEnd,stuffMoney,adjustMoney,adjustJob){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
			type: "post",
			cache: false,
			dataType: "text",
			data: {
				"reqCode": "addJobInfo", //请求码
				"stuffID":stuffID,
				"stuffName":stuffName,
				"stuffDepart":stuffDepart,
				"stuffDuty":stuffDuty,
				"stuffStatus":stuffStatus,
				"stuffEntryDate":stuffEntryDate,
				"stuffMoney":stuffMoney,
				"contractBegin":contractBegin,
				"contractEnd":contractEnd,
				"adjustMoney":adjustMoney,
				"adjustJob":adjustJob,
			},
			error: function () {
				alert("添加到岗位信息请求失败！");
			},
			success:function(data){
			}
		});
	}
	
	
	
    //sweetalert 弹框（一个确定按钮）
	function sweetWarn (str,type){
		swal({
			title:"提示",
			text:str,
			type:type
		})
	}
	
	
	//获得员工工号
	function findStuffId(){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/JobInfoServlet",
			type: "post",
			cache: false,
			dataType: "json",
			data: {
				"reqCode": "findAllJobInfos", //请求码
			},
			error: function () {
				alert("获取员工工号请求失败！");
			},
			success:function(data){
				var result = data.rows;
				var total = data.total;
				$(result).each(function (key) {
					stuffIdArr[key]=result[key].stuffID;
				});	
			}
		});
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
	
	
	//获得 部门下拉列表
	function  findDepartment(){
		$.ajax({
			url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
			type: "post",
			cache: false,
			dataType: "json",
			data: {
				"reqCode": "findAllDepartmentInfos", //请求码
			},
			error: function () {
				alert("获取部门信息请求失败！");
			},
			success:function(data){
				var depStr='';   //查询下拉框  插入字符串
				var depSel=$("#hire_stuffDepart"); //查询下拉列表
				var result = data.rows;
				depSel.empty();
				$(result).each(function (key) {
					depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');
					depSel.append(depStr);
				});
			}
		});
	}
	
	
	
});





    
</script>


</body>
</html>
    
 
