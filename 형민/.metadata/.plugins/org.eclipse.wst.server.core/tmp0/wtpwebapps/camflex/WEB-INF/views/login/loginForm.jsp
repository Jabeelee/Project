<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script type="text/javascript">
	function userLogin() {
		var e_RegExp = /\w+@\w+\.\w+(\.\w+)?/; //아이디(이메일) 정규식
		
		
		var id = document.getElementById("login_id");//아이디
		var pw = document.getElementById("login_pw");//비밀번호

		/*===============아이디 유효성===============*/
		if (id.value == '') {
			alert("아이디를 입력해주세요.");
			id.focus();
			return false;
		}

		if (!e_RegExp.test(id.value)){
			alert("로그인 아이디는 이메일 형식으로만 가능합니다.");
			return false;
		}
		/*===============비밀번호 유효성===============*/

		if (pw.value == '') {
			alert("비밀번호를 입력해주세요.");
			id.focus();
			return false;
		}

	}
</script>
</head>
<body>
	<h2>로그인</h2>
	<form id="loginForm" action="/login/loginAccess.do" method="POST" >
		<div style="width: 280px">
			<label id="loginInfo"> 아이디</label>
			<input type="text" id="login_id" name="login_id" placeholder="아이디">
		</div>

		<div style="width: 280px">
			<label id="loginInfo"> 비밀번호</label>
			<input type="password" id="login_pw" name="login_pw" placeholder="비밀번호">
		</div>
		<p></p>

		<div>
			<input type="submit" value="로그인" />
			<input type="button" value="아이디 찾기" />
			<input type="button" value="비밀번호 찾기" />
			<input type="button" value="회원가입" onClick="location.href='joinForm.do'" />
		</div>

	</form>
</body>
</html>