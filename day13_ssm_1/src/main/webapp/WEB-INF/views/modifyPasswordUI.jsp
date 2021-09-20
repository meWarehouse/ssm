<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${PATH}/statics/layui/css/layui.css" media="all">
    <script src="${PATH}/statics/layui/layui.js"></script>
    <script src="${PATH}/statics/js/jquery-3.3.1.min.js"></script>

    <script>
        layui.use('form', function () {

            var form = layui.form;
     ;
            $("#password").change(function () {

                $("#submits").attr("status","");
                $("#password").parent("div").next("span").text("");

                <%--var  passwd = $("#password").val().trim();--%>

                <%--var p = ${sessionScope.u.userPassword};--%>

                if($("#password").val().trim() != "${sessionScope.u.userPassword}"){
                    // layui-btn-disabled
                    //禁用提交按钮
                    $("#submits").attr("status","error");

                    //给出提示
                    $("#password").parent("div").next("span").text("密码与原密码不一致");
                }

            });

            form.verify({
                repassword: function(value, item){ //value：表单的值、item：表单的DOM对象

                    $("#submits").attr("status","");

                    //判断两次密码是否一致
                    if($("#newpassword").val().trim() != value){
                        //禁用提交按钮
                        $("#submits").attr("status","error");
                        //给出提示
                        return "两次密码不一致";
                    }
                }

            });



            //监听提交
            form.on('submit(formDemo)', function (data) {

                if($(this).attr("status") == "error"){
                    return false;
                }

                // layer.confirm('是否确认修改密码', function(index){
                //     //do something
                //     layer.close(index);

                    $.ajax({
                        url:"${PATH}/login/modifyPassword?oldPassword="+$("#password").val()+"&newPassword="+$("#repassword").val(),
                        type:"POST",
                        success:function (result) {
                            if(result){
                                alert("密码修改成功");
                                window.location.href="${PATH}/login/loginUI";
                            }else{
                                alert("密码修改失败");
                            }
                        }
                    });

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
                    <label class="layui-form-label">请输入原密码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="password" id="password" required lay-verify="required"
                               placeholder="请输入原密码"
                               autocomplete="off" class="layui-input">
                    </div>
                    <span class="layui-form-mid layui-word-aux"></span>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">请输入新密码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="newpassword" id="newpassword" required lay-verify="required"
                               placeholder="请输入新密码" autocomplete="off" class="layui-input">
                    </div>

                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="repassword" id="repassword" required lay-verify="repassword"
                               placeholder="确认密码"
                               autocomplete="off" class="layui-input">
                    </div>

                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" id="submits"  lay-submit lay-filter="formDemo">立即提交</button>
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
