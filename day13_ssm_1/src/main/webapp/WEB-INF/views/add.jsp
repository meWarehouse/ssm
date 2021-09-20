<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 14:19
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
        layui.use(['table', 'element', 'form', 'laydate'], function () {
            var element = layui.element;
            var table = layui.table;
            var form = layui.form;
            var laydate = layui.laydate;

            //渲染一个日期选择框
            laydate.render({
                elem: '#birthday' //指定元素
            });

            //校验数据
            form.verify({
                userName: function (value, item) { //value：表单的值、item：表单的DOM对象

                    var regName = /(^[a-zA-Z0-9_-]{4,16}$)|([\u2E80-\u9FFF]{2,5})/;

                    if (!regName.test(value)) {
                        return '用户名必须是4-16为数字或字母或2-5为汉字';
                    }
                }

            });

            //后端
            $("#checkUserName").change(function () {
                $.ajax({
                    url: "${PATH}/user/check",
                    data: "userName=" + $("#checkUserName").val(),
                    type: "POST",
                    success: function (result) {
                        if (result) {
                            alert("用户名可用");
                        } else {
                            alert("用户名不可用");
                            //禁用提交按钮
                            $("#submit").addClass("layui-btn-disabled");
                        }
                    }
                });

            });

            //监听提交
            form.on('submit(formDemo)', function (data) {

                //layer.msg(JSON.stringify(data.field));//data.field代表全部表单字段，名值对形式：{name: value}
                $.post("${PATH}/user/addUser", data.field, function(d) {
                    if (d == true) {
                        //弹出消息3秒以后，会执行回调函数
                        layer.msg("添加成功",{time:1000}, function() {
                            window.location.href = "${PATH}/user/listUI";
                        });
                    } else {
                        layer.msg("添加失败");
                    }
                }, "json");
                return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。

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
            <form class="layui-form" action="">

                <div class="layui-form-item">
                    <label class="layui-form-label">userName</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userName" id="checkUserName" required lay-verify="userName"
                               placeholder="请输入userName"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">userPassword</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userPassword" required lay-verify="required"
                               placeholder="请输入userPassword" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">辅助文字</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">birthday</label>
                    <div class="layui-input-inline">
                        <input type="text" id="birthday" name="birthday" required
                               lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">辅助文字</div>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">gender</label>
                    <div class="layui-input-inline">
                        <input type="radio" name="gender" value="M" title="男">
                        <input type="radio" name="gender" value="W" title="女" checked>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" id="submit" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>

</html>
