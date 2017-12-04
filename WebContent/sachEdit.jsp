<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ page import="cmc.model.*" %>
<%@ page import="cmc.dao.*" %>
<%@ page import="java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sua Sach</title>
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
            Sach sh = (Sach) request.getAttribute("sach");
      
		     LoaiDao ld = new LoaiDao();
		     Vector<Loai> vt = ld.getLoaiList("select * from loai");
	
        %>
        <form method="post"  onsubmit="return ValidateForm()" >
            Ma<input type="text" style="width: 80%" name="txtMa" readonly="readonly" value="<%=sh.getMa() %>"/>
            <br/>
            Ten<input type="text" style="width: 80%" name="txtTen" value="<%=sh.getTen() %>"/>
            <br/>
            Gia<input type="text" style="width: 80%" name="txtGia" value="<%=sh.getGia() %>" id="gia"/>
            <br/>
           <fieldset>
			<legend>Loai sach</legend>
			<%
				for (Loai l : vt) {
					if(l.getMa() == sh.getLoai()){
			%>
			<input type="radio" name="rdoLoai" value="<%=l.getMa()%>" checked="checked">
			<%=l.getTen()%>
			<%
			   continue;
			} %>
			<input type="radio" name="rdoLoai" value="<%=l.getMa()%>"><%=l.getTen()%>
			<%
				}
			%>
		</fieldset><br/>
            Image<input type="text" style="width: 80%" name="txtImg" value="<%=sh.getImg() %>" /> <br/>
            <br/>
            So luong <input type="text" name="txtSoLuong" value="<%=sh.getSoluong() %>" id="soluong" />
            <br/>
            Noidung<textarea rows="10" cols="150"  name="txtNoiDung" ><%=sh.getNoidung() %></textarea><br/>
		
           
            <input type="submit" value="Update" name="btnUpdate"/>
        </form>
    </body>
</html>