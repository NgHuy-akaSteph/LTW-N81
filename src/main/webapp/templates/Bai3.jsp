<taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>THONG TIN</h4>
<form action="">
    Nhap ho va ten: <input type="text" name="name"><br>
    Diem 1: <input type="text" name="diem1"><br>
    Diem 2: <input type="text" name="diem2"><br>
    Diem 3: <input type="text" name="diem3"><br>
    Gioi tinh: <input type="radio" name="gender" value="Nam">Nam
    <input type="radio" name="gender" value="Nu">Nu<br>
    <button type="submit">Hien thi</button>
</form>
<h4>
    GPA: ${(param.diem1 + param.diem2 * 2 + param.diem3 * 3) / 6} <br>
    ${param.name} &nbsp; ${param.gender}
</h4>
</body>
</html>
