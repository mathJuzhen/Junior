<%--
  Created by IntelliJ IDEA.
  User: 黄文威
  Date: 2019/5/26
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
%>
<jsp:include page="Navigationbar.jsp"/>
<head>
	<title>商品信息</title>

</head>
<body style="background-image: url(imag/bgImg.jpg);background-size: cover ;background-repeat: no-repeat">
<div style="text-align: center;">
	<h1>商品列表</h1>
	<table cellspacing="1" cellpadding="10" width="100%" border="0">
		<tbody>
		<tr style="" height="50" align="center">
			<td style="align-items: center;">
				<div><a href="SortServlet?key=${"id"}">编号</a></div>
			</td>
			<td style="align-items: center;">
				<div>名称</div>
			</td>
			<td style="align-items: center;">
				<div><a href="SortServlet?key=${"volume"}">销量</a></div>
			</td>
			<td style="align-items: center;">
				<div><a href="SortServlet?key=${"price"}">价格</a></div>
			</td>
			<td style="align-items: center;">
				<div>图片</div>
			</td>
			<td>
				<div style="align-items: center;">购买</div>
			</td>
		</tr>
		<c:forEach var="p" items="${Products}">
			<tr style="align-items: center" height="100">
				<td width="10%">
					<div align="center"><a href="showProductInfoServlet?pid=${p.id}">${p.id }</a></div>
				</td>
				<td width="13%">
					<div align="center">${p.name}</div>
				</td>
				<td width="12%">
					<div align="center">${p.volume}</div>
				</td>
				<td width="10%">
					<div align="center">${p.price}</div>
				</td>
				<td width="12%">
					<div align="center">
						<img height="100" hspace="0" src="<%=path%>/imag/${p.imagpath}" width="100" border="0" alt=""/>
					</div>
				</td>
				<td width="13%">
					<div align="center">
						<a href="ShopCartServlet?pid=${p.id}&toDo=${"add"}">购买</a>
					</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
