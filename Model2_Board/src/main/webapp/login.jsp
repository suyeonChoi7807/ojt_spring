<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp 페이지</title>
</head>
<body>
	<div id="div_box">
		<h1>로그인</h1>
		<form name="loginForm" action="login.do">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">아이디</td>
					<td><input type="text" name="id"/></td>
				</tr>
				
				<tr>
					<td bgcolor="orange">패스워드</td>
					<td><input type="password" name="password"/></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>