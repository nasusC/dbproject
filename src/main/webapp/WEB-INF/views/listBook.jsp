<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Library</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <style>
      body { background-color: #f4f4f4; font-family: 'Arial', sans-serif; }
      .header { background-color: #007bff; color: white; padding: 20px 0; margin-bottom: 40px; }
      .header h3 { margin: 0; }
      .btn-custom { width: 200px; font-size: 18px; margin: 10px; }
      .panel-body { background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }
      .table { margin-top: 20px; }
  </style>
</head>
<body>
<div class="header text-center">
  <a href="/" style="text-decoration: none; color: white;">
    <h3>도서 관리 시스템 - 책 목록</h3>
  </a>
</div>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
    <div class="panel-body">
      <table class="table table-striped text-center">
        <tr>
          <th>번호</th>
          <th>책명</th>
          <th>저자</th>
          <th>가격</th>
          <th>비고</th>
        </tr>
        <c:forEach var="tempBook" items="${books}">
          <c:url var="updateLink" value="/book/updateForm">
            <c:param name="bookId" value="${tempBook.id}"/>
          </c:url>
          <c:url var="deleteLink" value="/book/delete">
            <c:param name="bookId" value="${tempBook.id}"/>
          </c:url>
          <tr>
            <td>${tempBook.id}</td>
            <td>${tempBook.bookName}</td>
            <td>${tempBook.author}</td>
            <td>${tempBook.price}</td>
            <td>
              <a href="${updateLink}">수정</a> |
              <a href="${deleteLink}" onclick="if(!(confirm('선택한 책을 삭제하시겠습니까?'))) return false;">삭제</a>
            </td>
          </tr>
        </c:forEach>

      </table>
      <div class="panel-heading">
        <a href="/book/showForm" class="btn btn-primary">등록</a>
        <a href="/" class="btn btn-secondary">뒤로 가기</a>
      </div>
    </div>
  </div>
</div>
<div class="footer">
  <p>🏫Semyung University</p>
</div>
</body>
</html>
