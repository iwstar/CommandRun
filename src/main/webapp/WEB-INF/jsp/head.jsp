<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<nav class="navbar navbar-default" role="navigation">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="<%=basePath%>">Command</a>
		<ul class="nav navbar-nav">
			<li><a href="<%=basePath%>group/commandGroupList/CommandGroupList/">命令组</a></li>
		</ul>
	</div>
</div>
</nav>