<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

            //后端
            $("#checkUserName").change(function () {


                if($("#checkUserName").val() == "${user.userName}"){
                    return;
                }

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
                            $("#update").addClass("layui-btn-disabled");
                        }
                    }
                });

            });

            //监听提交
            form.on('submit(formDemo)', function (data) {

                console.log(data.field);

                layer.msg(JSON.stringify(data.field));//data.field代表全部表单字段，名值对形式：{name: value}
                $.post("${PATH}/user/update", data.field, function(d) {
                    if (d == true) {
                        //弹出消息3秒以后，会执行回调函数
                        layer.msg("修改成功",{time:1000}, function() {
                            window.location.href = "${PATH}/user/listUI";
                        });
                    } else {
                        layer.msg("修改失败");
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


<%--                <div class="layui-form-item">--%>
<%--                    <label class="layui-form-label">id</label>--%>
<%--                    <div class="layui-input-inline">--%>
<%--                        <input type="text" name="userName" value="${user.id}" class="layui-input" >--%>
<%--                    </div>--%>
<%--                </div>--%>
                 <input type="hidden" name="id" value="${user.id}" />

                <div class="layui-form-item">
                    <label class="layui-form-label">userName</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userName" value="${user.userName}" required lay-verify="userName"
                               placeholder="请输入userName"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>



                <div class="layui-form-item">
                    <label class="layui-form-label">birthday</label>
                    <div class="layui-input-inline">
                        <input type="text" id="birthday" value="<f:formatDate value='${user.birthday}' pattern='yyyy-MM-dd'/>" name="birthday" required
                               lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">gender</label>
                    <div class="layui-input-inline">

                        <c:choose>
                            <c:when test="${user.gender == 'M'}">
                                <input type="radio" name="gender" value="M" title="男" checked="checked">
                                <input type="radio" name="gender" value="W" title="女" >
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="gender" value="M" title="男">
                                <input type="radio" name="gender" value="W" title="女" checked="checked">
                            </c:otherwise>
                        </c:choose>
<%--                        <c:choose>--%>
<%--                            <c:when test="${user.gender == 'W'}">--%>
<%--                                <input type="radio" name="gender" value="W" title="女" checked="checked">--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <input type="radio" name="gender" value="W" title="女" >--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>

                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" id="update" lay-submit lay-filter="formDemo">立即提交</button>
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
