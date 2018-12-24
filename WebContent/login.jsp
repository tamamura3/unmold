<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/actionTagHead.jsp" />
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/actionTagHeader.jsp" />

	<div class="body-wrapper">

<!-- もしupdateパラメータがnullなら　純粋な訪問なのでフォームの上に普通に「loginするといいよ！」的なメッセージを出す -->

		<%
			if (request.getParameter("update") == null) {
		%>
		<div class="login-t">LOG IN</div>

		<!-- もしupdateの中がnullじゃないなら値を調べる、success(メアド変更完了)かsuccess2(パスワード変更完了　兼　パスワード忘れて再設定完了) -->
		<%
			} else {
				String updatedSuccess = request.getParameter("update");
		%>

		<!-- success(メアド変更完了)　それ使ってログインしてね -->
		<%
			if (updatedSuccess.equals("success")) {
		%>
		<div class="result-msg">
			Your mail address was changed successfully.<br>Please log in
			with the new mail address.
		</div>

		<!-- success2(パスワード変更完了　兼　パスワード忘れて再設定完了)　それ使ってログインしてね -->
		<%
			} else if (updatedSuccess.equals("success2")) {
		%>
		<div class="result-msg">
			Your password was changed successfully.<br>Please log in with
			the new password.
		</div>
		<%
			}
			}
		%>

<!-- もしloginfailパラメータがtrue（ログイン失敗！）なら　その旨メッセージを表示-->
		<%
			Boolean isLoginFailed = Boolean.valueOf(request.getParameter("loginfail"));
		%>
		<%
			if (isLoginFailed) {
		%><div class="error-msg">Mail address or password is wrong.</div>
		<%
			}
		%>

<!-- ここからは共通で表示されるフォーム部分 -->
		<form action="LoginLogic" name="userForm" method="post"
			onsubmit="return validateUserForm()" class="login-f">
			<input type="text" name="mail" placeholder="mail" maxlength="200"><br> <br>
			<input type="password" name="password" placeholder="password" maxlength="30"><br>
			<br>
			<button type="submit" name="submit" class="button">LOGIN</button>
		</form>
		<a href="/GetOut/rest-password"><div
				class="forgetpass">forgot password</div></a>
	</div>

	<jsp:include page="/actionTagFooter.jsp" />

</body>
</html>