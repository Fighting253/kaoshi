<%-- JSP 页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--绝对路径查询--%>
<%--样式丢失处理--%>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<base href="<%=basePath%>">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>菜单列表</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #00BFFF;
            color: white;
        }
        .button {
            background-color: green;
            color: white;
            border: none;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        .pagination {
            margin-top: 20px;
            text-align: center;
        }
        .pagination a, .pagination span {
            margin: 0 5px;
            padding: 5px 10px;
            border: 1px solid #ddd;
            color: #007bff;
            text-decoration: none;
            border-radius: 4px;
        }
        .pagination a:hover {
            background-color: #007bff;
            color: white;
        }
        .pagination .current, .pagination a.current {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
        .pagination .disabled {
            color: #ccc;
            cursor: not-allowed;
        }
    </style>
    <script>
        function deleteById(id) {
            if (confirm("确定删除吗？")) {
                window.location.href = "${pageContext.request.contextPath}/deleteMenu?id=" + id;
            }
        }
    </script>
</head>
<body>
<h1 align="center">菜单列表</h1>
<table class="table table-hover text-center">
    <tr>
        <th>编号</th>
        <th>菜名</th>
        <th>价格</th>
        <th>分类</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="menu">
        <tr id="tr_${menu.id}">
            <td>${menu.code}</td>
            <td>${menu.dname}</td>
            <td>${menu.price}</td>
            <td>${menu.classification}</td>
            <td>
                <a class="button" href="${pageContext.request.contextPath}/toUpdate?did=${menu.id}">修改</a>
                <button class="button" onclick="deleteById(${menu.id})">删除</button>
            </td>
        </tr>
    </c:forEach>
</table>

<div class="pagination">
    <span class="current">总记录数：${pageInfo.total}</span>
    <a href="${pageContext.request.contextPath}/getMenuList?page=1" class="${pageInfo.isFirstPage ? 'disabled' : ''}">首页</a>
    <a href="${pageContext.request.contextPath}/getMenuList?page=${pageInfo.prePage}" class="${pageInfo.isFirstPage ? 'disabled' : ''}">上一页</a>
    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
        <c:choose>
            <c:when test="${num == pageInfo.pageNum}">
                <span class="current">${num}</span>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/getMenuList?page=${num}">${num}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/getMenuList?page=${pageInfo.nextPage}" class="${pageInfo.isLastPage ? 'disabled' : ''}">下一页</a>
    <a href="${pageContext.request.contextPath}/getMenuList?page=${pageInfo.pages}" class="${pageInfo.isLastPage ? 'disabled' : ''}">尾页</a>
</div>

</body>
</html>
