<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄文威
  Date: 2019/5/27
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
	<title></title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
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
			<p class="navbar-text navbar-right"><%=uswerName%>
			</p>
			<a href="showShopCartServlet" class="navbar-text navbar-right">购物车</a>
		</div>
	</div>
</nav>
<div class="dropdown" id="example-navbar-collapse">
	<ul class="nav nav-tabs">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				品牌 <b class="caret"></b>
			</a>
			<ul class="dropdown-menu">
				<li><a href="SearchServlet?key=${"华为"}" name="华为">华为</a></li>
				<li><a href="SearchServlet?key=${"苹果"}" name="苹果">苹果</a></li>
				<li><a href="SearchServlet?key=${"小米"}" name="小米">小米</a></li>
				<li><a href="SearchServlet?key=${"三星"}" name="三星">三星</a></li>
			</ul>
		</li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
				类型 <b class="caret"></b>
			</a>
			<ul class="dropdown-menu">
				<li><a href="SearchServlet?key=${"手机"}">手机</a></li>
				<li><a href="SearchServlet?key=${"平板电脑"}">平板电脑</a></li>
				<li><a href="SearchServlet?key=${"智能手环"}">智能手环</a></li>
				<li><a href="SearchServlet?key=${"笔记本"}">笔记本</a></li>
			</ul>
		</li>

	</ul>
</div>
</body>
</html>
