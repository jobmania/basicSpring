<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-04
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>test3</h1>
<form:form action='result' modelAttribute="dataBean">
    <form:select path="a1">
        <form:option value="select1">선택1</form:option>
        <form:option value="select2">선택2</form:option>
        <form:option value="select3">선택3</form:option>
    </form:select>

    <hr/>
    <form:checkbox path="a2" value="check1"/>체크1
    <form:checkbox path="a2" value="check2"/>체크2
    <form:checkbox path="a2" value="check3"/>체크3

    <hr/>
    <form:radiobutton path="a3" value="radio1"/>항목1
    <form:radiobutton path="a3" value="radio2"/>항목2
    <form:radiobutton path="a3" value="radio3"/>항목3
    <button type='submit'>확인</button>
</form:form>
</body>
</html>
