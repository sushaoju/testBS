/**
 * Created by Administrator on 2017/5/19.
 */


$(function () {

    findAllDepartmentInfo();   //获得 全部部门信息

    function findAllDepartmentInfo() {

        $.ajax({
            url: "<%=request.getContextPath()%>/servlet/DepartmentInfoServlet",
            type: "post",
            cache: false,
            dataType: "json",
            data: {
                "reqCode": "findAllDepartmentInfos", //账户编号
            },
            error: function () {
                alert("数据请求失败！");
            },
            success: function (data) {

                var depTbl = $("#exampleTableColumns tbody");
                //搜索下拉框

                //数据 存放表格
                var depInfoStr = '';
                var result = data.rows;
                depTbl.empty();
                $(result).each(function (key) {
                    depInfoStr = $('<tr>' +
                        '<td><input type="checkbox"></td>' +
                        '<td>' + result[key].departID + '</td>' +
                        '<td>' + result[key].departName + '</td>' +
                        '<td>' + result[key].departPrince + '</td>' +
                        '<td>' +
                        '<button class="btn btn-info edit_btn" type="button">' +
                        '<i class="fa fa-pencil fa-fw"></i>编辑' +
                        '</button>' +
                        '<button class="btn btn-danger " type="button">' +
                        '<i class="fa fa-trash-o fa-fw"></i>删除' +
                        '</button>' +
                        '</td>' +
                        +'</tr>');
                });

            }
        });
    }


})