<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Product Detail</title>
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
  <div class="row mt-4">
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

    <!-- Product Detail Section -->
    <div class="col-10">
      <div class="card shadow" style="width: 100%;">
        <img src="${product.image}" class="card-img-top mx-auto d-block mt-3" style="width: 20rem;" alt="Product Image">
        <div class="card-body">
          <h5 class="card-title text-center">${product.name}</h5>
          <p class="card-text"><b>Price:</b> $${product.price}</p>
          <p class="card-text"><b>Description:</b> ${product.describe}</p>
<%--          <div class="text-center">--%>
<%--            <a href="/cart/add?id=${product.id}" class="btn btn-success">Add to Cart</a>--%>
<%--            <a href="/products" class="btn btn-secondary">Back to Products</a>--%>
<%--          </div>--%>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>