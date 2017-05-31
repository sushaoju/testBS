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
    <title>退休</title>

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
                        <option value="0">技术部</option>
                        <option value="1">财务部</option>
                    </select>

                    <label for="">入职日期：</label>
                    <input type="date" class="form-control" placeholder="开始日期"> ——
                    <input type="date" class="form-control" placeholder="结束日期">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="">退休日期：</label>
                    <input type="date" class="form-control" placeholder="开始日期"> ——
                    <input type="date" class="form-control" placeholder="结束日期" style="margin-right: 15px">

                    <button class="btn btn-info" type="button"><i class="fa fa-search fa-fw"></i>查询</button>
                    <button id="applicant_addBtn" class="btn btn-primary" type="button"><i class="fa fa-plus fa-fw"></i>增加
                    </button>
                    <button id="applicant_delBtn" class="btn btn-danger" type="button"><i class="fa fa-trash-o fa-fw"></i>删除
                    </button>
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
                    <div class="example-wrap">
                        <div class="example">
                            <table id="exampleTableColumns" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="state" data-checkbox="true"></th>
                                    <th data-field="name" data-switchable="false">工号</th>
                                    <th data-field="price" data-switchable="false">姓名</th>

                                    <th data-field="column3" data-visible="true">部门</th>
                                    <th data-field="column4" data-visible="false">岗位</th>
                                    <th data-field="column5" data-visible="false">交接人</th>
                                    <th data-field="column6" data-visible="true">入职时间</th>
                                    <th data-field="column7" data-visible="false">退休时间</th>
                                    <th data-field="column8" data-visible="true">退休金</th>

                                    <th data-field="column9" data-switchable="false">操作</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td></td>
                                    <td>2</td>
                                    <td>sugar</td>
                                    <td>技术部</td>

                                    <td>web</td>
                                    <td>candy</td>
                                    <td>2017.06.01</td>

                                    <td>2017.08.01</td>
                                    <td>4000</td>
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
        </div>
    </div>
    <!--查询结果区 end-->
</div>


<!--编辑弹框 start-->
<div id="edit_box">
    <h2>编辑退休信息</h2>
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
                <label for="e_stuffName">姓 名 :</label>
                <input class="form-control" type="text" placeholder="请输入姓名" id="e_stuffName">
            </div>

            <div class="col-sm-6">
                <label for="e_stuffDepart">所在部门:</label>
                <select name="e_stuffDepart" id="e_stuffDepart" class="form-control">
                    <option value="0">技术部</option>
                    <option value="1">财务部</option>
                </select>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_stuffDuty">岗 位 :</label>
                <input class="form-control" type="text" placeholder="请输入岗位" id="e_stuffDuty">
            </div>
            <div class="col-sm-6">
                <label for="e_retireDate">退休时间:</label>
                <input class="form-control" type="text" placeholder="请输入退休时间" id="e_retireDate">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="e_retireInterface">交接人:</label>
                <input class="form-control" type="text" placeholder="请输入交接人" id="e_retireInterface">
            </div>
            <div class="col-sm-6">
                <label for="e_retireMoney">退 休 金: </label>
                <input class="form-control" type="text" placeholder="请输入交接人" id="e_retireMoney">
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
    <h2>增加退休信息</h2>
    <form>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_stuffName">姓 名 :</label>
                <input class="form-control" type="text" placeholder="请输入姓名" id="a_stuffName">
            </div>

            <div class="col-sm-6">
                <label for="a_stuffDepart">所在部门:</label>
                <select name="a_stuffDepart" id="a_stuffDepart" class="form-control">
                    <option value="0">技术部</option>
                    <option value="1">财务部</option>
                </select>
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_stuffDuty">岗 位 :</label>
                <input class="form-control" type="text" placeholder="请输入岗位" id="a_stuffDuty">
            </div>
            <div class="col-sm-6">
                <label for="a_retireDate">退休时间:</label>
                <input class="form-control" type="date" placeholder="请输入退休时间" id="a_retireDate">
            </div>
        </div>

        <div class="from-group">
            <div class="col-sm-6">
                <label for="a_retireInterface">交接人:</label>
                <input class="form-control" type="text" placeholder="请输入交接人" id="a_retireInterface">
            </div>
            <div class="col-sm-6">
                <label for="a_retireMoney">退 休 金 :</label>
                <input class="form-control" type="text" placeholder="请输入退休金" id="a_retireMoney">
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

</script>
</body>
</html>

  
