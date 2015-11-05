<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<h1>我的第一个 JavaScript 程序</h1>
<p id="demo">这是一个段落</p>
<button type="button" onclick="displayDate()">显示日期</button>
<script>
document.getElementById("demo").innerHTML=Date();
</script>
</body>
</html> 
			