<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<h2>변경할 비밀번호를 입력해주세요.</h2>
		<tr>
			<td>

				<form id="change_pw" name="change_pw" action="change_pw"
					method="post">
					<div>
						아이디 : <input type="text" id="m_id" name="m_id"
							placeholder="아이디를 다시 입력해주세요.">
					</div>
					<div>
						변경할 비밀번호 입력 : <input type="password" id="m_pw" name="m_pw"
							placeholder="비밀번호를 입력하세요.">
					</div>
					<div>
						비밀번호 재입력 : <input type="password" id="m_pw_check"
							name="m_pw_check" placeholder="비밀번호를 입력하세요.">
					</div>

					<div>
						<input type="submit" name="member_pass" value="비밀번호 변경" />
					</div>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>