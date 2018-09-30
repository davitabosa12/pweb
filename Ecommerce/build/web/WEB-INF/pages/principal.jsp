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
        <%@include file="layout.jsp" %>
        <title>Página Principal</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <jsp:useBean id= "usuarioBean" class = "modelo.usuario.Usuario" scope="session"/>
        <div class="container">
            <h4>Olá, <%= usuarioBean.getNome() %>!</h4>
            <div><a href="VerUsuarioServlet">Meus Dados</a></div>
            <div><a href="ListarUsuarioServlet">Ver Usuários</a></div>
            <div><a href="ListarFuncionarioServlet">Ver Funcionários</a></div>
            <div><a href="ListarProdutoServlet">Ver Produtos</a></div>
            <div><a href="ListarCategoriaServlet">Ver Categoria</a></div>
            <div><a href="LogoutServlet">Sair</a></div>
        </div>
        
        
    </body>
</html>
<%
    } else {
        request.setAttribute("error_message", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
%>