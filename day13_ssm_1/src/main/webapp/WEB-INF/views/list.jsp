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

    <link rel="stylesheet" href="${PATH}/statics/layui/css/layui.css" media="all">
    <script src="${PATH}/statics/layui/layui.js"></script>
    <script src="${PATH}/statics/js/jquery-3.3.1.min.js"></script>

    <script>
        layui.use(['table','element'], function () {
            var element = layui.element;
            var table = layui.table;

            //第一个实例
            table.render({
                elem: '#userListPage'

                , url: '${PATH}/user/listDatas' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'id', title: 'id',  sort: true, fixed: 'left'}
                    , {field: 'userName', title: 'userName'}
                    , {field: 'userPassword', title: 'userPassword'}
                    , {field: 'birthday', title: 'birthday', sort: true}
                    , {field: 'gender', title: 'gender',templet:function (data) {
                            return data.gender == "M" ? "男":"女";
                        }}
                    ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}

                ]]
            });

            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(userFilter)', function(obj){
                var data = obj.data;

                // console.log(data);
                // console.log(obj);
                // alert();
                var page = $(".layui-laypage-em").next().html();
                // alert($(".layui-input").val())

                if(obj.event === 'detail'){

                } else if(obj.event === 'del'){
                    //删除
                    // alert(data.id);

                    layer.confirm('真的删除【'+data.userName+'】的信息吗？', function(index) {
                        layer.close(index);//关闭询问框

                        $.ajax({
                            url: "${PATH}/user/delete/"+data.id,
                            type:"POST",
                            success:function (result) {
                                // alert(result);
                                if(result){
                                    layer.msg("删除成功",{time: 1000 },function () {
                                        // $(".layui-input").val(-1);
                                        // $(".layui-laypage-em").next("em").html(page-1);
                                        window.location.href = "${PATH}/user/listUI";
                                    });
                                }else{
                                    layer.msg("删除失败");
                                }
                            }
                        });



                    });


                } else if(obj.event === 'edit'){

                    // alert(data.id);
                    window.location.href="${PATH}/user/updateUI?id="+data.id;

                }
            });




        });

    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../models/head.jsp"/>

    <jsp:include page="../models/left.jsp"/>

    <div class="layui-body">
        <div style="padding: 15px;">
            <table id="userListPage" lay-filter="userFilter"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
