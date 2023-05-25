<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-10
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<html>
<head>
    <script>
        alert('로그인에 실패하엿습니다')
        location.href = '${root}user/login?fail=true'
    </script>
    <title>Title</title>
</head>
<body>

</body>
</html>
