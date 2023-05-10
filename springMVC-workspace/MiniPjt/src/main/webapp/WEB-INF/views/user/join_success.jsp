<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-10
  Time: 오후 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<html>
<head>
  <script>
    alert('가입이 완료되었습니다')
    location.href = "${root}user/login"
  </script>
    <title>Title</title>
</head>
<body>

</body>
</html>
