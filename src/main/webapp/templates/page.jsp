<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        table{
            border-collapse: collapse
        }
        .content{
            margin: auto;
            width: 80%;
            float: left;
            margin-left: 30px;
            height: auto
        }
        .pagination {
            display: inline-block;
        }
        .pagination a {
            color: black;
            font-size: 22px;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
        }
        .pagination a.active {
            background-color: #4CAF50;
            color: white;
        }
        .pagination a:hover:not(.active) {
            background-color: chocolate;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="content">
        <c:set var="page" value="${requestScope.page}"/>
        <h1>List of Phones</h1>
        <div class="pagination">
            <c:forEach begin="${1}" end="${requestScope.totalPages}" var="i">
                <a class="${i==page?"active":""}" href="list?page=${i}">${i}</a>
            </c:forEach>
            <a href="list?page=${(page + 1 <= totalPages) ? page + 1 : page}">Next</a>
        </div>

        <table class="table table-stripped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Release date</th>
                <th>Describe</th>
                <th>Quantities</th>
                <th>Price</th>
<%--                <th>Category</th>--%>
            </tr>
            <c:forEach items="${requestScope.data}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td><img src="${p.image}" width="100px" height="100px"/></td>
                    <td>${p.releaseDate}</td>
                    <td>${p.describe}</td>
                    <td>${p.quantity}</td>
                    <td>${p.price}</td>
<%--                    <td>${p.cate.name}</td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>