<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" meta charset="UTF-8">
<script type="text/javascript"></script>
<title>로그인 성공</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<table>
		<tr>
			<td><b>아이디</b>${member.m_id }</td>
			<td><b>비밀번호</b>${member.m_pw }</td>
			<td><b>이름</b>${member.m_name }</td>
			<td><b>생년월일</b>${member.m_birth }</td>
			<td><b>전화번호</b>${member.m_phone }</td>
		</tr>
	</table>
</body>
</html>