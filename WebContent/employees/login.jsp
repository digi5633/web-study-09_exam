<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8>
		<title> 로그인 </title>
		<script type="text/javascript" src="script/employees.js"></script>
	</head>
	
	<body>
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
				<td style="width: 200px"> 사원 등록<br>(관리자로 로그인 후<br>사용가능) </td>
				<td style="width: 200px"> 마이페이지<br>(로그인 후<br>사용가능) </td>
			</tr>
		</table>
	</c:if>
		<form action="login.do" method="post" name="frm">
			<table border="1" align="center">
				<tr>
					<td colspan="2" align="center"><h2>로그인</h2></td>
				</tr>
				<tr>
					<td align="center">아 이 디</td>
					<td><input type="text" name="id" value="${id}"></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td align="center">레  벨</td>
					<td align="center">
						<select name="lev">
							<option value = "A">운영자</option>
							<option value = "B">일반회원</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;&nbsp;
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
			<div align="center">${message}</div>
		</form>
	</body>
</html>