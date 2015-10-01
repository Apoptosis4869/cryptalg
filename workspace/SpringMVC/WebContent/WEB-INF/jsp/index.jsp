<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
<script src="static/js/jquery-2.1.4.min.js"></script>
<script>
$(function(){
	
	$("#lobu").bind("click",function(){
		var data = {userid:$("#userid").val(),password:$("#password").val()};
		$.ajax({
			url:"login",
			type:"post",
			async:true,
			data:data,
			success:function(resp){
				alert(resp.result);
			},
			error:function(err){
				alert("Ajax error at status: " + err.status);
			}
			
		});
	});
	
});
	
</script>
</head>
<body>
	<div style="text-align:center;">
		用户名：<input id="userid" /><br>
		密码：<input id="password" /><br>
		<input id="lobu" type="button" value="login"/><input type="button" value="register"/>
	</div>
</body>
</html>