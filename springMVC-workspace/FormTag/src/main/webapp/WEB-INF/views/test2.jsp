<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-04
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
...

<h1>test2</h1>
<%--@elvariable id="userDataBean" type="com.demo.beans.UserDataBean"--%>
<form:form modelAttribute="userDataBean" action='result'>
    이름 : <form:input path='user_name'/><br/>
    아이디 : <form:input path='user_id'/><br/>
    비밀번호 : <form:password path='user_pw' showPassword="true"/><br/>
    우편번호 : <form:input path='user_postcode'/><br/>
    주소1 : <form:input path='user_address1'/><br/>
    주소2 : <form:input path='user_address2'/><br/>
    <button type='submit'>확인</button>
</form:form>
</body>
</html>
