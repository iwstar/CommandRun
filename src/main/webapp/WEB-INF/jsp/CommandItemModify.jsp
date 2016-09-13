<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.aaa.entity.CommandItem"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	CommandItem ci=(CommandItem)request.getAttribute("commandItem");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改命令</title>
<link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container-fluid">
	<div class="row">
		<form class="form-horizontal" role="form" id="form1" name="form1" method="post" action="<%=basePath%>item/commandItemModifySave/CommandItemList/<%=ci.getId() %>/<%=ci.getGroup_id().toString()%>/">
			<div class="form-group">
				<label for="id" class="col-sm-2 control-label">ID:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="id" id="id" value="<%=ci.getId() %>" disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="name" id="name" value="<%=ci.getName() %>" />
				</div>
			</div>
			<div class="form-group">
				<label for="run_index" class="col-sm-2 control-label">Run Index:</label>
				<div class="col-sm-6">
			  		<input class="form-control" type="text" name="run_index" id="run_index" value="<%=ci.getRun_index() %>" />
			  	</div>
			</div>
			<div class="form-group">
				<label for="command" class="col-sm-2 control-label">Command:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="command" id="command" value="<%=ci.getCommand() %>" />
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="col-sm-2 control-label">Remark:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="remark" id="remark" value="<%=ci.getRemark() %>" />
				</div>
			</div>
			<div class="form-group">
				<label for="create_date" class="col-sm-2 control-label">Create Date:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="create_date" id="create_date" value="<%=ci.getCreate_date() %>"  disabled="disabled"/>
				</div>
			</div>
			<div class="form-group">
				<label for="status" class="col-sm-2 control-label">Status:</label>
				<div class="col-sm-6">
					<input class="form-control" type="text" name="status" id="status" value="<%=ci.getStatus() %>" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-primary" type="submit" name="button" id="button" value="提交" />
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>