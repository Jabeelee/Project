<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증번호 입력 페이지</title>
</head>
<body>
	<h2>입력한 이메일로 받은 인증번호를 입력하세요.</h2>
	<form id="CCN" name="CCN" action="/CCN.do{dice},{m_id}" method="post">
		<div>
			인증번호 입력 : <input type="number" name="CCN" placeholder=" 인증번호를 입력하세요." />
		</div>
		<div>
			<input type="submit" value="인증번호 확인" />
		</div>
	</form>
</body>
</html>