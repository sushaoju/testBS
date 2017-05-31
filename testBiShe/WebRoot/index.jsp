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
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>人力资源管理系统 - 主页</title>

    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <!--<link rel="shortcut icon" href="favicon.ico">-->
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
  </head>
  
 <body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span><img alt="image" class="img-circle" src="img/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Sugar</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem" href="form_avatar.jsp">修改头像</a></li>
                            <li><a class="J_menuItem" href="profile.jsp">个人资料</a></li>
                            <li class="divider"></li>
                            <li><a href="login_v2.jsp">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">S+D
                    </div>
                </li>

                <li>
                    <a href="404.jsp">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>

                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa-desktop"></i>
                        <span class="nav-label">人事管理</span>
                     <span class="fa arrow"></span> 
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="stuffBasic.jsp">员工基本信息</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="recruitInfo.jsp">招聘</a>
                        </li>
                        
                        <li>
                            <a class="J_menuItem" href="404.jsp">补贴</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="dimission.jsp">离职</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="retire.jsp">退休</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa-sitemap"></i>
                        <span class="nav-label">岗位管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="adjustJob.jsp">调岗</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="adjustMoney.jsp">调薪</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="department.jsp">部门组织</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a class="J_menuItem" href="stuff_train.jsp">
                        <i class="fa fa-book"></i>
                        <span class="nav-label">培训管理</span>
                    </a>
                </li>

                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa-binoculars"></i>
                        <span class="nav-label">考核管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="rewardPunish.jsp">奖惩</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="checkWork.jsp">考勤</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="department.jsp">请假、调休、加班</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa-credit-card"></i>
                        <span class="nav-label">薪资管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="stuff_salary.jsp">员工薪资</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="salary_sum.jsp">薪资汇总</a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="404.jsp">
                        <i class="fa fa-users"></i>
                        <span class="nav-label">系统管理</span>
                        <span class="fa arrow"></span>
                    </a>
                </li>

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->

    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
                        <i class="fa fa-bars"></i>
                    </a>
                    <form role="search" class="navbar-form-custom" method="post">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search"
                                   id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.jsp">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.jsp">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="notifications.jsp">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown hidden-xs">
                        <a class="right-sidebar-toggle" aria-expanded="false">
                            <i class="fa fa-tasks"></i> 任务
                        </a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="index.jsp">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>

            <a href="login_v2.jsp" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>

        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v1.jsp?v=4.0"
                    frameborder="0" data-id="index_v1.jsp" seamless></iframe>
        </div>

        <div class="footer">
            <div class="pull-right">&copy; S+D 人力资源管理系统</div>
        </div>
    </div>
    <!--右侧部分结束-->

    <!--右侧边栏开始-->
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">

                <li class="active">
                    <a data-toggle="tab" href="#tab-1">
                      已完成项
                    </a>
                </li>

                <li class="">
                    <a data-toggle="tab" href="#tab-2">
                    进行中项
                </a>
                </li>

                <li><a data-toggle="tab" href="#tab-3">
                    待完成项
                </a></li>
            </ul>

            <div class="tab-content">
                <div id="tab-1" class="tab-pane active">
                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 已完成项设置</h3>
                        <small><i class="fa fa-tim"></i>你可以选择编辑已完成项的显示</small>
                    </div>
                </div>

                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 进行中项设置</h3>
                        <small><i class="fa fa-tim"></i> 您当前有10条正在进行中的项目任务</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    人力资源总监要求整理的员工合同
                                    <br>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <small class="text-muted">今天 4:21</small>
                                </div>
                            </a>
                        </div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    招聘简历的筛选
                                    <br>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                    <small class="text-muted">昨天 2:45</small>
                                </div>
                            </a>
                        </div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    5.4号安排技术部门员工进行数据库培训
                                    <br>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                    <small class="text-muted">昨天 1:10</small>
                                </div>
                            </a>
                        </div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="pull-left text-center">
                                    <img alt="image" class="img-circle message-avatar" src="img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    将4月份的员工考核结果上报人力资源总监
                                    <br>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-danger"></div>
                                    </div>
                                    <small class="text-muted">昨天 8:37</small>
                                </div>
                            </a>
                        </div>

                    </div>

                </div>

                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-cube"></i> 最新任务</h3>
                        <small><i class="fa fa-tim"></i> 您当前有7个任务未完成，其中2个为紧急任务</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>培训调研</h4> 按要求接收教材；

                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2017.10.15</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small pull-right m-t-xs">9小时以后</div>
                                <h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                <div class="small">紧急任务</div>
                                <div class="small text-muted m-t-xs">项目截止： 4:00 - 2017.06.01</div>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>

        </div>
    </div>
    <!--右侧边栏结束-->

</div>

<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<script src="js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="js/contabs.min.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>
</body>
</html>
