<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello JSP</h1>
	<h1>${pageContext.request.contextPath}</h1>
	<h1>${pageContext.request.requestURL}</h1>
	<h1>${pageContext.request.remoteAddr}</h1>
	<h1>${pageContext.request.remoteHost}</h1>
	<h1>${pageContext.request.requestURI}</h1>
	<h1>${pageContext.request.queryString}</h1>
</body>
</html>