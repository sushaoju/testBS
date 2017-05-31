        <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
            <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <base href="<%=basePath%>">

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords"
        content="人力资源管理系统,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
        <meta name="description"
        content="人力资源管理系统是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
        <title>部门管理</title>

        <!--[if lt IE 9]>
        <meta http-equiv="refresh" content="0;ie.html"/>
        <![endif]-->

        <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
        <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
        <!-- Sweet Alert -->
        <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
        <link href="css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
        <link rel="stylesheet" href="css_mine/personnelManagement.css">
            <style>
            .fixed-table-container{height: auto !important;}
            </style>
        </head>

        <body class="gray-bg">

        <div class="wrapper wrapper-content animated fadeInRight">

        <div class="ibox float-e-margins">
        <!-- 查询区  -->
        <div class="ibox-title">
        <h5>编辑操作</h5>
        <div class="ibox-tools">
        <a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a>
        </div>
        </div>
        <div class="ibox-content">
        <div class="row">

        <div class="col-md-3">
        <label for="department_name">部门名称:</label>

        <select name="department_name" id="department_name"
        class="form-control m-b" style="display:inline-block;width:150px">
        <option value="">全部</option>
        </select>
        </div>
        <div class="col-md-1">
        <button class="btn btn-info" type="button" id="sel_btn">查询</button>
        </div>

        <div class="col-md-1 pull-right" style="margin-right: 50px;">
        <button class="btn btn-danger " type="button">
        <i class="fa fa-trash-o fa-fw"></i>删除所选项
        </button>
        </div>
        <div class="col-md-1 pull-right" style="margin-right: 20px;">
        <button id="depart_addBtn" class="btn btn-info" type="button">
        <i class="fa fa-plus fa-fw"></i>增加部门
        </button>
        </div>
        </div>
        </div>

        <!-- 查询结果区  -->
        <div class="ibox-title">
        <h5>查询结果</h5>
        <div class="ibox-tools">
        <a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a>
        </div>
        </div>

        <div class="ibox-content">

        <div class="row row-lg">
        <div class="col-sm-12">
        <div class="example">
        <table id="example"  class="table table-striped table-hover" data-mobile-responsive="true">
        <thead>
        <tr>
        <th><input type="checkbox" id="s-selectAll"></th>

        <th>ID</th>
        <th>部门名称</th>
        <th>部门负责人</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
        </table>
        </div>
        </div>
        </div>
        </div>
        </div>

        </div>


        <!--编辑弹框 start-->
        <div id="edit_box">
        <h2>编辑部门信息</h2>
        <form>
        <div class="form-group">
        <div class="col-sm-6">
                <label for="e_departID">部门编号:</label> <input class="form-control"
                type="text" placeholder="请输入部门编号" id="e_departID" disabled="disabled">
        </div>
        <div class="clearfix hidden-xs"></div>
        </div>

        <div class="from-group">
        <div class="col-sm-6">
        <label for="e_departName">部门名称:</label> <input class="form-control"
        type="text" placeholder="请输入部门名称" id="e_departName">
        </div>

        <div class="col-sm-6">
        <label for="e_departPrince">部门负责人:</label> <input
        class="form-control" type="text" placeholder="请输入负责人"
        id="e_departPrince">
        </div>
        </div>

        <div class="from-group">
        <div class="col-sm-6 text-center">
        <button class="btn btn-primary btn-lg" type="button" id="upd_btn">修改</button>

        </div>

        <div class="col-sm-6 text-center">
        <button id="edit_closeBtn" class="btn btn-default btn-lg"
        type="button">取消</button>
        </div>
        </div>
        </form>
        </div>
        <!--编辑弹框 end-->


        <!--增加弹框 start-->
        <div id="add_box">
        <h2>增加部门信息</h2>
        <form>

        <div class="form-group">
        <div class="col-sm-6">
        <label for="a_departID">部门编号:</label> <input class="form-control"
        type="text" placeholder="请输入部门编号" id="a_departID">
        </div>
        <div class="clearfix hidden-xs"></div>
        </div>

        <div class="from-group">
        <div class="col-sm-6">
        <label for="a_departName">部门名称:</label> <input class="form-control"
        type="text" placeholder="请输入部门名称" id="a_departName">
        </div>

        <div class="col-sm-6">
        <label for="a_departPrince">部门负责人:</label> <input
        class="form-control" type="text" placeholder="请输入部门负责人"
        id="a_departPrince">
        </div>
        </div>

        <div class="from-group">
        <div class="col-sm-6 text-center">
        <button class="btn btn-primary btn-lg" type="button" id="add_submit">增加</button>
        </div>

        <div class="col-sm-6 text-center">
        <button id="add_closeBtn" class="btn btn-default btn-lg"
        type="button">取消</button>
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
			$("#example").on('click','.edit_btn',function(){
					var departID = $(this).parent("td").parent("tr").find("td").eq(1).text();
					var departName = $(this).parent("td").parent("tr").find("td").eq(2).text();
					var departPrince = $(this).parent("td").parent("tr").find("td").eq(3).text();

					$("#e_departID").val(departID);
					$("#e_departName").val(departName);
					$("#e_departPrince").val(departPrince);
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


			//增加按钮 弹框
			$("#depart_addBtn").click(alertAddBox);
			function alertAddBox() {
				layer.open({
					type: 1,
					closeBtn: true,
					title: false,
					area: ['550px', '300px'],
					shadeClose: false, //点击遮罩不关闭
					content: $('#add_box')
				});

				$("#add_box").show();
				$("#a_departID").val("");
				$("#a_departName").val("");
				$("#a_departPrince").val("");
			}
			$("#add_closeBtn").click(function () {
				$(".layui-layer-close2").click();
			});
         
		 
			//表格 全选、全不选
			var flagAll = true;   //全选
			$('#s-selectAll').click(function () {
				
			   if (flagAll) {
				  $(this).attr("checked","true");
				  $('#example tbody tr td:nth-child(1) input').attr("checked","true");
				  $('#example tbody tr').css('backgroundColor', '#f3f5f8');
			   } else {
				  $(this).removeAttr("checked");
				  $('#example tbody tr td:nth-child(1) input').removeAttr("checked");
				  $('#example tbody tr').css('backgroundColor', '#fff');
			   }
			   flagAll = !flagAll;
			});
			
			//表格 单选
			$('#example').on('click', '.s-option', function () {

				 $('#s-selectAll').removeAttr("checked"); //置为全不选
				 flagAll = true; //全选标志

				 if ($(this).attr("checked")==true) {
					$(this).removeAttr("checked");
					$(this).parent().parent().css('backgroundColor', '#fff');
				 }
				 else {
				   $(this).attr("checked","true");
				   $(this).parent().parent().css('backgroundColor', '#f3f5f8');
				}
			});


	   </script>

         <script>

            $(function () {

				findAllDepartmentInfo();   //获得 全部部门信息

				//弹框增加 按钮
				$("#add_submit").click(function(){
                        var departID = $("#a_departID").val();
                        var departName = $("#a_departName").val();
                        var departPrince = $("#a_departPrince").val();
                        addDepartmentInfo(departID,departName,departPrince);
                });

				//查询 按钮
				$("#sel_btn").click(function(){
                    var departID=$("#department_name").val();

                    var reqCodeValue="";
                    if(departID==""||departID==null){
                        findAllDepartmentInfo();
                    }else{
                        reqCodeValue="findDepartmentInfoById";
                        findDepartmentInfoById(departID,reqCodeValue);
                    }
				});

				//单条删除 按钮
				$("#example").on('click','.del_btn',function(){
					var departID = $(this).parent("td").parent("tr").find("td").eq(1).text();         
					delDepartmentInfo(departID);
				});

				//编辑  按钮
				$("#upd_btn").click(function(){
					var departID = $("#e_departID").val();
					var departName = $("#e_departName").val();
					var departPrince = $("#e_departPrince").val();

					updateDepartmentInfo(departID,departName,departPrince);
                });

                //编辑e
                function updateDepartmentInfo(DepartID,DepartName,DepartPrince){
					$.ajax({
							url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
							type: "post",
							cache: false,
							dataType: "json",
							data: {
						   "reqCode": "updateDepartmentInfo", //请求码
							"departID":DepartID,   //部门ID
							"departName":DepartName, //部门名称
							"departPrince":DepartPrince //部门 负责人
							},
							success: function (data) {
								$("#e_departID").val();
								$("#e_departName").val();
								$("#e_departPrince").val();
								findAllDepartmentInfo();
								$("#edit_closeBtn").click();
								swal({title:"编辑操作",text:"编辑部门信息成功",type:"success"});
							},
							error: function (e) {
								$("#e_departID").val();
								$("#e_departName").val();
								$("#e_departPrince").val();
								findAllDepartmentInfo();
								$("#edit_closeBtn").click();
								swal({title:"编辑操作",text:"编辑部门信息成功",type:"success"});
							}
					});
                }

                //单条删除e
				function delDepartmentInfo(departID){
					$.ajax({
							url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
							type: "post",
							cache: false,
							dataType: "json",
							data: {
							"reqCode": "delDepartmentInfo", //请求码
							"departID":departID   //部门编号
							},			
							success:function(data){
								sweetwarnfn(findAllDepartmentInfo());
							},
							error:function(){
								sweetwarnfn(findAllDepartmentInfo());
							}
					});
                }

				//增加e
				function addDepartmentInfo(DepartID,DepartName,DepartPrince){
					$.ajax({
							url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
							type: "post",
							cache: false,
							dataType: "json",
							data: {
							"reqCode": "addDepartmentInfo", //请求码
							"departID":DepartID, //部门编号
							"departName":DepartName,  //部门名称
							"departPrince":DepartPrince  //部门负责人
							},
							error: function (data) {
								$("#a_departID").val("");
								$("#a_departName").val("");
								$("#a_departPrince").val("");
								findAllDepartmentInfo();
								$("#add_closeBtn").click();
								swal({title:"新增操作",text:"新增部门成功",type:"success"});
							},
							success:function(e){
								$("#a_departID").val("");
								$("#a_departName").val("");
								$("#a_departPrince").val("");
								findAllDepartmentInfo();
								$("#add_closeBtn").click();
								swal({title:"新增操作",text:"新增部门成功",type:"success"});
							}
					});

				}

				//根据部门查询
				function findDepartmentInfoById(departID,reqCodeValue){
					$.ajax({
						url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
						type: "post",
						cache: false,
						dataType: "json",
						data: {
							"reqCode": reqCodeValue, //请求码
							"departID":departID   //部门编号
						},
						error: function () {
							alert("部门查询数据请求失败！");
						},
						success: function (data) {
							var depInfoStr = '';   //表格  插入字符串
							var depTbl = $("#example tbody");  //表格 tbody
							depTbl.empty();

							depInfoStr = $('<tr>' +
							'<td><input type="checkbox"></td>' +
							'<td>' + data.departID + '</td>' +
							'<td>' + data.departName + '</td>' +
							'<td>' + data.departPrince + '</td>' +
							'<td>' +
							'<button class="btn btn-info edit_btn" type="button">' +
							'<i class="fa fa-pencil fa-fw"></i>编辑' +
							'</button>' +
							'<button class="btn btn-danger del_btn" type="button">' +
							'<i class="fa fa-trash-o fa-fw"></i>删除' +
							'</button>' +
							'</td>' +
							+'</tr>');

							depTbl.append(depInfoStr);
						}
					});
				}

				//获得 全部部门信息
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
							var depInfoStr = '';   //表格  插入字符串
							var depStr='';   //查询下拉框  插入字符串
							var  str1=$('<option value="">全部</option>');  //查询下拉框  全部选项
							var result = data.rows;
							var depTbl = $("#example tbody");  //表格 tbody
							var depSel=$("#department_name"); //查询下拉列表
							depTbl.empty();
							depSel.empty();
							depSel.append(str1);
							 
							$(result).each(function (key) {
								depInfoStr = $('<tr>' +
								'<td><input type="checkbox" class="s-option"></td>' +
								'<td>' + result[key].departID + '</td>' +
								'<td>' + result[key].departName + '</td>' +
								'<td>' + result[key].departPrince + '</td>' +
								'<td>' +
								'<button class="btn btn-info edit_btn" type="button">' +
								'<i class="fa fa-pencil fa-fw"></i>编辑' +
								'</button>' +
								'<button class="btn btn-danger del_btn" type="button">' +
								'<i class="fa fa-trash-o fa-fw"></i>删除' +
								'</button>' +
								'</td>' +
								+'</tr>');

								depStr=$('<option value="'+result[key].departID+'">'+result[key].departName+'</option>');

								depTbl.append(depInfoStr);
								depSel.append(depStr);
							});
						}
					});
				}


				//sweetalert 弹框
				function sweetdangerfn (func){
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
								func;
								swal("删除成功！", "您已经永久删除了这条信息。", "success")
							} else {
								swal("已取消", "您取消了删除操作！", "error")
							}
					});
				}
			
				function sweetwarnfn(func){
					swal({
						title: "您确定要删除这条信息吗",
						text: "删除后将无法恢复，请谨慎操作！",
						type: "warning",
						showCancelButton: true,
						confirmButtonColor: "#DD6B55",
						confirmButtonText: "删除",
						closeOnConfirm: false
					}, function () {
						func;
						swal("删除成功！", "您已经永久删除了这条信息。", "success");
					});
				}
			
		})
            </script>
        </body>


        </html>
