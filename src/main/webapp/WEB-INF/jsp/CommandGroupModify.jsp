<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.aaa.entity.CommandGroup"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	CommandGroup commandGroup=(CommandGroup)request.getAttribute("commandGroup");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改命令组</title>
<link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container-fluid">
	<div class="row">
		<form class="form-horizontal" role="form" id="form1" name="form1" method="post" action="<%=basePath%>group/commandGroupModifySave/CommandGroupList/<%=commandGroup.getId() %>/">
		  	<div class="form-group">
			  	<label for="group_id" class="col-sm-2 control-label">ID:</label>
			  	<div class="col-sm-6">
		      		<input class="form-control" type="text" name="group_id" id="group_id" value="<%=commandGroup.getId() %>" disabled="disabled"/>
		    	</div>
	    	</div>
		  	<div class="form-group">
			  	<label for="name" class="col-sm-2 control-label">名称:</label>
			  	<div class="col-sm-6">
		      		<input class="form-control" type="text" name="name" id="name" value="<%=commandGroup.getName() %>" />
		    	</div>
	    	</div>
	    	<div class="form-group">
			  	<label for="create_date" class="col-sm-2 control-label">创建时间:</label>
			  	<div class="col-sm-6">
		      		<input class="form-control" type="text" name="create_date" id="create_date" value="<%=commandGroup.getCreate_date() %>" disabled="disabled" />
		    	</div>
	    	</div>
	    	<div class="form-group">
			  	<label for="status" class="col-sm-2 control-label">状态:</label>
			  	<div class="col-sm-6">
		      		<input class="form-control" type="text" name="status" id="status" value="<%=commandGroup.getStatus() %>" />
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