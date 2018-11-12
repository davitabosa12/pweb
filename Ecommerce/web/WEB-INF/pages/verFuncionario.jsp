<%-- 
    Document   : verFuncionario
    Created on : 04/11/2018, 12:32:32
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="layout.jsp" %>
        <title>Dados de Funcionario</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <h4>Seus Dados:</h4>
            <jsp:useBean id= "funcionarioBean" class = "modelo.funcionario.Funcionario" scope="session"/>
            <div> Nome: </div>
            <div> <%= funcionarioBean.getNome() %> </div>
            <div> Login: </div>
            <div> <%= funcionarioBean.getLogin() %> </div>
            <div>Senha:</div>
            <div> <%= funcionarioBean.getSenha() %> </div>
            <a href="PrincipalServlet">Voltar</a>
                
        </div>
    </body>
</html>
