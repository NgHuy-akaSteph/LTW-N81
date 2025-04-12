<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bai 2</title>
</head>
<body>
    <form class="form" action="${pageContext.request.contextPath}/execute" method="post">
        <label for="input1">Enter an integer n: </label>
        <input type="text" name="num1" value="${num1}" id="input1">
        <button type="reset">Reset</button>
        <br>
        <c:if test="${result != null}">
            <label> Result:
                <input type="text" value="${result}" readonly>
            </label>
        </c:if>
        <br>
        <button type="submit">Execute</button>
        <p style="color: red">${error}</p>
    </form>
</body>
</html>
