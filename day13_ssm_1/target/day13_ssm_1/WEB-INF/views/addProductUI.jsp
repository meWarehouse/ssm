<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/3
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/statics/layui/css/layui.css">
    <script src="${PATH}/statics/layui/layui.js"></script>
    <script type="text/javascript" src="${PATH}/statics/js/jquery-3.3.1.min.js"></script>

    <script>
        //一般直接写在一个js文件中
        //加载form模块，加载完成后，调用回调函数
        layui.use('form', function() {
            var form = layui.form;

            //监听提交，一旦提交表单，会调用回调函数
            form.on('submit(submitBtn)', function(data) {
                alert(data.field);
                $.post("${PATH}/product/addProduct",data.field,function (result) {
                    if(result){
                        layer.msg("添加成功",{time:1000},function () {
                            window.location.href = "${PATH}/category/twoLevelUI";
                        });
                    }else{
                        layer.msg("失败");
                    }
                });

                return false;//阻止表单跳转，阻止页面提交表单
            });

            //绑定change事件
            form.on('select(categorylevelOne)', function(data) {

                // alert(data.value)

                <%--$.post("${PATH}/product/twoLevelMsg",{"pId":data.value},function (result) {--%>
                <%--    console.log(result);--%>
                <%--});--%>
                $.ajax({
                    url:"${PATH}/product/twoLevelMsg/"+data.value,
                    type:"GET",
                    success:function (d) {
                        console.log(d);
                        // $.each(result,function (index,item) {
                        //     console.log("index:"+index);
                        //     console.log("item:"+item);
                        //
                        //     $("#categorylevelTwo").append($("<option></option>").attr("value",item.id).append(item.name));
                        //
                        // });
                        // form.render('select');
                        var optionStr;
                        for (var i = 0; i < d.length; i++) {
                            var id = d[i].id;
                            var name = d[i].name;
                            optionStr = optionStr + "<option value='"+id+"'>" + name
                                + "</option>";
                        }
                        $("#categorylevelTwo").html(optionStr);
                        //重新渲染一下form
                        form.render('select');
                    }
                });
                // $("#categorylevelTwo")[0].reset();

            });
        });
    </script>

</head>


<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="../models/head.jsp"></jsp:include>
    <jsp:include page="../models/left.jsp"></jsp:include>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">一级分类</label>
                    <div class="layui-input-inline">
                        <select id="categorylevelOne" lay-verify="required"
                                lay-filter="categorylevelOne">
                            <c:forEach items="${category}" var="c">
                                <option value="${c.order}">${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">二级分类</label>
                    <div class="layui-input-inline">
                        <select id="categorylevelTwo" name="categoryId"
                                lay-verify="required">

                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">小标题</label>
                    <div class="layui-input-inline">
                        <input type="text" name="shortTitle" required
                               lay-verify="required" placeholder="请输入小标题" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">小标题不能为空</div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">大标题</label>
                    <div class="layui-input-inline">
                        <textarea name="longTitle" required lay-verify="required" placeholder="请输入大标题" class="layui-textarea"></textarea>
                    </div>
                    <div class="layui-form-mid layui-word-aux">大标题不能为空</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-inline">
                        <input type="text" name="price" required
                               lay-verify="required" placeholder="请输入价格" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">价格不能为空</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">库存</label>
                    <div class="layui-input-inline">
                        <input type="text" name="nums" required
                               lay-verify="required" placeholder="请输入库存" autocomplete="off"
                               class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">库存不能为空</div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

        </div>
    </div>


    <jsp:include page="../models/foot.jsp"></jsp:include>
</div>
</body>


</html>
