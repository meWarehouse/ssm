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
        layui.use(['table', 'element','form'], function () {
            var element = layui.element;
            var table = layui.table;
            var form = layui.form;


            table.render({
                elem: '#userListPage'
                , id: 'testReload'
                , url: '${PATH}/product/productListPage' //数据接口 从该路径中获取数据
                , page: true //开启分页
                , cols: [[ //表头
                    {field: 'id', title: 'id', sort: true, fixed: 'left'}
                    , {field: 'shortTitle', title: 'shortTitle'}
                    , {field: 'longTitle', title: 'longTitle'}
                    , {field: 'nums', title: 'nums', sort: true}
                    , {
                        field: 'sales', title: 'sales', templet: function (data) {
                            return data.sales == null ? 0 : data.sales;
                        }
                    }
                    , {field: 'categoryId', title: 'categoryId', sort: true}
                    , {fixed: 'right', width: 178, align: 'center', toolbar: '#barDemo'}

                ]]
            });


            //绑定change事件
            form.on('select(categorylevelOne)', function (data) {

                $.ajax({
                    url: "${PATH}/product/twoLevelMsg/" + data.value,
                    type: "GET",
                    success: function (d) {
                        console.log(d);

                        var optionStr;
                        for (var i = 0; i < d.length; i++) {
                            var id = d[i].id;
                            var name = d[i].name;
                            optionStr = optionStr + "<option value='" + id + "'>" + name
                                + "</option>";
                        }
                        $("#categorylevelTwo").html(optionStr);
                        //重新渲染一下form
                        form.render('select');
                    }
                });
            });






            //点击按钮触发事件
            // $("#search_btn").on("click",function () {
            //     alert($("#categorylevelTwo").value);
            //     var type = $(this).data("type");
            //     active[type] ? active[type].call(this) : "";
            //
            // });


            var $ = layui.$,active={
                reload:function () {

                    table.reload("testReload",{
                        page:{
                            curr:1
                        }
                        ,where:{
                            categoryId:$("#categorylevelTwo").val()
                        }
                    });
                }
            };

            $('#search_btn').on('click', function(){
                // alert($("#categorylevelTwo").val()+"----");
                //获取  data-type 属性中的值
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';

            });
            //监听工具条  table.on('tool(table 的 "lay-filter 属性)', 当点击工具条时就调用函数
            table.on('tool(userFilter)', function(obj){
                var data = obj.data;

                if(obj.event === 'addImgs'){
                    /* 添加图片 */
                    window.location.href="${PATH}/product/productImgAddUI/"+data.id;

                } else if(obj.event === 'del'){


                } else if(obj.event === 'edit'){

                }
            });



        })


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
                        <select id="categorylevelOne" lay-filter="categorylevelOne"
                                lay-verify="required">
                            <c:forEach items="${category}" var="c">
                                <option value="${c.order}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select id="categorylevelTwo"
                                lay-verify="required">

                        </select>
                    </div>
                    <button id="search_btn" class="layui-btn" data-type="reload">搜索</button>
                </div>
            </div>


            <table id="userListPage" lay-filter="userFilter"></table>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="addImgs">添加图片</a>
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
