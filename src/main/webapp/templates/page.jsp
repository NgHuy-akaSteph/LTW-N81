<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        table {
            border-collapse: collapse;
        }
        .content {
            margin: auto;
            width: 80%;
            float: left;
            margin-left: 30px;
            height: auto;
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
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-2">
            <h3>Categories</h3>
            <ul class="list-group">
                <c:forEach items="${categoryList}" var="category">
                    <li class="list-group-item">
                        <a href="list?category=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-md-10">
            <div class="content">

                <c:set var="page" value="${requestScope.page}"/>
                <c:set var="category" value="${requestScope.category}"/>

                <h1>List of Phones</h1>

                <!-- Search Bar -->
                <form action="list" method="get" class="mb-3">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search products..." value="${keyword}">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                </form>

                <!-- Pagination -->
                <div class="pagination">
                    <c:if test="${totalPages > 1}">
                        <c:choose>
                            <c:when test="${not empty category}">
                                <c:set var="baseUrl" value="list?category=${category}&page=" />
                            </c:when>
                            <c:when test="${not empty keyword}">
                                <c:set var="baseUrl" value="list?search=${keyword}&page=" />
                            </c:when>
                            <c:otherwise>
                                <c:set var="baseUrl" value="list?page=" />
                            </c:otherwise>
                        </c:choose>

                        <c:if test="${page > 1}">
                            <a href="${baseUrl}${page - 1}">Previous</a>
                        </c:if>

                        <c:forEach begin="1" end="${totalPages}" var="i">
                            <a class="${i == page ? 'active' : ''}" href="${baseUrl}${i}">${i}</a>
                        </c:forEach>

                        <c:if test="${page < totalPages}">
                            <a href="${baseUrl}${page + 1}">Next</a>
                        </c:if>
                    </c:if>
                </div>
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Release date</th>
                        <th>Describe</th>
                        <th>Quantities</th>
                        <th>Price</th>
                        <th>Category</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.data}" var="p">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.name}</td>
                            <td><img src="${p.image}" width="100px" height="100px"/></td>
                            <td>${p.releaseDate}</td>
                            <td>${p.describe}</td>
                            <td>${p.quantity}</td>
                            <td>${p.price}</td>
                            <td>${p.cate.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>