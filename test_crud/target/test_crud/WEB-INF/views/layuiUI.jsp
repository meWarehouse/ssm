<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/2
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${PATH}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${PATH}/static/js/jquery-3.3.1.min.js"></script>

    <%--   --%>
    <script>
        layui.use(['table','element'], function () {
            var table = layui.table;
            var element = layui.element;

            //第一个实例
            table.render({
                elem: '#show-emps'
                , url: '${PATH}/layuiController/getPage' //数据接口
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'empId', title: 'empId', sort: true, fixed: 'left'}
                    , {field: 'empName', title: 'empName'}

                    , {
                        field: 'gender', title: 'deptName', templet: function (data) {
                            return data.gender == "M" ? "男" : "女";
                        }
                    }
                    , {field: 'email', title: 'email',}
                    , {
                        field: 'department', title: 'deptName', templet: function (data) {
                            return data.department.deptName;
                        }
                    }
                    ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}


                ]]
            });

            //监听工具条
            table.on('tool(events)', function(obj){
                var data = obj.data;
                if(obj.event === 'detail'){
                    layer.msg('ID：'+ data.id + ' 的查看操作');
                } else if(obj.event === 'del'){
                    // alert(data.empId);
                    // alert(data.empName);

                    layer.confirm('真的要删除'+data.empName+'的信息吗?', function(index){
                        layer.close(index);



                        //单个删除
                        <%--$.ajax({--%>
                        <%--    url:"${PATH}/layuiController/deleteById",--%>
                        <%--    data:""+data.empId,--%>

                        // });

                        $.post(
                            "${PATH}/layuiController/deleteById",
                            {"empId":data.empId},
                            function (result) {
                                console.log(result);
                                if(result){
                                    layer.msg("删除成功",{time:1000},function () {
                                        /* 删除成功刷新数据 */
                                        window.location.href = "${PATH}/layuiController/layuiUI";
                                    });

                                }else {
                                    layer.msg("删除失败");
                                }
                            }
                        );

                    });

                } else if(obj.event === 'edit'){
                    // layer.alert(JSON.stringify(data));

                    window.location.href="${PATH}/layuiController/editUI?empId="+data.empId;
                }
            });

        });
    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../viewModel/head.jsp"></jsp:include>
    <jsp:include page="../viewModel/left.jsp"></jsp:include>

    <div class="layui-body">
        <div style="padding: 15px;">
            <table id="show-emps" lay-filter="events"></table>
            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>

        </div>
    </div>

    <jsp:include page="../viewModel/foot.jsp"></jsp:include>

</div>

</body>

</html>
