<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/27
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
    <script src="${path}/layui/layui.js"></script>
    <script src="${path}/js/jQuery-3.1.1.js"></script>

    <script>




        //JavaScript代码区域
        layui.use(['element', 'form', 'laydate'], function () {

            var element = layui.element;
            var form = layui.form;
            var laydate = layui.laydate;



            laydate.render({
                elem: '#birthday' //指定元素
            });

            form.verify({
                /*这里需要同步请求  */

                oldIdcard: function (value, item) { /*//value：表单的值、item：表单的DOM对象*/

                    $.ajax({
                        url: "${path}/idcard/oldIdcard",
                        data: {"oldIdcard": value},
                        success: function (data) {
                            layer.alert(value);
                            layer.alert(data);
                        },
                        async: false,
                        type: "post",
                        dataType: "json"

                    });

                },
                oldIdcard: function (value, item) { /*//value：表单的值、item：表单的DOM对象*/

                },
                oldIdcard: function (value, item) { /*//value：表单的值、item：表单的DOM对象*/

                },
            });



            //监听提交  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            //一旦提交表单，就会调用回调函数
            form.on('submit(verification)', function (data) {
                // layer.msg(JSON.stringify(data.field));//JSON.stringify() 格式化表单数据  data.field 表单数据  当前容器的全部表单字段，名值对形式：{name: value}

                $.post("${path}/emp/add", data.field, function (d) {
                    if (d == true) {
                        layer.msg("添加成功", function () {
                            window.location.href = "${path}/emp/employeeListPagesUI";
                        });
                    } else {
                        layer.msg("添加失败");
                    }
                }, "json");

                return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可
            });

        });

    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../model/head.jsp"/>

    <jsp:include page="../model/left.jsp"/>

    <div class="layui-body">

        <%-- lastName --%>
        <div class="layui-form-item">
            <label class="layui-form-label">请输入原 idcard </label>
            <div class="layui-input-inline">
                <input type="text" name="oldIdcard" required lay-verify="oldIdcard" placeholder="请输入原 idcard"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">不能为空</div>
        </div>
        <%-- lastName --%>
        <div class="layui-form-item">
            <label class="layui-form-label">请输入新 idcard </label>
            <div class="layui-input-inline">
                <input type="text" name="newIdcard" required lay-verify="newIdcard" placeholder="请输入新 idcard"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">不能为空</div>
        </div>
        <%-- lastName --%>
        <div class="layui-form-item">
            <label class="layui-form-label">请确认 idcard </label>
            <div class="layui-input-inline">
                <input type="text" name="reIdcard" required lay-verify="reIdcard" placeholder="请确认 idcard"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">不能为空</div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="verification">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>

    <jsp:include page="../model/foot.jsp"/>

</div>

</body>

</html>
