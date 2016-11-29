<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 29.11.16
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Pets</title>
  </head>
  <body>
    <h2>Pet's management</h2>
    <hr>
    <form action="add" method="post">
      Id: <input type="text" name="id" value="${pet.id}" readonly size="1"/>
      Name: <input type="text" name="name" value="${pet.name}" size="20" pattern="^[\w ]{3,10}$"/>
      Note: <input type="text" name="note" value="${pet.note}" size="60" pattern="^[\w ]{3,100}$"/>
      <input type="submit" value="Save">
    </form>
    <hr>
    <table border="1">
      <tr>
        <th width="20">ID</th>
        <th width="100">NAME</th>
        <th width="400">NOTE</th>
      </tr>
      <c:forEach var="p" items="${pets}">
        <tr>
          <td><a href="/edit?id=${p.id}">${p.id}</a></td>
          <td>${p.name}</td>
          <td>${p.note}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
