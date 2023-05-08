<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-08
  Time: 오후 3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>상품 입력</h1>
<form:form action='input_product_proc' modelAttribute="product" method='post'>
  상품명 : <input type='text' name='name'/><br/>
  <form:errors path='name'/><br/>
  이메일 : <input type='text' name='email'/><br/>
  <form:errors path='email'/><br/>
  가격 : <input type='text' name='price'/><br/>
  <form:errors path='price'/><br/>

  <form:button type='submit'>확인</form:button>
</form:form>
</body>
</html>
