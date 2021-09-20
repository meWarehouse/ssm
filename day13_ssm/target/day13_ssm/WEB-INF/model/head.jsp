<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/27
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 头部模块 --%>
<div class="layui-header">
    <div class="layui-logo"> 后台管理 </div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">控制台</a></li>
        <li class="layui-nav-item"><a href="">商品管理</a></li>
        <li class="layui-nav-item"><a href="">用户</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">其它系统</a>
            <dl class="layui-nav-child">
                <dd><a href="">邮件管理</a></dd>
                <dd><a href="">消息管理</a></dd>
                <dd><a href="">授权管理</a></dd>
            </dl>
        </li>
    </ul>


    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                ${emp.lastName}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${path}/emp/updateUI?id=${emp.id}">基本资料</a></dd>
                <dd><a href="${path}/idcard/idcardUI?id=${emp.id}">idcard修改</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="${path}/login/logout">退出</a></li>
    </ul>
</div>