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
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/inputcolor.css" type="text/css" rel="stylesheet" />
        <link href="css/customcomponent.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/materialize.js"></script>
        <title>Página Principal</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <jsp:useBean id= "usuarioBean" class = "modelo.usuario.Usuario" scope="session"/>
        <div class="container">
            <h4>Olá, <%= usuarioBean.getNome() %>!</h4>
            <div><a href="VerUsuarioServlet">Meus Dados</a></div>
            <div><a href="">Cadastro de Funcionário</a></div>
            <div><a href="">Cadastro de Produto</a></div>
            <div><a href="">Cadastro de Categoria</a></div>
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