<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄文威
  Date: 2019/5/27
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
	<title></title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
</head>
<body>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href=LogoutServlet>注销</a>
		</div>
		<form class="navbar-form navbar-left" role="search" method="get" action="SearchServlet">
			<div class="form-group">
				<label>
					<input type="text" class="form-control" placeholder="Search" name="key">
				</label>
			</div>
			<button type="submit" class="btn btn-default">搜索</button>
		</form>
		<div>
			<%
				User user = (User) request.getSession().getAttribute("User");
				String uswerName = user.getName();
			%>
			<p class="navbar-text navbar-right"> <%=uswerName%></p>
			<a href="showShopCartServlet" class="navbar-text navbar-right">购物车</a>
		</div>
	</div>
</nav>
</body>
</html>
