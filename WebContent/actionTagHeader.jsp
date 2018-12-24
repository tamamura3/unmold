
<%@ page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@ page import="net.getout.beans.User"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
	User user = (User) session.getAttribute("loggedIn");
%>
<%
	if (user != null) {
%>

<div class="header-wrapper">

	<a href="/GetOut/top"><div class="logo">
			<img src="/GetOut/image/logo.png">
		</div></a>
	<div class="nav-wrapper">
		Hello, <a href="/GetOut/MyPageLogic"><div class="hello-name">
				<%=StringEscapeUtils.escapeHtml(user.getName())%>
			</div></a>
		<img id="dropbtn-icon-id" class="dropbtn-icon"
			src="/GetOut/image/hamburger.png" onclick="dropdown()">
			<div id="dropdown-wrapper-id" class="dropdown-wrapper">
				<a href="/GetOut/about.jsp"><div class="dropdown-content">What is Unmold?</div></a>
				<a href="/GetOut/MyPageLogic"><div class="dropdown-content">My Page</div></a>
				<a href="/GetOut/LogoutLogic"><div class="dropdown-content" onclick="confirmSignout">Sign Out</div></a>
			</div>
	</div>
</div>

<%
	} else {
%>

<div class="header-wrapper">


	<a href="/GetOut/top"><div class="logo"><img src="/GetOut/image/logo.png"></div></a>
	<div class="nav-wrapper">
		<img id="dropbtn-icon-id" class="dropbtn-icon"
			src="/GetOut/image/hamburger.png" onclick="dropdown()">
	</div>
<div id="dropdown-wrapper-id" class="dropdown-wrapper">
		<a href="/GetOut/about"><div class="dropdown-content">What is Unmold?</div></a>
		<a href="/GetOut/signup"><div class="dropdown-content">Sign Up</div></a>
		<a href="/GetOut/login"><div class="dropdown-content" onclick="confirmSignout">Login</div></a>
	</div>
</div>

<%
	}
%>
