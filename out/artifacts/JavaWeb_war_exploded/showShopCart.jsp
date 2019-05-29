<%--
  Created by IntelliJ IDEA.
  User: 黄文威
  Date: 2019/5/26
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>
<jsp:include page="Navigationbar.jsp"/>
<html>
<head>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<title>购物车</title>
</head>
<body>
<div style="text-align: center;">
	<h1>商品列表</h1>
	<div style="text-align: right"><a href="ShopCartServlet?pid=${p.id}&toDo=${"清空"}">清空购物车</a></div>
	<table cellspacing="1" cellpadding="0" width="40%" border="0">
		<tbody>
		<tr bgcolor="#fba661" height="20">
			<td>
				<div align="center">编号</div>
			</td>
			<td>
				<div align="center">名称</div>
			</td>
			<td>
				<div align="center">数量</div>
			</td>
			<td>
				<div align="center">价格</div>
			</td>
			<td>
				<div align="center">图片</div>
			</td>
			<td>
				<div align="center">移除</div>
			</td>
		</tr>
		<c:forEach var="p" items="${shopCart}">
			<tr bgcolor="#f3f3f3" height="25">
				<td width="10%">
					<div align="center">${p.id }</div>
				</td>
				<td width="13%">
					<div align="center">${p.name}</div>
				</td>
				<td width="12%">
					<div align="center">${p.amount}</div>
				</td>
				<td width="10%">
					<div align="center">${p.price}</div>
				</td>
				<td width="12%">
					<div align="center">
						<img height="25" hspace="0" src="<%=path%>/imag/${p.imagpath}" width="83" border="0"
						     alt=""/>
					</div>
				</td>
				<td width="13%">
					<div align="center">
						<a href="ShopCartServlet?pid=${p.id}&toDo=${"remove"}">移除</a>
					</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<span style="font-size: large; ">总价:${totalPrice}</span>
</body>
</html>
