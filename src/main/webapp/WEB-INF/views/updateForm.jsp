<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>책 정보 수정</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <style>
      body {
          background-color: #f4f4f4;
          font-family: 'Arial', sans-serif;
      }

      .header {
          background-color: #007bff;
          color: white;
          padding: 20px 0;
          margin-bottom: 40px;
      }

      .header h3 {
          margin: 0;
      }

      .btn-custom {
          width: 200px;
          font-size: 18px;
          margin: 10px;
      }

      .panel-body {
          background-color: white;
          padding: 20px;
          border-radius: 8px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      .table {
          margin-top: 20px;
      }
  </style>
</head>
<body>
<div class="header text-center">
  <a href="/" style="text-decoration: none; color: white;">
    <h3>도서 관리 시스템 - 책 정보 수정</h3>
</div>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <div class="panel-body">
      <form:form action="saveBook" cssClass="horizontal" method="post" modelAttribute="book">
        <div class="form-group">
          <form:hidden path="id"/>

          <label for="bookName" class="col-md-3">책명</label>
          <div>
            <form:input path="bookName" class="form-control"/>
          </div>

          <label for="author" class="col-md-3">저자</label>
          <div>
            <form:input path="author" class="form-control"/>
          </div>

          <label for="price" class="col-md-3">가격</label>
          <div>
            <form:input path="price" class="form-control"/>
          </div>

        </div>
        <br/>
        <div>
          <form:button class="btn btn-primary">등록</form:button>
        </div>
      </form:form>
    </div>
  </div>
</div>
<div class="footer">
  <p>🏫Semyung University</p>
</div>
</body>
</html>
