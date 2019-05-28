<%--
  Created by IntelliJ IDEA.
  User: 黄文威
  Date: 2019/5/27
  Time: 23:55
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
	<title>Title</title>
</head>
<body>
<div style="text-align: center;">
	<h1>商品信息</h1>
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
				<div align="center">品牌</div>
			</td>
			<td>
				<div align="center">类型</div>
			</td>
			<td>
				<div align="center">销量</div>
			</td>
			<td>
				<div align="center">价格</div>
			</td>
			<td>
				<div align="center">图片</div>
			</td>
			<td>
				<div align="center">购买</div>
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">${product.id}</div>
			</td>
			<td>
				<div align="center">${product.name}</div>
			</td>
			<td>
				<div align="center">${product.brand}</div>
			</td>
			<td>
				<div align="center">${product.type}</div>
			</td>
			<td>
				<div align="center">${product.volume}</div>
			</td>
			<td>
				<div align="center">${product.price}</div>
			</td>
			<td>
				<div align="center"><img height="25" hspace="0" src="<%=path%>/imag/${product.imagpath}" width="83"
				                         border="0" alt=""/></div>
			</td>
			<td>
				<div align="center"><a href="ShopCartServlet?pid=${product.id}&toDo=${"add"}">购买</a></div>
			</td>
		</tr>
		</tbody>
	</table>
	<h1>推荐商品</h1>
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
				<div align="center">品牌</div>
			</td>
			<td>
				<div align="center">类型</div>
			</td>
			<td>
				<div align="center">销量</div>
			</td>
			<td>
				<div align="center">价格</div>
			</td>
			<td>
				<div align="center">图片</div>
			</td>
			<td>
				<div align="center">购买</div>
			</td>
		</tr>
		<c:forEach var="p" items="${recommend}">
			<tr>
				<td>
					<div align="center">${p.id}</div>
				</td>
				<td>
					<div align="center">${p.name}</div>
				</td>
				<td>
					<div align="center">${p.brand}</div>
				</td>
				<td>
					<div align="center">${p.type}</div>
				</td>
				<td>
					<div align="center">${p.volume}</div>
				</td>
				<td>
					<div align="center">${p.price}</div>
				</td>
				<td>
					<div align="center"><img height="25" hspace="0" src="<%=path%>/imag/${p.imagpath}" width="83"
					                         border="0" alt=""/></div>
				</td>
				<td>
					<div align="center"><a href="ShopCartServlet?pid=${p.id}&toDo=${"add"}">购买</a></div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>