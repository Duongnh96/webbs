<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CMC Bookstore</title>

<%@ page import="cmc.dao.*" %>
<%@ page import="cmc.model.*" %>
<%@ page import="java.util.*" %>
</head>
<link  href = "${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" href="css.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<% 
  int id = Integer.valueOf( request.getParameter("sachId"));
  SachDao sd = new SachDao();
  Sach sh = new Sach();
  Vector<Sach> vt = sd.getSachList("select * from sach where ma ="+id);
  Iterator<Sach> it = vt.iterator();
  if(it.hasNext())sh = it.next();
%>
	<div class="main">
		<div class="w3-content w3-display-container"
			style="margin-bottom: 25px; margin-top: 25px;">
			<img class="mySlides" src="${pageContext.request.contextPath}/img/book1.jpg" style="width: 100%" />
			<img class="mySlides" src="${pageContext.request.contextPath}/img/book2.jpg" style="width: 100%" />
			<img class="mySlides" src="${pageContext.request.contextPath}/img/book3.jpg" style="width: 100%" />
			<img class="mySlides" src="${pageContext.request.contextPath}/img/book4.jpg" style="width: 100%" />
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
		<div class="left" style="text-align: center;" >
			<img  src="${pageContext.request.contextPath}/img/<%= sh.getImg()  %>" style="margin-top: 50px;" /><br/>
			<b>Ten: <%=sh.getTen() %></b><br/>
			<b>Gia: <%=sh.getGia() %></b><br/>
		</div>
		<div class="content">
			<table style="width: 100%">
			<tr >
			
			<td style="text-align: center;" colspan="3" >
			   <h1><b>Giới thiệu</b></h1>
			</td>
			</tr>
			<tr><td colspan="3"><%=sh.getNoidung() %></td></tr>
			<tr>
			<td><h1><b><a href="cartController?ma=<%=sh.getMa() %>&action=addcart" style="color: orange;">Thêm vào giỏ hàng</a></b></h1></td>
			<td></td>
			<td><h1><b><a href="indexController?theloai=all" style="color: orange;text-align: right;">Trang chủ</a></b></h1></td>
			</tr>
			</table>
		</div>
		<div class="right" style="text-align: center;">
			<div style="margin-top: 20px; border: green 5px solid;">
				<b>Tai khoan</b><br /><input class="input" type="text" style="width: 180px; "/><br />
				<b>Mat khau</b><br /><input class="input" type="password" style="width: 180px;" /><br/>
				<p>
					<input type="submit"  value="Dang Nhap" style="border-style: double; background-color: green;"/>
					
				</p>
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