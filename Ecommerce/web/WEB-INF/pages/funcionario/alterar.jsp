<%-- 
    Document   : alterar
    Created on : 30/09/2018, 14:29:59
    Author     : Davi
--%>

<%@page import="modelo.funcionario.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../layout.jsp" %>
        <title>Alterar Funcionario</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <% Funcionario f = (Funcionario) request.getAttribute("funcionario");%>

        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Alterar Funcionario</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <%@include file="../message.jsp" %>
                    <form action="AlterarFuncionarioServlet" method="get">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name" value="<%= f.getNome()%>"/>
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" value="<%= f.getLogin()%>"readonly="readonly"/>
                        <label for="senha">Senha</label>
                        <input type="password" name="senha" id="senha" value="<%= f.getSenha()%>"/>
                        <label for="salario">Salário</label>
                        <input type="number" name="salario" id="salario" value="<%= f.getSalario()%>"/>
                        <input class="btn waves-button-input"type="submit" value="Alterar"/>
                    </form>
                </div>
            </div>
    </body>
</html>
