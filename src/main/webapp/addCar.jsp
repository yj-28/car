<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加汽车</title>
</head>
<body>
<form action="addCar" method="post">
    ID：<input type="text" name="ID"/><br>
    汽车品牌:<input type="text" name="BRANK"><br>
    颜色:<input type="text"  name="COLOR"><br>
    座椅数:<input type="text"  name="SEATS"><br>
    油耗:<input type="text"  name="CONSUM"><br>
    生产时间:<input type="text"  name="PRODUCTDATE"><br>
    租金:<input type="text"  name="RENTMONEY"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
