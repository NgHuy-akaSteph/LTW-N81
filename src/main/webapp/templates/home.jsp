<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="text-center mb-4">The List of Categories</h1>
    <a href="/add" class="btn btn-success mb-3">Add New Category</a>
    <table class="table table-striped table-hover table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${requestScope.list}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><c:out value="${product.describe}" /></td>
                <td>
                    <a href="update?id=${product.id}" class="btn btn-sm btn-primary">Edit</a>
                    <a href="#"  onclick="doDelete(${product.id})" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function doDelete(id){
        if(confirm("Do you want to delete category id= '"+id+"'?")){
            // Nhan OK -> confirm tra ve gia tri True
            // Nhan Huy/Cancel -> confirm tra ve gia tri False
            window.location="delete?id="+id;
        }
    }
</script>
</body>
</html>