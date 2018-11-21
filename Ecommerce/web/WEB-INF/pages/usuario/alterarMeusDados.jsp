<%-- 
    Document   : alterar
    Created on : 30/09/2018, 11:14:50
    Author     : Davi
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../layout.jsp" %>
        <title>Alterar Usuário</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        
        <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
        
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Alterar Usuário</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <%@include file="../message.jsp" %>
                    <form action="AlterarDadosServlet" method="post">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name" value="<%= usuario.getNome()%>"/>
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" value="<%= usuario.getLogin()%>"readonly="readonly"/>
                        <label for="senha">Senha</label>
                        <input type="password" name="senha" id="senha" value="<%= usuario.getSenha()%>"/>
                        <input class="btn waves-button-input"type="submit" value="Alterar"/>
                    </form>
                </div>
            </div>
            
        </div>
    </body>
</html>
