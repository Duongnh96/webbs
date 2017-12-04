<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ hàng</title>
<%@ page import="cmc.model.*" %>
<%@ page import="java.util.*" %>
</head>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css" />
<body>
<%
   if(session.getAttribute("change")!=null){%>
      <script type="text/javascript">
        alert('Da thay doi')
      </script>
   <%
   }
%>
<script type="text/javascript">
  function validateSoLuong(){
	  var soluong = document.getElementById("soluong").value;
	  var regex = /^[1-9]+[0-9]*/;
	  if(!regex.test(soluong)){
		  alert('So luong khong hop le');
		  return false;
	  }
	  return true;
  }
</script>
  <table style="width: 80%;border: 1px green solid ; ">
            <tr>
                <td class="center">Ma</td>
                <td class="center">Ten</td>
                <td class="center">Bia sach</td>
                <td class="center">Gia</td>
                <td class="center">So Luong</td>
                <td></td>
                
            </tr>
            <%
            if(session.getAttribute("cart")!=null)
            {
                Cart cart = (Cart)session.getAttribute("cart");
                Vector<CartSach> vtSach= cart.getVtSach();
                for(CartSach item:vtSach)
                {            
            %>
            
             <tr>
                
                <td class="center"><%=item.getSh().getMa() %></td>
                <td class="center"><%=item.getSh().getTen()%></td>
                <td class="center"><img
						src="${pageContext.request.contextPath}/img/<%=item.getSh().getImg()  %>"></td>
                <td class="center"><%=item.getSh().getGia()%></td>
                <td class="center"><input type="text" value="<%=item.getSoluong() %>" name ="txtSoLuong" id="soluong"> </td>
                <td class="center"><a href="cartController?action=deletecartitem&ma=<%=item.getSh().getMa() %>">Xoa</a> </td>
                
            </tr>
            
            <%
                }
            }
            %>
            <tr>
            <td colspan="3" class="center"><a href="indexController?theloai=all">Quay ve trang chu</a></td>
            <td colspan="3" class="center"><a href="">Dat hang</a></td>
            </tr>
        </table>
</body>
</html>