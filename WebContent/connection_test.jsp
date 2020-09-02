<%@page import="web_study_09_exam.ds.JdbcUtilJNDI"%>
<%@page import="web_study_09_exam.ds.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터베이스 연결 테스트</title>
	</head>
	
	<body>
		<c:set var="con" value="<%=JdbcUtil.getConnection()%>"/>
		<c:out value="${con}"/>
		
		<hr>
		
		<c:set var="con1" value="<%=JdbcUtilJNDI.getConnection()%>"/>
		<c:out value="${con1}"/>
		
		<hr>
	</body>
</html>