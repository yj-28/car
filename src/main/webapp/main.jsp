<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2020/11/17
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--<link href="js/jquery-1.12.4.js">--%>
<script src="js/jquery-1.12.4.js" type="text/javascript"></script>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function delCar(id) {
            var delFlag = confirm("是否确认删除ID为"+id+"的汽车?");
            if (delFlag){
                $.ajax({
                    url:'/deleteCar?id='+id,
                    type:'post',
                    success:function (data) {
                        alert(data);
                        window.location.reload();
                    }
                })
            }
        }
    </script>
</head>
<body>
你好,${sessionScope.loginUser.userName}
<br>
<form method="post" name="search" action="search">
    汽车品牌：<input id="brand" class="input-text" type="text" name="brand" value="${brand}"  />
    座位数：从<input id="lowseats" class="input-text" type="text" name="lowseats" value="${lowseats==0?'':lowseats}"  />
    到<input id="highseats" class="input-text" type="text" name="highseats" value="${highseats==0?'':highseats}"  />
    <input class="input-btn" type="submit" name="submit" value="搜索" />
    <div id="suggest"></div>
</form>
<div id="content" class="wrap">
    <div class="">
        <form method="post" >
            <table>
                <tr class="title">
<%--                    <th class="checker"><input type="checkbox" name="all" onchange="checkall(this)" /></th>--%>
                    <th>ID</th>
                    <th>品牌</th>
                    <th>颜色</th>
                    <th>座位数</th>
                    <th>日租金</th>
                    <th>添加日期</th>
                    <th>添加人</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="car" items="${cars}">
                    <tr>
<%--                        <td><input type="checkbox" name="id" value="${car.id}" /></td>--%>
                        <td class="title">${car.id}</td>
                        <input type="hidden" name="id" value = "${car.id }"/>
                        <td class="title">${car.brand}</td>
                        <input type="hidden" name="brand" value = "${car.id }:${book.brand }"/>
                        <td>${car.color }</td>
                        <input type="hidden" name="color" value = "${car.id }:${car.color }"/>
                        <td>${car.seats}</td>
                        <input type="hidden" name="seats" value = "${car.id }:${car.seats }"/>
                        <td>${car.rentmoney}</td>
                        <input type="hidden" name="rentmoney" value = "${car.id }:${car.rentmoney }"/>
                        <td>${car.createdate}</td>
                        <input type="hidden" name="createdate" value = "${car.id }:${car.createdate }"/>
                        <td>${car.username}</td>
                        <input type="hidden" name="username" value = "${car.id }:${car.username }"/>
                        <td>
<%--                            <input name="del" type="button" value="删除" onclick='delRow(${car.id})' />--%>
<%--                            <input name="look" type="button" value="删除"  onclick='delCar(${car.id})' />--%>

                            <a href="${pageContext.request.contextPath}/detailCar?id=${car.id}">查看</a>
                            <a href="javascript:void(0)" onclick="delCar(${car.id})" type="button">删除</a>
<%--                            <a href="${pageContext.request.contextPath}/deleteCar?id=${car.id}">删除</a>--%>

                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${not empty requestScope.pb }">
                <div class="page-spliter">
                    <a href="search?pageIndex=1&brand=${brand }&lowseats=${lowseats }&highseats=${highseats }">首页</a>
                    <c:forEach var="i" begin="1" end="${requestScope.pb.pageCount }" step="1">
                        <c:if test="${i==requestScope.pb.pageIndex }">
                            <span class="current">${i }</span>
                        </c:if>
                        <c:if test="${not (i==requestScope.pb.pageIndex) }">
                            <a href="search?pageIndex=${i }&brand=${brand }&lowseats=${lowseats }&highseats=${highseats }">${i }</a>
                        </c:if>
                    </c:forEach>
                    <a href="search?pageIndex=${requestScope.pb.pageCount }&brand=${brand }&lowseats=${lowseats }&highseats=${highseats }">尾页</a>
                    <a href="addCar.jsp">添加汽车详情</a>
                </div>
            </c:if>
        </form>
    </div>
</div>

<br>
<%=request.getAttribute("Car")%>

</body>
</html>
