<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CMC Bookstore</title>
<%@ page import="java.util.*"%>
<%@ page import="cmc.model.*"%>
<%@ page import="java.math.*"%>

<%
  String theloai = (String)request.getAttribute("loai");
  Vector<Sach> vt =  new Vector<Sach>();
  vt = (Vector<Sach>)request.getAttribute("sachlist");
  Iterator<Sach> it = vt.iterator();
  int n = Integer.parseInt(request.getAttribute("size").toString());
  int maxpage = n/6 +1 ;
%>
</head>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
	<div class="main">
		<div class="w3-content w3-display-container"
			style="margin-bottom: 25px; margin-top: 25px;">
			<img class="mySlides"
				src="${pageContext.request.contextPath}/img/book1.jpg"
				style="width: 100%" /> <img class="mySlides"
				src="${pageContext.request.contextPath}/img/book2.jpg"
				style="width: 100%" /> <img class="mySlides"
				src="${pageContext.request.contextPath}/img/book3.jpg"
				style="width: 100%" /> <img class="mySlides"
				src="${pageContext.request.contextPath}/img/book4.jpg"
				style="width: 100%" />
			<button class="w3-button w3-black w3-display-left"
				onclick="plusDivs(-1)">&#10094;</button>
			<button class="w3-button w3-black w3-display-right"
				onclick="plusDivs(1)">&#10095;</button>

		</div>
		<script>
			var slideIndex = 1;
			showDivs(slideIndex);

			function plusDivs(n) {
				showDivs(slideIndex += n);
			}

			function showDivs(n) {
				var i;
				var x = document.getElementsByClassName("mySlides");
				if (n > x.length) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = x.length
				}
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				x[slideIndex - 1].style.display = "block";
			}
		</script>
		<div class="left">
			<ul class="menu">
				<li><a href="indexController?theloai=all">Trang chu</a></li>
				<li><a href="indexController?theloai=thieunhi">Sach thieu nhi</a></li>
				<li><a href="indexController?theloai=truyen">Truyen - Tieu thuyet</a></li>
				<li><a href="indexController?theloai=kinhdoanh">Sach kinh doanh</a></li>
				<li><a href="indexController?theloai=khoahoc">Sach khoa hoc</a></li>
				<li><a href="indexController?theloai=khac">The loai khac</a></li>
				<li><a href="admin.jsp">Dang nhap Admin</a></li>
			</ul>
		</div>
		<div class="content">
			<table border="1"
				style="width: 100%; height: 600px; border-color: green;">
				
				<tr>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>

				</tr>
				<tr>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>
					<%
					  if (it.hasNext()) {
					      Sach sh = (Sach) it.next();
					%>


					<td style="text-align: center;"><img
						src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>"><br />
						<a href="Detail.jsp?sachId=<%=sh.getMa() %>"><b><%=sh.getTen()%></b></a><br /> <b>Gia:
							<%=sh.getGia()%></b><br/>
							<b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b>
							</td>
					<%
					  }
					%>
				</tr>
				<tr>
				<td colspan="3" style="text-align: center;">
				   <%
				  for (int i = 1; i <= maxpage; i++){
				   %>
				    <a href="indexController?numberpage=<%=i%>&theloai=<%= theloai %>" style="height: 40px"><%=i%></a>
				<%} %>
				</td>
				</tr>
				
			</table>
			
				
			
		</div>
		<div class="right" style="text-align: center;">
			<div style="margin-top: 20px; border: green 5px solid;">
				<form action="indexcontroller" method="post">
					<b>Tai khoan</b><br /> <input class="input" type="text"
						style="width: 180px;" /><br /> <b>Mat khau</b><br /> <input
						class="input" type="password" style="width: 180px;" /><br /> <input
						type="submit" value="Dang Nhap"
						style="border-style: double; background-color: green;"
						name="buttonIndex" />
				</form>
				<a href="Dangky.jsp">Dang ky</a>


			</div>
		</div>
		<div class="footer"
			style="text-align: center; color: purple; padding-top: 25px;">
			Cua hang sach du loai CMC BookStore. <br /> <b>Dia chi: </b>So 14
			Duy Tan, Cau Giay, Ha Noi.<br /> <b>Contact: 0123456789</b><br />
		</div>
	</div>
</body>
</html>