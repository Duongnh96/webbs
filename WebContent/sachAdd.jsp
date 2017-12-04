<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Them Sach Moi</title>
<%@ page import="cmc.dao.*"%>
<%@ page import="cmc.model.*"%>
<%@ page import="java.util.*"%>
</head>
<script type="text/javascript">
   function ValidateForm(){
	   var gia = document.getElementById("gia").value;
	   var soluong = document.getElementById("soluong").value;
	   var regex = /^[1-9]+[0-9]*/;
	   if(!regex.test(gia)){
		   alert('Gia khong hop le. nhap lai');
		   return false;
	   }
	   if(!regex.test(soluong)){
		   alert('So luong khong hop le');
		   return false;
	   }
	   return true;
   }
</script>
<body>
	<%
		LoaiDao ld = new LoaiDao();
		Vector<Loai> vt = ld.getLoaiList("select * from loai");
	%>
	<form style="width: 90%"  method="post" onsubmit="return ValidateForm()">

		Ten <input style="width: 80%" type="text" name="txtTen" /> <br />
		Gia <input style="width: 80%" type="text" name="txtGia" id ="gia"><br />

		<fieldset>
			<legend>Loai sach</legend>
			<%
				for (Loai l : vt) {
			%>
			<input type="radio" name="rdoLoai" value="<%=l.getMa()%>" checked="checked">
			<%=l.getTen()%>
			<%
				}
			%>
		</fieldset>
		Image<input type="text" style="width: 80%" name="txtImg" /> <br/>
		Soluong<input type="text"  name="txtSoLuong" id ="soluong"/><br>
		Noidung<textarea rows="5" cols="100" placeholder="Gioi thieu so luoc ve sach" name="txtNoiDung"></textarea><br/>
		<input type="submit" value="Insert" name="btnInsert"/>
	</form>
</body>
</html>