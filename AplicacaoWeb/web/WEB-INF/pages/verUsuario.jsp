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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seus Dados:</h1>
        <jsp:useBean id= "usuarioBean" class = "modelo.usuario.Usuario" scope="request"/>
        <div> Nome: </div>
        <div> <%= usuarioBean.getNome() %>
        <div> Login: </div>
        <div> <%= usuarioBean.getLogin() %>
        <div>Senha:</div>
        <div> <%= usuarioBean.getSenha() %>
    </body>
</html>
