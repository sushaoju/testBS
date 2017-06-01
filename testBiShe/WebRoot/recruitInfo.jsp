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
    <title>招聘</title>

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
                    <input type="text" placeholder="请输入编号" id="recruitID" class="form-control">
                    <input type="text" placeholder="请输入需求岗位" id="demandJob" class="form-control">
                </div>

                <button class="btn btn-info" type="button"><i class="fa fa-search fa-fw"></i>查询</button>
                <button id="applicant_addBtn" class="btn btn-primary" type="button"><i class="fa fa-plus fa-fw"></i>增加
                </button>
                <button id="applicant_delBtn" class="btn btn-danger" type="button"><i class="fa fa-trash-o fa-fw"></i>删除
                </button>

                <button id="detail_btn" type="button" class="btn btn-outline btn-default pull-right">查看应聘人员名单</button>
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
                    <table data-mobile-responsive="true" class="table table-striped table-hover">
                        <thead>    
                        <tr>
                            <th>编号</th>
                            <th>需求岗位</th>

                            <th>需求人数</th>
                            <th>申请人</th>
                            <th>岗位现有人数</th>
                            <th>到岗日期</th>
                            <th>职责要求</th>
                            <th>发布状态</th>

                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td>2</td>
                            <td>web</td>
                            <td>22</td>

                            <td>sugar</td>
                            <td>5</td>
                            <td>2017.06.01</td>

                            <td>html\css\js</td>
                            <td>已发布</td>
                            <td>
                                <button class="btn btn-info edit_btn" type="button">
                                    <i class="fa fa-pencil fa-fw"></i>编辑
                                </button>
                                <button class="btn btn-danger del_btn" type="button">
                                    <i class="fa fa-trash fa-fw"></i></i>删除
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                
                </div>
            </div>
        </div>
    </div>
    <!--查询结果区 end-->
</div>


<!--编辑弹框 start-->
<div id="edit_box">
    <h2>编辑招聘信息</h2>
    <form>
        <div class="form-group">
            <div class="col-sm-6">
                <label for="e_stuffID">编号:</label>
                <span id="e_stuffID">s001</span>
            </div>
            <div class="clearfix hidden-xs"></div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_demandJob">需求岗位:</label>
                <input class="form-control" type="text" placeholder="请输入需求岗位" id="e_demandJob">
            </div>

            <div class="col-sm-6">
                <label for="e_demandNum">需求人数:</label>
                <input class="form-control" type="text" placeholder="请输入需求人数" id="e_demandNum">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_existNum">现有人数:</label>
                <input class="form-control" type="text" placeholder="10" id="e_existNum" readonly>
            </div>
            <div class="col-sm-6">
                <label for="e_arrivalDate">到岗日期:</label>
                <input class="form-control" type="text" placeholder="请输入到岗日期" id="e_arrivalDate">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_applycant">申 请 人 :</label>
                <input class="form-control" type="text" placeholder="请输入申请人" id="e_applycant">
            </div>

            <div class="col-sm-6">
                <label for="e_recruitStatus">发布状态:</label>
                <select name="e_wedding" id="e_recruitStatus" class="form-control">
                    <option value="0">未发布</option>
                    <option value="1">已发布</option>
                </select>
            </div>
        </div>


        <div class="from-group">
            <div class="col-sm-12">
                <label for="e_jobRequest" style="vertical-align: top">职责要求: </label>
                <textarea name="e_jobRequest" id="e_jobRequest" cols="30" rows="10" style="resize:none;"></textarea>
            </div>
        </div>


        <div class="from-group">
            <div class="col-sm-6 text-center">
                <button class="btn btn-primary btn-lg" type="button">修改</button>

            </div>
            <div class="col-sm-6 text-center">
                <button id="edit_closeBtn" class="btn btn-default btn-lg" type="button">取消</button>
            </div>
        </div>
    </form>
</div>
<!--编辑弹框 end-->


<!--增加弹框 start-->
<div id="add_box">
    <h2>增加招聘信息</h2>
    <form>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_demandJob">需求岗位:</label>
                <input class="form-control" type="text" placeholder="请输入需求岗位" id="a_demandJob">
            </div>

            <div class="col-sm-6">
                <label for="a_demandNum">需求人数:</label>
                <input class="form-control" type="text" placeholder="请输入需求人数" id="a_demandNum">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_existNum">现有人数:</label>
                <input class="form-control" type="text" placeholder="10" id="a_existNum">
            </div>
            <div class="col-sm-6">
                <label for="a_arrivalDate">到岗日期:</label>
                <input class="form-control" type="text" placeholder="请输入到岗日期" id="a_arrivalDate">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_applycant">申 请 人 :</label>
                <input class="form-control" type="text" placeholder="请输入申请人" id="a_applycant">
            </div>

            <div class="col-sm-6">
                <label for="a_recruitStatus">发布状态:</label>
                <select name="e_wedding" id="a_recruitStatus" class="form-control">
                    <option value="0">未发布</option>
                    <option value="1">已发布</option>
                </select>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-12">
                <label for="a_jobRequest" style="vertical-align: top">职责要求: </label>
                <textarea name="e_jobRequest" id="a_jobRequest" cols="30" rows="10" style="resize:none;"></textarea>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6 text-center">
                <button class="btn btn-primary btn-lg" type="button">增加</button>

            </div>
            <div class="col-sm-6 text-center">
                <button id="add_closeBtn" class="btn btn-default btn-lg" type="button">取消</button>
            </div>
        </div>
    </form>
</div>
<!--增加弹框 end-->


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

    //编辑按钮 弹框
    $(".edit_btn").click(alertEditBox);
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
    }
    $("#edit_closeBtn").click(function () {
        $(".layui-layer-close2").click();
    });


    //增加按钮 弹框
    $("#applicant_addBtn").click(alertAddBox);
    function alertAddBox() {
        layer.open({
            type: 1,
            closeBtn: true,
            title: false,
            area: ['600px', '400px'],
            shadeClose: false, //点击遮罩不关闭
            content: $('#add_box')
        });

        $("#add_box").show();
    }
    $("#add_closeBtn").click(function () {
        $(".layui-layer-close2").click();
    });


    //批量删除按钮 弹框
    $("#applicant_delBtn").click(function () {
        swal({
            title: "您确定要删除这条信息吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "是的，我要删除！",
            cancelButtonText: "让我再考虑一下…",
            closeOnConfirm: false,
            closeOnCancel: false
        }, function (isConfirm) {
            if (isConfirm) {
                swal("删除成功！", "您已经永久删除了这条信息。", "success")
            } else {
                swal("已取消", "您取消了删除操作！", "error")
            }
        })
    });
    //单条删除按钮 弹框
    $(".del_btn").click(function () {
        swal({
            title: "您确定要删除这条信息吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            closeOnConfirm: false
        }, function () {
            swal("删除成功！", "您已经永久删除了这条信息。", "success");
        });
    });


    // 查看应聘人员名单
    $("#detail_btn").click(function () {
        location.href = "applicantInfo.jsp";
    });

	
	
	$(function(){
		
	});

</script>
</body>
</html>
  
