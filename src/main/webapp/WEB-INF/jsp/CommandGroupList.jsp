<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.aaa.entity.CommandGroup"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<CommandGroup> commandGroupList = (List<CommandGroup>) request.getAttribute("commandGroupList");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>命令组</title>
<link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="head.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a class="btn btn-default" href="<%=basePath %>group/openPage/CommandGroupCreate/">添加命令组</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<tr>
					<th width="126">序号</th>
					<th>名称</th>
					<th>操作</th>
				</tr>
				<%
					int i = 0;
					for (CommandGroup cg : commandGroupList) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=cg.getName()%></td>
					<td>
						<a href="<%=basePath%>item/itemList/CommandItemList/<%=cg.getId().toString()%>/">命令列表</a>&nbsp;
						<a href="<%=basePath%>item/commandRun/message/<%=cg.getId().toString()%>/">运行</a>&nbsp;
						<a href="<%=basePath%>group/commandGroupModify/CommandGroupModify/<%=cg.getId().toString()%>/">修改</a>&nbsp;&nbsp;&nbsp;
						<a href="<%=basePath%>group/commandGroupDelete/CommandGroupList/<%=cg.getId().toString()%>/">删除</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
	</div>
</div>
</body>
</html>