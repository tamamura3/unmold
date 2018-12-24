<%@ page import="org.apache.commons.lang.StringEscapeUtils"%>
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
		<div class="delete-account-t">It's sad to see you going.</div>
		<div>
			But if you completely sure, click the delete button below.<br> <br>
			Just want you to know that once you deleted your account, there is no
			recovery or undone.<br>All of your data will be gone forever.<br>
			<a href="/GetOut/DeleteAccountLogic"><div
					class="confirm-delete-btn">DELETE ACCOUNT</div></a> <a
				href="/GetOut/MyPageLogic"><div class="confirm-delete-btn">CANCEL</div></a>
			<br> <br>Thank you very much.
		</div>
	</div>

	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>