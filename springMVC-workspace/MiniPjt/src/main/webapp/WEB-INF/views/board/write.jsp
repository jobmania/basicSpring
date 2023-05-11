<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-09
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>미니 프로젝트</title>
    <!-- Bootstrap CDN -->
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 상단 메뉴 부분 -->
<c:import url="/WEB-INF/views/include/menu.jsp"/>

<div class="container" style="margin-top: 100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
<%--       enctype="multipart/form-data" 이미지 처리시 추가.             --%>
                    <form:form action="${root }board/write_pro" modelAttribute="writeContentBean" enctype="multipart/form-data">
                        <form:hidden path="content_board_idx"/>
                        <div class="form-group">
                            <form:label path="content_subject">제목</form:label>
                            <form:input path="content_subject" class="form-control"/>
                            <form:errors path="content_subject" cssStyle="color:red"/>
                        </div>
                        <div class="form-group">
                            <form:label path="content_text">내용</form:label>
                            <form:textarea path="content_text" class="form-control" rows="10" cssStyle="resize: none"/>
                            <form:errors path="content_text" cssStyle="color:red"/>
                        </div>

                        <div class="form-group">
                            <form:label path="upload_file">첨부 이미지</form:label>
                            <form:input path="upload_file" type="file" class="form-control" accept="image/*"/>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">작성하기</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>

<div
        class="container-fluid bg-dark text-white"
        style="margin-top: 50px; padding-top: 30px; padding-bottom: 30px"
>
<!-- 하단 푸터 부분 -->
<c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>
