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
        <% Usuario u = (Usuario) request.getAttribute("usuario"); %>
        
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h1>Alterar Usuário</h1>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <%@include file="../message.jsp" %>
                    <form action="AlterarUsuarioServlet">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name" value="<%= u.getNome()%>"/>
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" value="<%= u.getLogin()%>"readonly="readonly"/>
                        <label for="senha">Senha</label>
                        <input type="password" name="senha" id="senha" value="<%= u.getSenha()%>"/>
                        <input class="btn waves-button-input"type="submit" value="Alterar"/>
                    </form>
                </div>
            </div>
            
        </div>
    </body>
</html>
