<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-09
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var='obj' items='${list }'>
    ${obj.data1 }, ${obj.data2 }, ${obj.data3 }<br/>
</c:forEach>


</body>
</html>
