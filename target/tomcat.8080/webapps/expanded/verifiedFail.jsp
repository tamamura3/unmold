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

<div class="body-wrapper">
<h1>Mail address verify failed...</h1>

<div>
This happens when<br><br>
<b>You already had verified once with the e-mail link.</li></b><br>
>>Try login from <a href="/unmold/login" class="colored-link"><u>here</u></a><br><br>
<strong>The link on the e-mail from us expired.(In 24hours since sending)</strong><br>
>>Try again from <a href="/unmold/signup"><u>signup</u></a>
</div>

</div>

<jsp:include page="/actionTagFooter.jsp"/>

</body>
</html>