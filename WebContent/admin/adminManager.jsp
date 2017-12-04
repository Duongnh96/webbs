<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trang admin</title>
</head>
<body>
	<%
				String email = (String)session.getAttribute("email");
			%>
			Xin chào quản trị viên: <%=email %>
	<div
		style="background-color: buttonface; margin-bottom: 30px; text-align: center">Trang
		Admin</div>
	<table width="100%" border="1">
		<tr>
			<td><a href="adminController?action=sach">Quan ly sach</a></td>
			<td><a href="adminController?action=hoadon">Quan ly hoa don</a></td>
			<td><a href="adminController?action=hoadonchitiet">Chi tiet hoa don</a></td>
			<td><a href="adminController?action=loai">The loai sach</a></td>
			<td><a href="adminController?action=khachhang">Quan ly khach hang</a></td>


		</tr>
	</table>

</body>
</html>