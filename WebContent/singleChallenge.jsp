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
	<%@ page import="net.getout.beans.Challenge"%>
	<%@ page import="net.getout.beans.Reviews"%>
	<%
		Challenge challenge = (Challenge) request.getAttribute("challenge");
	%>

	<div class="body-wrapper">

		<!-- もしuserがnullでなければ -->
		<%
			if (user != null) {
		%>
		<%@ page import="net.getout.dao.AchievementDAO"%>
		<%
			AchievementDAO achievementDAO = new AchievementDAO();
				boolean isThisAlreadyAdded = achievementDAO.validateAdd(user.getId(), challenge.getChallengeId());
		%>
		<!-- さらにisThisAlreadyAddedがtrueで追加済みなら　追加済みアイコンをだす -->
		<%
			if (isThisAlreadyAdded) {
		%>

		<div class="achivement-btn-w">
			<i class="fas fa-medal fa-2x"></i>
		</div>
		<div class="single-challenge-t">
			<%=StringEscapeUtils.escapeHtml(challenge.getChallengeName())%>
		</div><br>
		<div class="description-t">DESCRIPTION</div>
		<div class="single-challenge-de">
			<%=StringEscapeUtils.escapeHtml(challenge.getDescription())%>
		</div>

		<!-- もしログインは済みだが未追加なら、追加ボタンをだす -->
		<%
			} else {
		%>

		<div class="achivement-btn-w">
			<a href="AchieveLogic?number=<%=challenge.getChallengeId()%>"> <i
				class="fas fa-plus fa-2x"></i>
			</a>
		</div>

		<div class="single-challenge-t">
			<%=StringEscapeUtils.escapeHtml(challenge.getChallengeName())%>
		</div>
		<div>DESCRIPTION</div>
		<div class="single-challenge-de">
			<br><%=StringEscapeUtils.escapeHtml(challenge.getDescription())%>
		</div>
		<%
			}
		%>
		<!-- もしuserがnullなら -->
		<%
			} else {
		%>
		<div class="single-challenge-t">
			<!-- <div class="achievement-button">将来的には設置して、押すと「会員登録したら追加できます」というページを作りたい
				<i class="fas fa-medal fa-3x"></i>
			</div> -->
			<%=StringEscapeUtils.escapeHtml(challenge.getChallengeName())%>
		</div>
		<div class="single-challenge-de">
			<%=StringEscapeUtils.escapeHtml(challenge.getDescription())%>
		</div>
		<%
			}
		%>

		<!-- ここからレビュー -->
		<div class="review-w">
			<div class="review-t">REVIEWS</div>

			<%@ page import="java.util.ArrayList"%>
			<%@ page import="net.getout.beans.Reviews"%>
			<%
				ArrayList<Reviews> e = (ArrayList<Reviews>) request.getAttribute("review");
			%>
			<%if(e.size() == 0){ %>

				<div class="no-contents">No review</div>
				<%
			}else{
				for (int i = 0; i < e.size(); i++) {
			%>
			<div class="single-review-w">
				<div class="review-text">
					<%=StringEscapeUtils.escapeHtml(e.get(i).getText())%>
				</div>
				<div class="reviewer-name">
					<div><%=StringEscapeUtils.escapeHtml(e.get(i).getReviewer())%></div>
				</div>
			</div>
			<%
				}}
			%>
		</div>

	</div>

	<jsp:include page="/actionTagFooter.jsp" />

</body>
</html>