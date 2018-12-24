<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.lang.StringEscapeUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/actionTagHead.jsp" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/actionTagHeader.jsp" />

	<div class="body-wrapper">
		<%@ page import="net.getout.beans.User"
			import="net.getout.beans.Challenge" import="net.getout.beans.Reviews"%><!-- import="javax.servlet.http.HttpSession" -->
		<%
			User user = (User) session.getAttribute("loggedIn");
			Challenge challenge = (Challenge) session.getAttribute("challenge");
			Reviews review = (Reviews) session.getAttribute("review");
		%>
		<div class="myreview-w">
			<div class="myreview-t">Your review on"<span>  <%=challenge.getChallengeName()%></span>  "</div>
			<div class="myreview-text"><%=review.getText()%></div><br>
			<a href="/GetOut/DeleteReview?challenge=<%=challenge.getChallengeId()%>" onclick="return confirmDeleteReview()"><div class="review-delete-btn">delete</div></a>
		</div>

	</div>
	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>