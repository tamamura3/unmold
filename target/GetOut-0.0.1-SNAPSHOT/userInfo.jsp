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
	<%@ page import="net.getout.beans.User"%>
	<%@ page import="javax.servlet.http.HttpSession"%>
	<%
		User user = (User) session.getAttribute("loggedIn");
	%>
	<%
		int passLength = user.getPassword().length();
	%>
	<div class="body-wrapper">

		<div>
			<div class="userinfo-t">User Information</div>
		</div>

		<div class="userinfo-w">
			<div class="userinfo-t-2">User Name</div>
			<div class="userinfo-c"><%=StringEscapeUtils.escapeHtml(user.getName())%></div>
			<div class="userinfo-t-2">
				Mail<a href="/GetOut/edit-info">
					<div class="userinfo-edit-btn">Edit</div>
				</a>
			</div>
			<div class="userinfo-c"><%=StringEscapeUtils.escapeHtml(user.getMail())%></div>
			<div class="userinfo-t-2">
				Password <a href="/GetOut/edit-info#editPassword"><div
						class="userinfo-edit-btn">Edit</div></a>
			</div>
			<div class="userinfo-c">
				<%
					for (int i = 1; i <= passLength; i++) {
				%>*<%
					}
				%>
			</div>
		</div>

	</div>


	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>