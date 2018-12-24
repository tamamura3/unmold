<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/actionTagHead.jsp"/>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/actionTagHeader.jsp" />


<% int challengeId = Integer.parseInt(request.getParameter("id")); %>

	<div class="body-wrapper">
	<div class="form-challenge-t"><%= StringEscapeUtils.escapeHtml(request.getParameter("title"))%></div>
	<div class="form-wrapper">
	<div class="review-form-text">Share your experience on this challenge.<br>
How hard to do it? What happened to you when you do it?<br>
Is is worth giving a try?</div>
		<form action="/GetOut/WriteReviewLogic" method="post" name="reviewForm" onsubmit="return validateReviewForm()">
			<textarea name="text" id="" cols="50" rows="10"
				placeholder="Shere your experience! What did you feel? Did it change you in some way?" maxlength="3000"></textarea><br>
				<input type="hidden" name="challengeId" value="<%= challengeId %>"><br>
			<button type="submit" value="submit" class="button">Submit</button>
		</form>
		</div>
	</div>


<jsp:include page="/actionTagFooter.jsp"/>
</body>
</html>