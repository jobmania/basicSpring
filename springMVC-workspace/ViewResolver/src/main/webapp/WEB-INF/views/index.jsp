<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello MVC index.jsp</h1>
	<img src="image/spring-logo.svg">
	<a href="test1?data1=100&data2=200">test1</a><br/>

	<hr/>
	<a href="test2">test2</a><br/>


	<hr/>
	<a href='test3'>test3</a><br/>
	<hr/>
	<a href='test4'>test4</a><br/>
	<form action='test5' method='post'>
		data1 : <input type='text' name='data1'/><br/>
		data2 : <input type='text' name='data2'/><br/>
		<button type='submit'>확인</button>
	</form>
</body>
</html>