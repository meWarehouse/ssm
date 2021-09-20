<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/25
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
    <script src="${path}/layui/layui.js"></script>
    <script src="${path}/js/jQuery-3.1.1.js"></script>

    <script>
        layui.use(['table','element'], function () {
            var element = layui.element;
            var table = layui.table;

            //第一个实例
            table.render({
                elem: '#employeeListPage'

                , url: '${path}/emp/employeeListPages' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'id', title: 'ID',  sort: true, fixed: 'left'}
                    , {field: 'lastName', title: 'lastName'}
                    , {field: 'gender', title: '性别'}
                    , {field: 'age', title: '年龄', sort: true}
                    , {field: 'email', title: '邮箱',edit: 'text'}
                    , {field: 'birthday', title: '生日',edit: 'text'}
                    , {field: 'did', title: '部门号', sort: true}
                    ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}

                ]]
            });

            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(test)', function(obj){
                var data = obj.data; //代表一行数据，一个 json 对象
                if(obj.event === 'detail'){
                    layer.msg('ID：'+ data.id + ' 的查看操作');
                } else if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        // obj.del(); //从表格中删除 二二不是从数据库删除
                        layer.close(index); //关闭询问框

                        // alert("id:---"+data.id);

                        $.get("${path}/emp/delete",{"id":data.id},function (flag) {
                            if(flag){
                                layer.msg("删除成功",function () {
                                    window.location.href = "${path}/emp/employeeListPagesUI";
                                });
                            }else{
                                layer.msg("删除失败");
                            }
                        },"json");


                    });
                } else if(obj.event === 'edit'){
                    window.location.href = "${path}/emp/updateUI?id="+data.id;
                }
            });




        });

    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../model/head.jsp"/>

    <jsp:include page="../model/left.jsp"/>

    <div class="layui-body">
        <div style="padding: 15px;">
            <table id="employeeListPage" lay-filter="test"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <jsp:include page="../model/foot.jsp"/>

</div>

</body>


</html>
