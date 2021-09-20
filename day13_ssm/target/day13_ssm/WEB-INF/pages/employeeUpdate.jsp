<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/26
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
    <script src="${path}/layui/layui.js"></script>
    <script src="${path}/js/jQuery-3.1.1.js"></script>

    <script>
        //Demo
        layui.use(['form','element'], function () {
            var form = layui.form;
            var element = layui.element;

            //监听提交
            form.on('submit(formDemo)', function (data) {
                // layer.msg(JSON.stringify(data.field));

                $.post("${path}/emp/update",data.field,function (flag) {

                    if(flag){
                        layer.alert("修改成功");
                    }else{
                        layer.msg("修改失败");
                    }

                },"json");

                return false;
            });
        });
    </script>

</head>
<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../model/head.jsp"/>

    <jsp:include page="../model/left.jsp"/>

    <%--     id  last_name        age  idCard   gender  job        email              birthday      d_id   --%>
    <div class="layui-body">
        <div style="padding: 15px;">


            <form class="layui-form" action="">
                <%-- id --%>
                <input name="id" value="${employee.id}" type="hidden">

                <%--last_name--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">lastNmae</label>
                    <div class="layui-input-inline">
                        <input type="text" name="lastName" value="${employee.lastName}" disabled="disabled" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <%--age--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">age</label>
                    <div class="layui-input-inline">
                        <input type="text" name="age" value="${employee.age}" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <%--idCard--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">idcard</label>
                    <div class="layui-input-inline">
                        <input type="text" name="idcard" value="${employee.idcard}" disabled="disabled" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <%--gender--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">gender</label>
                    <div class="layui-input-block">
                        <c:choose>
                            <c:when test="${employee.gender == '男'}">
                                <input type="radio" name="gender" value="男" title="男" checked>
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="gender" value="男" title="男">
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.gender == '女'}">
                                <input type="radio" name="gender" value="女" title="女" checked>
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="gender" value="女" title="女">
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>

                <%--job--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">age</label>
                    <div class="layui-input-inline">
                        <input type="text" name="job" value="${employee.job}" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <%-- email --%>
                <div class="layui-form-item">
                    <label class="layui-form-label">email</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email" value="${employee.email}" required lay-verify="required"
                               placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <%-- <!-- birthday -->--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">birthday</label>
                    <div class="layui-input-inline">
                        <input type="text" id="birthday" value= "<fmt:formatDate value='${employee.birthday}'/>" required lay-verify="required" placeholder="请输入 birthday"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">不能为空</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">did</label>
                    <div class="layui-input-block">
                        <c:choose>
                            <c:when test="${employee.did == 1}">
                                <input type="radio" name="did" value="1" title="1" checked>
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="did" value="1" title="1">
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${employee.did == 2}">
                                <input type="radio" name="did" value="2" title="2" checked>
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="did" value="2" title="2">
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../model/foot.jsp"/>

</div>




</body>
</html>
