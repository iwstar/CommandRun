<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建命令组</title>
<link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="container-fluid">
	<div class="row">
		<form class="form-horizontal" role="form" id="form1" name="form1" method="post" action="<%=basePath%>group/addCommandGroup/CommandGroupList/">
		  	<div class="form-group">
			  	<label for="name" class="col-sm-2 control-label">名称:</label>
			  	<div class="col-sm-6">
		      		<input class="form-control" type="text" name="name" id="name" />
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