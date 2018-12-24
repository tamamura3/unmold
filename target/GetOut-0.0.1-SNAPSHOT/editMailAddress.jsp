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

		<!-- メールアドレス変更のフォーム -->
		<div class="editinfo-t">Change Mail Address</div>
		<form action="/GetOut/EditMailLogic" name="editForm" method="post"
			onsubmit="return validateEditInfo()" class="editinfo-f">

			<%
				if (request.getParameter("update") != null) {
					String updatedSuccess = request.getParameter("update");
			%>

			<%
				if (updatedSuccess.equals("failure")) {
			%>
			<div class="error-msg">
				Failed.<br>Entered password was wrong or new mail address is
				already in use...
			</div>
			<%
				}}
			%>

			New Mail Address <br> <input type="text" name="mail"
				placeholder="New Mail Address" maxlength="200"><br> <br>
			Current password <br> <input type="password"
				name="passwordForEditMail" placeholder="Current password"
				maxlength="30"><br> <br>
			<button type="submit" name="submit" class="button">submit</button>
		</form>


		<!-- パスワード変更のフォーム -->
		<div class="editinfo-t">Change Password</div>
		<form action="/GetOut/EditPasswordLogic" name="editPasswordForm"
			method="post" onsubmit="return validateEditPassword()"
			class="editinfo-f" id="editPassword">
			<!-- jsでチェックあるのでエラーメッセージ返すことはないと思う -->
			<%
				if (request.getParameter("update") != null) {
					String updatedSuccess = request.getParameter("update");
			%>
			<%
				if (updatedSuccess.equals("failure2")) {
			%>
			<div class="error-msg">
				Failed.<br>Password is too long or empty..
			</div>
			<%
				}}
			%>
			New password<br> <input type="password"
				name="newPassword" placeholder="New password" maxlength="30"><br>
			<br>Re-type new password<br> <input type="password"
				name="newPassword2" placeholder="Re-type new password"
				maxlength="30"><br> <br>
				Current password<br> <input type="password"
				name="currentPassword" placeholder="Current password" maxlength="30"><br> <br><br>
			<button type="submit" name="submit" class="button">submit</button>
		</form>
	</div>
<jsp:include page="/actionTagFooter.jsp" />

</body>
</html>