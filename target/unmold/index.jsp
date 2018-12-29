<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/actionTagHead.jsp" />
<title>site title</title>
</head>
<body>
<jsp:include page="/actionTagHeader.jsp" />

	<div class="body-wrapper-index">

			<%@ page import="java.util.*"%>
			<%@ page import="net.unmold.beans.Challenge"%>
			<%
				List<Challenge> e = (List<Challenge>) request.getAttribute("list");
			%>
			<%
				for (int i = 0; i < e.size(); i++) {
			%>
			<div class="single-challenge">
				<div class="challenge-t"><%=StringEscapeUtils.escapeHtml(e.get(i).getChallengeName())%></div>
				<div class="challenge-description"><%=StringEscapeUtils.escapeHtml(e.get(i).getDescription())%></div>
				<a href="SingleChallengeLogic?number=<%=e.get(i).getChallengeId()%>"> <div class="more-btn">Check it out</div></span>
				</a>
			</div>
			<%
				}
			%>
	</div>

	<jsp:include page="/actionTagFooter.jsp"/>

</body>
</html>