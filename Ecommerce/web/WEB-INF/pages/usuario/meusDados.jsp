<%-- 
    Document   : meusDados
    Created on : 20/11/2018, 22:58:01
    Author     : Davi
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Meus Dados</title>
        <% Usuario u = (Usuario) request.getAttribute("usuario"); %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h4>Seus Dados:</h4>
            <div> Nome: </div>
            <div> <%= u.getNome() %> </div>
            <div> Login: </div>
            <div> <%= u.getLogin() %> </div>
            <div>Senha:</div>
            <div> <%= u.getSenha() %> </div>
            <a href="/Ecommerce">Voltar</a>
                
        </div>
        
    </body>
</html>
