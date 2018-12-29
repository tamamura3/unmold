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

		<div class="big-title">Reset Password</div>

<!-- もしresetパラメータがnullじゃなかったら -->
		<%
			if (request.getParameter("reset") != null) {
		%>

		<!-- そしてパラメータがtrue（メール送信完了）なら、フォーム消してメッセージだけだす -->
		<%
			if (request.getParameter("reset").equals("true")) {
		%>
		<div class="big-title">A Mail will be sent.<br>Follow the instraction on that mail.</div>

		<!-- パラメータがfalse（メール登録なし）なら、メッセージ入りにフォームをだす -->
		<%
			} else if(request.getParameter("reset").equals("false")) {
		%>
		<div class="error-message">Entered Mail address was not
			registered as a user.</div>

		<form action="/unmold/ResetPassword" name="mailForResetPassword"
			method="post" class="center-contents onsubmit="return validateResetPassword()">
			<input type="text" name="mail" placeholder="Mail Address"
				maxlength="200">
			<button type="submit" name="submit" class="button">Submit</button>
			<br> <br>
			<div>
				Please type your mail address.<br>A mail to reset password will
				be sent.
			</div>
		</form>

<!-- もしresetパラメータがnullなら、初訪問なのでフォームだけだす-->
		<%
			}} else {
		%>

		<form action="/unmold/ResetPassword" name="mailForResetPassword"
			method="post" class="center-contents">
			<input type="text" name="mail" placeholder="Mail Address"
				maxlength="200" onsubmit="return validateResetPassword()">
			<button type="submit" name="submit" class="button">>Submit</button>
			<br> <br>
			<div>
				Please enter your mail address.<br>We will sent you an email to reset password.
			</div>
		</form>
		<%
			}
		%>

	</div>

	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>