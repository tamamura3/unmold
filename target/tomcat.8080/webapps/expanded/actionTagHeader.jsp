
<%@ page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@ page import="net.unmold.beans.User"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
	User user = (User) session.getAttribute("loggedIn");
%>
<%
	if (user != null) {
%>

<div class="header-wrapper">

	<a href="/unmold/top"><div class="logo">
			<img src="/unmold/image/logo.png">
		</div></a>
	<div class="nav-wrapper">
		Hello, <a href="/unmold/MyPageLogic"><div class="hello-name">
				<%=StringEscapeUtils.escapeHtml(user.getName())%>
			</div></a>
		<img id="dropbtn-icon-id" class="dropbtn-icon"
			src="/unmold/image/hamburger.png" onclick="dropdown()">
			<div id="dropdown-wrapper-id" class="dropdown-wrapper">
				<a href="/unmold/about.jsp"><div class="dropdown-content">What is Unmold?</div></a>
				<a href="/unmold/MyPageLogic"><div class="dropdown-content">My Page</div></a>
				<a href="/unmold/LogoutLogic"><div class="dropdown-content" onclick="confirmSignout">Sign Out</div></a>
			</div>
	</div>
</div>

<%
	} else {
%>

<div class="header-wrapper">


	<a href="/unmold/top"><div class="logo"><img src="/unmold/image/logo.png"></div></a>
	<div class="nav-wrapper">
		<img id="dropbtn-icon-id" class="dropbtn-icon"
			src="/unmold/image/hamburger.png" onclick="dropdown()">
	</div>
<div id="dropdown-wrapper-id" class="dropdown-wrapper">
		<a href="/unmold/about"><div class="dropdown-content">What is Unmold?</div></a>
		<a href="/unmold/signup"><div class="dropdown-content">Sign Up</div></a>
		<a href="/unmold/login"><div class="dropdown-content" onclick="confirmSignout">Login</div></a>
	</div>
</div>

<%
	}
%>
