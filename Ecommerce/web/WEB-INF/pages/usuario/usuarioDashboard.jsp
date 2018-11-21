<%-- 
    Document   : usuarioDashboard.jsp
    Created on : 20/11/2018, 23:03:07
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel de Controle</title>
        <%@include file="../layout.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <jsp:useBean id= "usuarioBean" class = "modelo.usuario.Usuario" scope="session"/>
        <jsp:useBean id= "funcionarioBean" class= "modelo.funcionario.Funcionario" scope="session"/>
        <div class="container">
            <%@include file="../message.jsp" %>
            <%@include file="../session_message.jsp" %>
            <h4>Olá, <%= usuarioBean.getNome() %>!</h4>
            <div><a href="MeusDadosServlet">Meus Dados</a></div>
            <div><a href="MinhasCompras">Minhas Compras</a></div>
            <div><a href="AlterarMeusDados">Alterar meus dados</a></div>
            <div><a href="../LogoutServlet">Sair</a></div>
        </div>
        
        
    </body>
</html>
