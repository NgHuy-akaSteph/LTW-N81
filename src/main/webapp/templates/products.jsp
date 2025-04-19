<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Light gray background for better readability */
        }

        .container {
            background-color: #ffffff; /* White background for the main content */
            padding: 20px;
            border-radius: 8px; /* Rounded corners for a modern look */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
        }
        .sidebar {
            background-color: #20B2AA;
            min-height: 100vh;
            padding: 20px 0;
        }
        .sidebar a {
            color: black;
            text-decoration: none;
            display: block;
            padding: 10px 20px;
        }
        .sidebar a:hover {
            background-color: rgba(255,255,255,0.1);
        }

        .product-card img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
        }
        .navbar {
            background-color: #007bff !important;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary px-2">
        <a class="navbar-brand" href="#">
            <img src="images/logo.png" alt="Phone Shop Logo" style="height: 40px;">
        </a>
        <div class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light" type="submit">Search</button>
        </div>
        <div class="ms-auto">
            <a href="#" class="btn btn-outline-light me-2">Login</a>
            <a href="#" class="btn btn-outline-light">Register</a>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="row mt-3">
        <!-- Sidebar -->
        <div class="col-2 sidebar">
            <h5 class="text-white text-center">Categories</h5>
            <div class="list-group">
                <c:forEach var="c" items="${categories}">
                    <a href="products?categoryId=${c.id}" class="list-group-item list-group-item-action">
                            ${c.name}
                    </a>
                </c:forEach>
            </div>
        </div>

        <!-- Products Section -->
        <div class="col-10">
            <h1 class="mb-4">LIST OF PRODUCTS</h1>
            <div class="row">
                <c:forEach items="${products}" var="p">
                    <div class="card col-3 m-3" style="width: 18rem;">
                        <img src="${p.image}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${p.name}</h5>
                            <p class="card-text">Price: $${p.price}</p>
                            <a href="detail?id=${p.id}" class="btn btn-primary">Detail</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script src="/js/main.js"></script>
</body>
</html>
