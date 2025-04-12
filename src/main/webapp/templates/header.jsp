<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="collapse navbar-collapse">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="logo" width="200" height="70">
        <ul class="navbar-nav mr-auto justify-content-center w-100">
            <li class="nav-item"><a class="nav-link h4" href="${pageContext.request.contextPath}/home">Home</a></li>
            <li class="nav-item"><a class="nav-link h4" href="${pageContext.request.contextPath}/list">List</a></li>
            <li class="nav-item"><a class="nav-link h4" href="${pageContext.request.contextPath}/tableft">Tableft</a></li>
            <li>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </li>
        </ul>
    </div>
</nav>