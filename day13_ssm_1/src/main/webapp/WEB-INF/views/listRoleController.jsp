<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/25
  Time: 21:47
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
        layui.use(['table', 'element'], function () {
            var element = layui.element;
            var table = layui.table;

            //第一个实例
            table.render({
                elem: '#roleListPage'

                , url: '${PATH}/userRole/userRoleMsg' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'uid', title: 'uid', sort: true, fixed: 'left'}
                    , {field: 'rid', title: 'rid', sort: true, fixed: 'left'}
                    , {field: 'uname', title: '姓名'}
                    , {
                        field: 'ugender', title: '性别', templet: function (data) {
                            return data.ugender == "M" ? "男" : "女";
                        }
                    }
                    , {field: 'rname', title: '角色'}
                    , {fixed: 'right', width: 178, align: 'center', toolbar: '#barDemo'}

                ]]
            });

            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(userFilter)', function (obj) {
                var data = obj.data;
                if (obj.event === 'detail') {

                } else if (obj.event === 'del') {


                } else if (obj.event === 'edit') {

                    <%--var roles;--%>
                    <%--//查出所有角色--%>
                    <%--$.ajax({--%>
                    <%--    url:"${PATH}/userRole/allRole",--%>
                    <%--    type: "POST",--%>
                    <%--    async:false,--%>
                    <%--    success:function (date) {--%>
                    <%--        console.log(date)--%>
                    <%--        roles = date;--%>
                    <%--    }--%>
                    <%--});--%>

                    edit_one_item($("#edit_userRoleMsg "), data.uid, data.rname);

                }
            });

            function edit_one_item(ele, id, name) {
                $("#name").attr("placeholder", name);
                layer.open({
                    type: 1,
                    area: ['600px', '400px'],
                    title: '修改【' + name + '】信息',
                    content: $(ele),
                    shade: 0,
                    btn: ['提交', '重置']
                    , btn1: function (index, layero) {
                        var kk = $("#select_role").val().trim();
                        // alert(kk);
                        if (kk == name) {
                            layer.msg("你并没有修改任何信息");
                            return;
                        } else if (kk == null || kk == "") {
                            layer.msg("请输入你要修改的信息");
                        } else {
                            layer.confirm('真的修改【' + name + '】角色吗？', function (index) {
                                layer.close(index);//关闭询问框

                                $.post("${PATH}/userRole/updateUserRid", {"uid": id, "rid": kk}, function (result) {
                                    if (result) {
                                        layer.msg("修改成功", {time: 1000}, function () {
                                            window.location.href = "${PATH}/role/forwardPages/listRoleController";
                                        })
                                    } else {
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

    <form class="layui-form" id="edit_userRoleMsg" style="display:none">
        <div class="layui-form-item">
            <label class="layui-form-label">将角色修改为：</label>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="title" required lay-verify="required" placeholder="" autocomplete="on"--%>
<%--                       class="layui-input" id="name" style="width:100px">--%>
<%--            </div>--%>
            <div class="layui-input-inline">
                <select id="select_role" lay-verify="required">
                    <c:forEach items="${roles}" var="r">
                        <option value="${r.id}">${r.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </form>

<%--    <div class="layui-form">--%>
<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">一级分类</label>--%>
<%--            --%>
<%--            <div class="layui-input-inline">--%>
<%--                <select id="level_classify" name="pId" lay-verify="required">--%>
<%--                    <c:forEach items="${categorys}" var="c">--%>
<%--                        <option value="${c.order}">${c.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            --%>
<%--            <button id="search_classify_btn" class="layui-btn" data-type="reload">搜索</button>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="layui-body">
        <div style="padding: 15px;">
            <table id="roleListPage" lay-filter="userFilter"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" id="editRole" lay-event="edit">配置人员角色</a>
            </script>
        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
