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
    <meta name="keywords" content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <title>薪资汇总</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>编辑操作</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row">
                <div class="col-md-4">
                    <label for="s-department">部门名称:</label>

                    <select name="department_name" id="s-department" class="form-control m-b" style="display:inline-block;width:100px">
                        <option value="0">全部</option>
                        <option value="1">技术中心</option>
                        <option value="2">财务部</option>
                        <option value="3">运营部</option>
                        <option value="4">市场部</option>
                        <option value="5">人事部</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="s-monnth">月份:</label>
                    <select name="department_name" id="s-monnth" class="form-control m-b" style="display:inline-block;width:100px">
                        <option value="0">1月</option>
                        <option value="1">2月</option>
                        <option value="2">3月</option>
                        <option value="3">4月</option>
                        <option value="4">5月</option>
                        <option value="5">6月</option>
                    </select>
                </div>
                <div class="col-md-1">
                    <button class="btn btn-info" type="button">查询</button>
                </div>

            </div>
        </div>

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
                    <div class="example">
                        <table id="exampleTableColumns" data-mobile-responsive="true">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>部门名称</th>
                                <th>部门总薪资</th>
                                <th>人均薪资</th>
                                <th>月份</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>技术中心</td>
                                <td>66666</td>
                                <td>1234</td>
                                <td>7</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>技术中心</td>
                                <td>66666</td>
                                <td>1234</td>
                                <td>7</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/content.min.js?v=1.0.0"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="js/demo/bootstrap-table-demo.min.js"></script>

</body>
</html>
