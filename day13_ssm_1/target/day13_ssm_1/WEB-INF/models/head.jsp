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
            <a href="${PATH}/login/loginUI">
                <img src="${PATH}${u.headIcon}" class="layui-nav-img">
                ${u.userName}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${PATH}/login/details">基本资料</a></dd>
                <dd><a href="${PATH}/login/modifyPasswordUI">修改密码</a></dd>
                <dd><a href="${PATH}/login/modifyHeadUI">修改头像</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="${PATH}/login/logout">退出登录</a></li>
    </ul>
</div>