<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="cmc.model.*" %>
<%@ page import="java.util.*" %>
<title>Quan ly sach</title>
</head>
<body>
   <%
      Vector<Sach> vt = (Vector<Sach>)request.getAttribute("vtsach");
   %>
        <a href="adminController?actionSH=them&action=sach">Them moi sach</a>
        <br>
        <table width="100%" border="1">
            <tr>
                <td>Ma</td>
                <td>Ten</td>
                <td>Gia</td>
                <td>Loai</td>
                <td>image</td>
                <td>So luong</td>
                <td>Noi dung</td>
                
            </tr>
            <%
            for (Sach sh : vt)
            {
            %>
             <tr>
                <td><%=sh.getMa() %></td>
                <td><%=sh.getTen() %></td>
                <td><%=sh.getGia() %></td>
                <td><%=sh.getLoai() %></td>
                <td><%=sh.getImg() %></td>
                <td><%=sh.getSoluong() %></td>
                <td><%=sh.getNoidung() %></td>
                <td><a href="adminController?action=sach&actionSH=sua&ma=<%=sh.getMa() %>">Sua</a></td>
                <td><a href="adminController?action=sach&actionSH=xoa&ma=<%=sh.getMa() %>" onclick="return confirm('Bạn có thực sự muốn xóa không?')">Xoa</a></td>
            </tr>
            <%
            }
            %>
        </table>

</body>
</html>