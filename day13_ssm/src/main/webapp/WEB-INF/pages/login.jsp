<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/27
  Time: 21:52
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
        //Demo
        layui.use(['element','form'], function () {
            var element = layui.element;
            var form = layui.form;

            //监听提交  <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            //一旦提交表单，就会调用回调函数
            form.on('submit(login)', function (data) {
                // layer.msg(JSON.stringify(data.field));//JSON.stringify() 格式化表单数据  data.field 表单数据  当前容器的全部表单字段，名值对形式：{name: value}

                $.post("${path}/login/loginmsg", data.field, function (d) {
                    if (d == true) {
                        layer.alert("登入成功", function (index) {

                            layer.close(index);
                            window.location.href = "${path}/";
                        });
                    } else {
                        layer.msg("登入失败");
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
        <form class="layui-form">

            <%-- lastName --%>
            <div class="layui-form-item">
                <label class="layui-form-label">lastNmae</label>
                <div class="layui-input-inline">
                    <input type="text" name="lastname" required lay-verify="required" placeholder="请输入lastName"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">不能为空</div>
            </div>

            <%-- <!-- idcard -->--%>
            <div class="layui-form-item">
                <label class="layui-form-label">idcard</label>
                <div class="layui-input-inline">
                    <input type="text" name="idcard" required lay-verify="required" placeholder="请输入 idcard" autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">不能为空</div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="login">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>
    </div>

    <jsp:include page="../model/foot.jsp"/>

</div>

</body>


</html>
