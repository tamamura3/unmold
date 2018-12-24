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


		<div class="about-wrapper">
			<div class="about-title">What Is UnMOLD</div>
			<div class="about-content">
				Unmold is a website that you can find a variety of comfort zone
				challenges.<br> Once you registered, You can record challenges
				you've done and share your story on the website.<br> <br>
				If You think nothing interesting happens to your life.<br> You
				make it happen.<br>
			</div>
		</div>

		<div class="about-wrapper" id="contact">
			<div class="about-title">contact</div>
			<div class="about-content">
				<%
					String isItSent = request.getParameter("contact");
				%>
				<%-- なぜかif(isItSent == "true")がtrueにならなかった。<%= isItSent %>だとtrueと表示されるのに、、 --%>
				<!-- 問い合わせ後はパラメータにtrueが渡され、フォームの代わりにthank youメッセージが表示される -->
				<%
					if (isItSent != null) {
				%><h1>Thank you for getting in touch!</h1>
				<%
					} else {
				%>
				Please let us hear your question, feedback or anything.
				<div class="contact-form-wrapper">
					<form action="/GetOut/ContactFormLogic" name="contactForm"
						method="post" onsubmit="return validateContactForm()">
						<input type="text" name="name" placeholder="Name" maxlength="15"><br>
						<br> <input type="text" name="mail"
							placeholder="Mail Address" maxlength="200"><br> <br>
						<textarea type="text" name="text" placeholder="Message"
							maxlength="2000"></textarea>
						<br> <br>
						<button type="submit" name="send" value="send" class="button">Send</button>
					</form>
				</div>
				<%
					}
				%>
			</div>
		</div>


		<div class="about-wrapper" id="staff">
			<div class="about-title">the staff</div>
			<div class="about-content">
				<img src="/GetOut/image/8biticon.png">
				<div>Nao</div>
				<div class="stuff-text">
					Hello!<br>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/actionTagFooter.jsp" />
</body>
</html>

