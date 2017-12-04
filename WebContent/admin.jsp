<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function ValidateEmail() {
		var email = document.getElementById("email").value;
		var regexEmail = /^[0-9A-Za-z]+[0-9A-Za-z_]*@[\w\d.]+.\w{2,4}$/;
		if (!regexEmail.test(email)) {
			alert('Email khong hop le. Vui long nhap lai!');
			return false;
		}
		return true;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<%
		if ((request.getAttribute("login") != null) && request.getAttribute("login").equals("fail")) {
	%>
	<script type="text/javascript">
		alert("Ten dang nhap hoac mat khau khong dung");
	</script>
	<%
		}
	%>
	<form action="AdminLogin" onsubmit="return ValidateEmail()"
		method="post">
		Email  <input type="text" name="txtEmail" id="email" /><br /> 
		Pass   <input
			type="password" name="txtPass" id="password" /><br /> <input
			type="submit" value="Dang nhap" /> <b><a href="indexController">Quay
				ve trang chu</a></b>
	</form>

</body>
</html>