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
                elem: '#roleListPage'

                , url: '${PATH}/role/roleList' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'id', title: 'id',  sort: true, fixed: 'left'}
                    , {field: 'name', title: '角色名'}
                    ,{fixed: 'right', width:300, align:'center', toolbar: '#barDemo'}

                ]]
            });

            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(userFilter)', function(obj){
                var data = obj.data;
                if(obj.event === 'detail'){
                    window.location.href = "${PATH}/roleMenu/menuTreeUI/"+data.id;
                } else if(obj.event === 'del'){


                } else if(obj.event === 'edit'){
                    edit_one_item($("#edit_roleMsg "),data.id,data.name);

                }
            });

            function edit_one_item(ele, id, name) {
                $("#name").attr("placeholder",name);
                layer.open({
                    type: 1,
                    area: ['400px', '200px'],
                    title: '修改【' + name + '】信息',
                    content: $(ele),
                    shade: 0,
                    btn: ['提交', '重置']
                    , btn1: function (index, layero) {
                        var kk = $("#name").val().trim();
                        if (kk == name) {
                            layer.msg("你并没有修改任何信息");
                            return;
                        } else if (kk == null || kk == "") {
                            layer.msg("请输入你要修改的信息");
                        } else {
                            layer.confirm('真的修改【' + name + '】的信息吗？', function (index) {
                                layer.close(index);//关闭询问框

                                $.post("${PATH}/role/updateRole",{"id":id,"name":kk},function (result) {
                                    if(result){
                                        layer.msg("修改成功",{time:1000},function () {
                                            window.location.href = "${PATH}/role/forwardPages/listRole";
                                        })
                                    }else{
                                        layer.msg("修改失败");
                                    }
                                });

                            });
                        }

                    },
                    btn2: function (index, layero) {
                        $(ele)[0].reset();
                        return false;
                    },
                    cancel: function (layero, index) {
                        layer.closeAll();
                    }

                });
            }


        });

    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../models/head.jsp"/>

    <jsp:include page="../models/left.jsp"/>

    <form class="layui-form" id="edit_roleMsg" style="display:none">
        <div class="layui-form-item">
            <label class="layui-form-label">修改：</label>
            <div class="layui-input-block">
                <input type="text" name="title" required lay-verify="required" placeholder="" autocomplete="on"
                       class="layui-input" id="name" style="width:100px">
            </div>
        </div>
    </form>

    <div class="layui-body">
        <div style="padding: 15px;">
            <table id="roleListPage" lay-filter="userFilter"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">配置管理权限页面</a>
                <a class="layui-btn layui-btn-xs" id="editRole" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
