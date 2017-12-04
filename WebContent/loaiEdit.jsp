<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="cmc.model.*" %>
<body>
   <%
            Loai l = (Loai) request.getAttribute("loai");
      
		    
        %>
        <form method="post"   >
            Ma<input type="text" style="width: 80%" name="txtMa" readonly="readonly" value="<%=l.getMa() %>"/>
            <br/>
            Ten<input type="text" style="width: 80%" name="txtTen" value="<%=l.getTen() %>"/>
            <br/>
            Mo ta<input type="text" style="width: 80%" name="txtMoTa" value="<%=l.getMota() %>" />
            <br/>
            <input type="submit" value="Update" name="btnUpdate"/>
        </form>

</body>
</html>