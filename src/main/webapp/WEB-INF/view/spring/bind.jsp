<%@page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<h1>登入表单</h1>
	<spring:bind path="command.*">
		<font color="red"> <b>${status.errorMessage}</b>
		</font>
		<br>
	</spring:bind>
	请输入使用者名称与密码：
	<p>
	<form name="loginform" action="bind.htm" method="post">
		<spring:bind path="command.username"> 名称 <input
				type="text" name="${status.expression}" value="${status.value}" />
			<br>
		</spring:bind>
		<spring:bind path="command.password">
					密码 <input type="password" name="${status.expression}"
				value="${status.value}" />
			<br>
		</spring:bind>
		<input type="submit" value="确定" />
	</form>
	注意：输入错误会再回到这个页面中。
</body>
</html>