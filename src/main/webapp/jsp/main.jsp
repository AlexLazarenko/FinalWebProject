

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<body>

<br>
MAIN PAGE
<br><br>
<a href="${pageContext.request.contextPath}/Home?action=login">Go to login page</a>
<br><br>
<a href="${pageContext.request.contextPath}/Home?action=showUser">Show  user</a>
<br><br>
<a href="${pageContext.request.contextPath}/Home?action=showAllUsers">Show all users</a>
<br><br>
<a href="${pageContext.request.contextPath}/Home?action=logout">Logout</a>
<br><br>
<a href="${pageContext.request.contextPath}/Home?action=uploadImage">upload image</a>
<br><br>


</body>
</html>