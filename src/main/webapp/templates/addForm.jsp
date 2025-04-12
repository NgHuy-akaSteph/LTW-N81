<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add New Category</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
  <h1 class="text-center mb-4">Add New Category</h1>

  <!-- Error Message -->
  <c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
      <c:out value="${error}" />
    </div>
  </c:if>

  <form action="/add" method="post">
    <div class="mb-3">
      <label for="id" class="form-label">ID:</label>
      <input type="number" id="id" name="id" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="name" class="form-label">Name:</label>
      <input type="text" id="name" name="name" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="describe" class="form-label">Description:</label>
      <input type="text" id="describe" name="describe" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</body>
</html>