<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/actionTagHead.jsp"/>
</head>
<body>

<jsp:include page="/actionTagHeader.jsp" />

	<div class="body-wrapper">

		<div class="signup-header-w">
			<div class="signup-t">Sign up and you can,,,</div>
			<div class="signup-img-w"><img src="/unmold/image/speech.png"><br>Write a review on challenges.</div>
			<div class="signup-img-w"><img src="/unmold/image/resume.png"><br>Record challneges you've done.</div>
		</div>


		<form action="SignUpLogic" name="userForm" method="post"
			onsubmit="return validateUserForm()" class="signup-f">
			<input type="text" name="name" placeholder="Username" maxlength="15"><br> <br>
			<%
			Boolean mailInUse = Boolean.valueOf(request.getParameter("inUse"));
		%>
		<%
			if (mailInUse) {
		%>
		<div class="error-msg">This mail address is already in use</div>
		<%
			}
		%>
			<input type="text" name="mail" placeholder="Mail Address" maxlength="200"><br> <br>
			<input type="password" name="password" placeholder="Password" maxlength="30"><br>
			<br>
			<button type="submit" name="submit" class="button">submit</button>
		</form>
	</div>

	<jsp:include page="/actionTagFooter.jsp" />

</body>
</html>