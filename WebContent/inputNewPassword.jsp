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

	<form action="/GetOut/InsertNewPasswordLogic" method="post" name="newPassForm" onsubmit="return validateNewPassword()">
Type new password<br><br>
		<input type="password" name="password"
			placeholder="New password" maxlength="30">
		<button type="submit" name="submit" class="button">>submit</button>
	</form>
</div>

	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>