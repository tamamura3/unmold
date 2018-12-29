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
	<%@ page import="net.unmold.beans.User"%>
	<%@ page import="javax.servlet.http.HttpSession"%>
	<%
		User user = (User) session.getAttribute("loggedIn");
	%>

	<%@ page import="net.unmold.beans.Achievement"%>
	<%@ page import="java.util.List"%>
	<%@ page import="net.unmold.dao.GetChallengeDAO"%>
	<%@ page import="net.unmold.beans.Challenge"%>
	<%
		List<Achievement> e = (List<Achievement>) session.getAttribute("achievementList");
	%>

	<div class="body-wrapper">

		<div class="mypage-t">MYPAGE</div>

		<div>
			ACHIEVEMENT<br> <br>
			<%if(e.size() == 0){
			%>
			<div class="no-contents">No achievement.</div>
			<%
			}else{
				for (int i = 0; i < e.size(); i++) {
					GetChallengeDAO getChallengeDAO = new GetChallengeDAO();
					Challenge challenge = getChallengeDAO.getChallenge(e.get(i).getChallengeId());
			%>

			<div class="mypage-single-challenge-w">
				<div class="mypage-challenge-t">
					<i class="fas fa-trophy fa-sm"></i>
					<%=StringEscapeUtils.escapeHtml(challenge.getChallengeName())%></div>
				<div class="mypage-challenge-nav-w">
					<a
						href="SingleChallengeLogic?number=<%=challenge.getChallengeId()%>"><div
							class="mypage-challenge-menu">Detail</div></a>

					<!-- もしレビュー済みならレビューをみるボタンを追加 -->
					<%@ page import="net.unmold.dao.GetReviewDAO"%>
					<%
						GetReviewDAO getReviewDAO = new GetReviewDAO();
							boolean reviewed = getReviewDAO.haveReviewedBefore(user.getId(), e.get(i).getChallengeId());
					%>
					<%
						if (reviewed) {
					%>
					<a href="/unmold/MyReview?number=<%=challenge.getChallengeId()%>"><div
							class="mypage-challenge-menu">MyReview</div></a>
					<%
						}else{
					%>
					<a
						href="/unmold/review-form?id=<%=challenge.getChallengeId()%>&title=<%=StringEscapeUtils.escapeHtml(challenge.getChallengeName())%>"><div
							class="mypage-challenge-menu">Write review</div></a>
					<% } %>
					<a href="RemoveAchievement?number=<%=challenge.getChallengeId()%>"
						onclick="return confirmRemoveChallenge()"><div
							class="mypage-challenge-menu">Remove</div></a>
				</div>
			</div>
			<%
				}}
			%>

		</div>

		<!-- account menu -->
		<div class="account-setting-w">
			<div class="mypage-accountmenu">ACCOUNT MENU</div>
			<a href="/unmold/user-info"><div class="mypage-setting-menu">EDIT
					INFO</div></a> <a href="/unmold/LogoutLogic" onclick="return confirmLogout()"><div
					class="mypage-setting-menu">LOG OUT</div> <a
				href="/unmold/delete-account"><div class="mypage-setting-menu">DELETE
						ACCOUNT</div></a>
		</div>
	</div>

	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>