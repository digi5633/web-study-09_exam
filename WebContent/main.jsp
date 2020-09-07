<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:if test="${empty loginUser}">
	<jsp:forward page="login.do"/>
</c:if> --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title>회원 전용 페이지</title>
		<script type="text/javascript" src="script/employees.js"></script>
	</head>
	
	<body align="center">
	<c:if test="${empty loginUser}">
		<table border="1" align="center">
			<tr align="center">
				<td style="width: 200px"> </td>
				<td style="width: 200px"> </td>
				<td style="width: 200px"> <a href="login.do"> 로그인 </a> </td>
				<td style="width: 200px"> 사원 등록<br>(관리자로 로그인 후<br>사용가능) </td>
				<td style="width: 200px"> 마이페이지<br>(로그인 후<br>사용가능) </td>
			</tr>
		</table>
	</c:if>
		<c:if test="${!empty loginUser}">
		<table border="1" align="center">
			<tr align="center">
				<td style="width: 200px"> ${loginUser.name}님 반갑습니다. </td>
				<td style="width: 200px"> 레벨 : ${loginUser.lev} </td>
				<td style="width: 200px"> <a href="logout.do"> 로그아웃 </a> </td>
				<td style="width: 200px"> <a href="custom.do"> 사원 등록 </a> </td>
				<td style="width: 200px"> <a href="mypage.do"> 마이페이지 </a> </td>
			</tr>
		</table>
	</c:if>
	<h2>회원 전용 페이지</h2>
	<img src="images/images.png" width="70%" height="70%">
	</body>
</html>