<%
	request.getSession().removeAttribute("func");
	request.getSession().invalidate();
	response.sendRedirect("index.jsp");
%>