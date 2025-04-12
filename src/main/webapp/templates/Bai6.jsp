
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    Nhap so thu 1: <input type="text" name="num1"><br>
    Nhap so thu 2: <input type="text" name="num2"><br>
    Phep tinh:
    <select name="operator" onchange="form.submit()">
        <option value="+">Cong</option>
        <option value="-">Tru</option>
        <option value="*">Nhan</option>
        <option value="/">Chia</option>
    </select><br>
    <jsp:useBean id="c" class="com.nhom81.model.SoHoc" />
    <jsp:setProperty name="c" property="*" />
<%--    <jsp:setProperty name="c" property="num1" value="${param.num1}" />--%>
    <h4>${c.ketQua}</h4>
</form>
</body>
</html>
