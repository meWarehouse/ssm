<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/2
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑</title>

    <link rel="stylesheet" href="${PATH}/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${PATH}/static/layui/layui.js"></script>
    <script type="text/javascript" src="${PATH}/static/js/jquery-3.3.1.min.js"></script>

    <script>
        layui.use(['table', 'element', 'form'], function () {
            var table = layui.table;
            var element = layui.element;
            var form = layui.form;

            // //监听提交
            // form.on('submit(updateForm)', function(data){
            //     layer.msg(JSON.stringify(data.field));//{"empId":"25","empName":"b45b323","gender":"W","email":"b45b323@attest.com","department":"2"}
            //     return false;
            // });

        });

    </script>

    <%--    <script>--%>
    <%--        $("#select").mouseenter(function () {--%>
    <%--            alert("鼠标")--%>
    <%--            getDept();--%>
    <%--        });--%>
    <%--        function getDept() {--%>
    <%--            $.ajax({--%>
    <%--                url:"${PATH}/dept/getdept",--%>
    <%--                type:"POST",--%>
    <%--                success:function (result) {--%>
    <%--                    alert(result);--%>
    <%--                }--%>
    <%--            })--%>
    <%--        }--%>
    <%--    </script>--%>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" >

    <jsp:include page="../viewModel/head.jsp"></jsp:include>
    <jsp:include page="../viewModel/left.jsp"></jsp:include>

    <div class="layui-body">
        <form class="layui-form" action="" lay-filter="example" id="edit">
            <div class="layui-form-item">
                <label class="layui-form-label">empId</label>
                <div class="layui-input-inline">
                    <input type="text" name="empId" value="${emp.empId}" disabled="disabled" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">empName</label>
                <div class="layui-input-inline">
                    <input type="text" name="empName" value="${emp.empName}" placeholder="empName" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">gender</label>
                <div class="layui-input-block">
                    <c:choose>
                        <c:when test="${emp.gender == 'M'}">
                            <input type="radio" name="gender" value="M" title="男" checked="checked">
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="gender" value="M" title="男">
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${emp.gender == 'W'}">
                            <input type="radio" name="gender" value="W" title="女" checked="checked">
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="gender" value="W" title="女">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">email</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" placeholder="email" value="${emp.email}" autocomplete="off"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">deptName</label>
                <div class="layui-input-inline" id="select">

                    <select name="department" lay-filter="aihao">

                    </select>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="updateForm">立即提交</button>
                </div>
            </div>
        </form>
    </div>

    <jsp:include page="../viewModel/foot.jsp"></jsp:include>

</div>

<script>

    // $(function () {
    //
    //     // $("#select").click(function () {
    //     //     alert("点击")
    //     // });
    //
    //     $("#select")
    //
    // })

    $(document).ready(function () {
        $.ajax({
            url: "${PATH}/dept/getdept",
            type: "POST",
            success: function (result) {
                console.log(result);

                //<option value="1">阅读</option>
                $.each(result.extend.depts, function (index, item) {
                    $("#select select").append($("<option></option>").attr("value", item.deptId).append(item.deptName));
                });
            }

        })

        $("#updateForm").click(function () {
            alert($("#edit form").serialize());
            console.log($("#edit").serialize());
        });

    });


</script>

</body>

</html>
