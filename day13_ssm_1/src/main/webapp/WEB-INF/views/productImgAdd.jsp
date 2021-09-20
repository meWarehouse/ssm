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
        layui.use(['element', 'form'], function () {
            var element = layui.element;
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function (data) {



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
            <form class="layui-form" action="${PATH}/product/addImg" method="post" enctype="multipart/form-data">
                <input type="hidden" value="${id}" name="id" >
                <div class="layui-form-item">
                    <label class="layui-form-label">封面图片</label>
                    <div class="layui-input-inline">
                        <input type="file" name="firstImg" required lay-verify="required"
                               placeholder="请上传封面图片" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">封面图片不能为空</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">详情图片</label>
                    <div class="layui-input-inline">
                        <input type="file" multiple="multiple" name="otherImg" required lay-verify="required"
                               placeholder="请上传详情图片" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">详情图片不能为空</div>
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
