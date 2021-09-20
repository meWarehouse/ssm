<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/25
  Time: 21:47
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
        layui.use(['tree', 'element', 'util'], function () {
            var element = layui.element;
            var tree = layui.tree;
            var util = layui.util;

            var  dataTreeMenu;

            $.ajax({
                url:"${PATH}/roleMenu/getTree",
                type:"POST",
                success:function (result) {
                    dataTreeMenu=result;
                },
                async:false,
            },"json");

            console.log(dataTreeMenu);

            //渲染
            var inst1 = tree.render({
                id : "roleMenu",
                elem: '#roleMenuTree'  //绑定元素
                ,data:dataTreeMenu
                ,showCheckbox : true
            });

            $("#submitBtn").on("click",function () {
                var checkDate = tree.getChecked("roleMenu");
                var ids = new Array();//保存选择节点的id
                for(var i = 0;i < checkDate.length;i++){
                    ids.push(checkDate[i].id);/*放入一级菜单的id*/
                    for(var j = 0;j < checkDate[i].children.length;j++){
                        ids.push(checkDate[i].children[j].id);//存入二级菜单 id
                    }
                }

                //提交数据
                // alert(ids)
                $.post("${PATH}/roleMenu/saveRoleTreeData",{"menuIds":ids.join(','),"roleId":${roleId}},function (resule) {
                    if(resule){
                        window.location.href="${PATH}/role/forwardPages/listRoleController";
                    }else{
                        alert("操作失败！！！")
                    }
                });

            })


        });


    </script>

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

    <jsp:include page="../models/head.jsp"/>

    <jsp:include page="../models/left.jsp"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div id="roleMenuTree"></div>
            <button id="submitBtn" class="layui-btn">保存</button>
        </div>
    </div>

    <jsp:include page="../models/foot.jsp"/>

</div>

</body>


</html>
