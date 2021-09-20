<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/5/27
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 左侧导航 --%>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">

<%--            <c:forEach items="${userMenus}" var="u">--%>
<%--                <c:if test="u.pid=0">--%>
<%--                    <li class="layui-nav-item">--%>
<%--                        <a class="" href="javascript:;">${u.name}</a>--%>
<%--                        <dl class="layui-nav-child">--%>

<%--                            <c:forEach items="${userMenus}" var="children">--%>
<%--                                <c:if test="children.id =u.pid">--%>
<%--                                    <dd><a href="${children.url}">${children.name}</a></dd>--%>
<%--                                </c:if>--%>

<%--                            </c:forEach>--%>
<%--                        </dl>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>
            <c:forEach items="${userMenus}" var="u">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">${u.key.name}</a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${u.key.children}" var="c">
                            <dd><a href="${c.url}">${c.name}</a></dd>
                        </c:forEach>

                    </dl>
                </li>
            </c:forEach>


<%--            <li class="layui-nav-item">--%>
<%--                <a class="" href="javascript:;">人员管理</a>--%>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="${PATH}/user/addUI">添加</a></dd>--%>
<%--                    <dd><a href="${PATH}/user/listUI">查看所有</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--                        <li class="layui-nav-item layui-nav-itemed">--%>
<%--                            <a class="" href="javascript:;">角色管理</a>--%>
<%--                            <dl class="layui-nav-child">--%>
<%--                                <dd><a href="${PATH}/role/forwardPages/addRole">添加</a></dd>--%>
<%--                                <dd><a href="${PATH}/role/forwardPages/listRole">查看所有</a></dd>--%>
<%--                            </dl>--%>
<%--                        </li>--%>
<%--                        <li class="layui-nav-item ">&lt;%&ndash;  layui-nav-itemed&ndash;%&gt;--%>
<%--                            <a class="" href="javascript:;">人员角色管理</a>--%>
<%--                            <dl class="layui-nav-child">--%>
<%--                                <dd><a href="${PATH}/role/forwardPages/listRoleController">查看所有</a></dd>--%>
<%--                            </dl>--%>
<%--                        </li>--%>
<%--                        <li class="layui-nav-item ">--%>
<%--                            <a class="" href="javascript:;">权限菜单管理</a>--%>
<%--                            <dl class="layui-nav-child">--%>
<%--                                <dd><a href="${PATH}/menu/pageForwards/listMenus">查看所有菜单</a></dd>--%>
<%--                                <dd><a href="${PATH}/menu/pageForwards/addMenu">添加菜单</a></dd>--%>
<%--                            </dl>--%>
<%--                        </li>--%>
<%--                        <li class="layui-nav-item ">--%>
<%--                            <a href="javascript:;">分类管理</a>--%>
<%--                            <dl class="layui-nav-child">--%>
<%--                                <dd><a href="${PATH}/category/oneLevelUI">一级分类查询</a></dd>--%>
<%--                                <dd><a href="${PATH}/category/forwardPage/addOneLevelUI">一级分类新增</a></dd>--%>
<%--                                <dd><a href="${PATH}/category/twoLevelUI">二级分类查询</a></dd>--%>
<%--                                <dd><a href="javascript:;">二级分类新增</a></dd>--%>
<%--                            </dl>--%>
<%--                        </li>--%>
<%--                        <li class="layui-nav-item ">--%>
<%--                            <a href="javascript:;">产品管理</a>--%>
<%--                            <dl class="layui-nav-child">--%>
<%--                                <dd><a href="${PATH}/product/forwardPages/addProductUI">产品新增</a></dd>--%>
<%--                                <dd><a href="${PATH}/product/forwardPages/listProductUI">产品查询</a></dd>--%>

<%--                            </dl>--%>
<%--            </li>--%>
        </ul>
    </div>
</div>