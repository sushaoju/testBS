<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>注册</title>
    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
	 <!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">S+D</h1>

            </div>
            <h3>欢迎注册 人力资源管理</h3>
            <p>创建一个新账户</p>
            <div class="m-t">
                <div class="form-group">
                    <input   id="stuffID" type="text" class="form-control" placeholder="请输入员工号" required="">
                </div>
				
				<div class="form-group">
				    <span id="stuffName"></span>
                </div>
				
            
                <div class="form-group">
                    <input id="account"  type="text" class="form-control" placeholder="请输入用户名" required="">
                </div>
                <div class="form-group">
                    <input id="password"  type="password" class="form-control" placeholder="请输入密码" required="">
                </div>
                
                <button type="submit" class="btn btn-primary block full-width m-b"  id="register_btn">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login_v2.jsp">点此登录</a>
                </p>

            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
	<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
    <script>
        $(document).ready(function(){
        		$(".i-checks").iCheck({
        				checkboxClass:"icheckbox_square-green",
        				radioClass:"iradio_square-green"
        				})
        });
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    
    <script>
    	$(function(){
    	     $("#register_btn").click(function(){
    	          var  stuffID=$("#stuffID").val();
				  var  stuffName=$("#stuffName").text();
    	          var  account=$("#account").val();
    	          var  password=$("#password").val();
				  var myDate = new Date();
				  var year=myDate.getFullYear(); 
				  var month=parseInt(myDate.getMonth())+1;
				  var day=myDate.getDate(); 
				  
				   var resignDate = year+'-'+month+'-'+day;
    	        
				  
    	          var type_str="warning";
				  if($.trim(stuffID)==''){warn_str="请输入正确格式的员工工号";sweetWarn(warn_str,type_str);return false;}
				  if($.trim(account)==''){warn_str="请输入正确格式的账号";sweetWarn(warn_str,type_str);return false;}
				  if($.trim(password)==''){warn_str="请输入正确格式的密码";sweetWarn(warn_str,type_str);return false;}
				 	
				addAdminInfo(stuffID,stuffName,resignDate,account,password);					
    	     });
			 
			 
			 $("#stuffID").blur(function(){
				  var  stuffID=$("#stuffID").val();
				  
				  var type_str="warning";
				  if($.trim(stuffID)==''){warn_str="请输入正确格式的员工工号";sweetWarn(warn_str,type_str);return false;}
				  
				  if(stuffID.indexOf('HR')!=0){
                    warn_str="注册用户只能为人力资源部工作人员";
					sweetWarn(warn_str,type_str);
					return false;
			      }else{
					  findJobInfoById(stuffID) //根据id 查询员工岗位信息表
				  } 
			 });
			 
			 
			 //添加
			 function addAdminInfo(stuffID,stuffName,resignDate,account,password){
				 $.ajax({
					url: "<%=request.getContextPath()%>/servlet/AdminInfoServlet",
					type: "post",
					cache: false,
					dataType: "text",
					data: {
						"reqCode": "addAdminInfo", //请求码
						"stuffID":stuffID,
						"resignDate":resignDate,
						"stuffName":stuffName,
						"account":account,
						"password":password
					},
					error: function () {
						alert("注册失败！");
					},
					success:function(data){
						
						warn_str="注册成功";
						sweetWarn(warn_str,"success");
						window.location.href="index.jsp";
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
						warn_str="查询不到此员工";
						sweetWarn(warn_str,"warning");
						$("#a_stuffID").val("");
						return false;
					}else{
						var data=JSON.parse(data);
						$("#stuffName").text(data.stuffName);
					}	
				}
			})
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


