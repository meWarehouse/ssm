<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/4
  Time: 17:28
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
                elem: '#twoLevelListPage'
                ,id : "reloadData"/* 提供  reload: function(){}  使用 */
                , url: '${PATH}/category/twoLevelPageMsg' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'pId', title: 'pId', sort: true, fixed: 'left'}
                    , {field: 'name', title: 'name'}
                    , {field: 'order', title: 'order', sort: true}
                    , {fixed: 'right', width: 178, align: 'center', toolbar: '#barDemo'}

                ]]
            });

            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(userFilter)', function (obj) {
                var data = obj.data;

                if (obj.event === 'detail') {

                } else if (obj.event === 'del') {
                    //删除

                } else if (obj.event === 'edit') {


                }
            });

            var $ = layui.$, active = {
                reload: function(){
                    //选项框id
                    var level_classify = $('#level_classify');

                    //执行重载  table.reload('数据框 id ', {}
                    table.reload('reloadData', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            // key: {
                            //     pId: level_classify.val()
                            // }
                            pId:level_classify.val().trim(),
                        }
                    }, 'data');
                }
            };

            //点击按钮触发事件 search_classify_btn
            $('#search_classify_btn').on('click', function(){
                //获取  data-type 属性中的值
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';

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

            <div class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select id="level_classify" name="pId" lay-verify="required">
                            <c:forEach items="${categorys}" var="c">
                                <option value="${c.order}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button id="search_classify_btn" class="layui-btn" data-type="reload">搜索</button>
                </div>
            </div>

            <table id="twoLevelListPage" lay-filter="userFilter"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>


    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
