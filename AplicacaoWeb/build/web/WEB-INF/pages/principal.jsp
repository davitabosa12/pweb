<%-- 
    Document   : main
    Created on : 12/09/2018, 15:35:24
    Author     : leoomoreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String login = (String) session.getAttribute("login");
    if (login != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
    </head>
    <body>
        <h1>Olá, <%= login %>!</h1>
        <div><a href="VerUsuarioServlet">Meus Dados</a></div>
        <div><a href="LogoutServlet">Sair</a></div>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>