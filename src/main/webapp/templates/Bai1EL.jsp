<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/21/2025
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bai 1</title>
</head>
<body>
<form action="">
    Nhap so thu 1: <input type="text" name="num1"><br>
    Nhap so thu 2: <input type="text" name="num2"><br>
    Nhap so thu 3: <input type="text" name="num3"><br>
    <button type="submit">TINH TOAN</button>
    <h4>
        Tong: ${param.num1 + param.num2 + param.num3} <br>
        Trung binh: ${(param.num1 + param.num2 + param.num3) / 3} <br>
        Hieu: ${param.num1 - param.num2 - param.num3}
    </h4>
</form>
</body>
</html>
