<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Spring Data JPA</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <div class="col-mid-offset-1 col-mid-10 text-center">
    <h3 class="test-center">Spring Data JPA Project 1</h3>
    <hr />
    <input type="button" value="학생등록" onclick="window.location.href='showForm'; return false;" class="btn btn-primary"/>
    <br />
    <br />
    <div class="test-center">
      <div class="panel-heading">
        <div class="fs-2 text-center">학생 목록</div>
      </div>
      <div class="panel-body"></div>
        <table class="table table-striped table-bordered">
          <hr />
          <tr>
            <th>번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>주소</th>
            <th>비고</th>
          </tr>
          <c:forEach var ="tempStudent" items="${students}">
           <tr>
             <td>${tempStudent.id}</td>
             <td>${tempStudent.name}</td>
             <td>${tempStudent.email}</td>
             <td>${tempStudent.address}</td>
           </tr>
          </c:forEach>
        </table>
    </div>
  </div>
</div>


</body>
</html>
