<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String msg = (String)request.getAttribute("msg");
	String url = (String)request.getAttribute("url");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect</title>
</head>
<body>

<script type="text/javascript">
alert("<%=msg%>")
location.href = "<%=url%>"
</script>
</body>
</html>