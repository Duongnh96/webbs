<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quan ly the loai</title>
<%@ page import="java.util.*" %>
<%@ page import="cmc.model.*" %>
<%@ page import="cmc.dao.*" %>
</head>
<body>
   <%
      Vector<Loai> vt = (Vector<Loai>)request.getAttribute("vtloai");
   %>
   <b><a href="adminController?actionL=them&action=loai">Them moi the loai</a></b>
        <br>
        <table width = "100%" border="1">
            <tr>
                <td>Ma</td>
                <td>Ten</td>
                <td>Mo ta</td>
                
                
            </tr>
            <%
            for (Loai l : vt)
            {
            %>
             <tr>
                <td><%=l.getMa() %></td>
                <td><%=l.getTen() %></td>
                <td><%=l.getMota() %></td>
                
                <td><a href="adminController?action=loai&actionL=sua&ma=<%=l.getMa() %>">Sua</a></td>
                <td><a href="adminController?action=loai&actionL=xoa&ma=<%=l.getMa() %>" onclick="return confirm('Bạn có thực sự muốn xóa không?')">Xoa</a></td>
            </tr>
            <%
            }
            %>
        </table>
</body>
</html>