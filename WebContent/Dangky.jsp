<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dang ky</title>
<link href="${pageContext.request.contextPath}/css/dangky.css"
	rel="stylesheet" type="text/css" href="css.css"/>
</head>
<body>
	<form id="contactform" name="contact" method="post" action="#">

		<div class="row">
			<label for="name">Your Name <span class="req">*</span></label> <input
				type="text" name="name" id="name" class="txt" tabindex="1"
				placeholder="Steve Jobs" required>
		</div>

		<div class="row">
			<label for="email">E-mail Address <span class="req">*</span></label>
			<input type="email" name="email" id="email" class="txt" tabindex="2"
				placeholder="address@domain.com" required>
		</div>

		<div class="row">
			<label for="subject">Password <span class="req">*</span></label> <input
				type="password" name="subject" id="subject" class="txt" tabindex="3"
				placeholder="Mat khau" required>
		</div>

		
		<div class="center">
			<input type="submit" id="submitbtn" name="submitbtn" tabindex="5"
				value="Dang ky">
		</div>
	</form>
</body>
</html>