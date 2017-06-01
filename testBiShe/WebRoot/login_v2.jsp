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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>人力资源管理系统 - 登录</title>
    <meta name="keywords" content="人力资源管理系统 ,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统 是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    <link href="css/login.min.css" rel="stylesheet">
	 <!-- Sweet Alert -->
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ S+D ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>人力资源管理系统</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 90后有新想法</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 界面友好简洁</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 操作简单</li>
                    </ul>
                    <strong>还没有账号？ <a href="register.jsp">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post" name="loginForm">
                    <h4 class="no-margins">登录：</h4>
                    <input id="account" type="text" class="form-control uname" placeholder="用户名" name="account"/>
                    <input id="password" type="password" class="form-control pword m-b" placeholder="密码" name="password"/>               
                    <button id="login-btn" class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2017 All Rights Reserved. S+D
            </div>
        </div>
    </div>
    
    
    
    
    
  <script src="js/jquery.min.js?v=2.1.4"></script>
  <script src="js/plugins/sweetalert/sweetalert.min.js"></script>
 
    
    
</body>

</html>
    
    
