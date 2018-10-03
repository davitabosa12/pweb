<%-- 
    Document   : verUsuario
    Created on : 19/09/2018, 14:49:07
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="layout.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <h4>Seus Dados:</h4>
            <jsp:useBean id= "usuarioBean" class = "modelo.usuario.Usuario" scope="session"/>
            <div> Nome: </div>
            <div> <%= usuarioBean.getNome() %> </div>
            <div> Login: </div>
            <div> <%= usuarioBean.getLogin() %> </div>
            <div>Senha:</div>
            <div> <%= usuarioBean.getSenha() %> </div>
            <a href="PrincipalServlet">Voltar</a>
                
        </div>
        
    </body>
</html>
