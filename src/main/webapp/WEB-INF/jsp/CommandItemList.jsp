<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.aaa.entity.CommandItem"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<CommandItem> commandItemList = (List<CommandItem>) request.getAttribute("commandItemList");
	String group_id=request.getAttribute("group_id").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>命令列表</title>
<link href="<%=basePath %>bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>jquery/jquery-1.12.4.min.js"></script>
</head>
<body>
<jsp:include page="head.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<a class="btn btn-default" href="<%=basePath%>item/createItem/CommandItemCreate/<%=group_id%>/">添加命令</a>
			<a class="btn btn-default" href="<%=basePath%>item/commandRun/message/<%=group_id%>/">运行列表</a>
			<button type="button" class="btn btn-default" onclick="runChecked()">运行选中项</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
		<form id="form1" name="form1" action="<%=basePath %>item/commandRunCheckey/message/" method="POST">
			<table class="table table-bordered">
				<tr>
					<th width="50px"></th>
					<th>名称</th>
					<th width="100px">运行顺序</th>
					<th>命令</th>
					<th>操作</th>
				</tr>
				<%
					int i = 0;
					for (CommandItem ci : commandItemList) {
						i++;
				%>
				<tr>
					<td><input name="command_list" type="checkbox" id="<%=i %>" value="<%=ci.getId() %>" /></td>
					<td><%=ci.getName()%></td>
					<td><%=ci.getRun_index() %></td>
					<td><%=ci.getCommand()%></td>
					<td>
					<a href="<%=basePath%>item/commandItemModify/CommandItemModify/<%=ci.getId() %>/">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="<%=basePath%>item/commandItemDel/CommandItemList/<%=ci.getId() %>/<%=group_id%>/">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function runChecked(){
	$('#form1').submit();
}
</script>
</body>
</html>