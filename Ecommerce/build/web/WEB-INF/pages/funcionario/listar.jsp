<%-- 
    Document   : listar
    Created on : 30/09/2018, 14:30:08
    Author     : Davi
--%>

<%@page import="modelo.funcionario.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionarios</title>
        <%@include file="../layout.jsp" %>
    </head>
    <body>

        <%@include file="../navbar.jsp" %>
        <% List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("lista_funcionarios"); %>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Lista de Funcionarios</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <table>
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Login</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Funcionario f : funcionarios) {
                            %>
                            <tr>
                                <td><%= f.getNome()%></td>
                                <td><%= f.getLogin()%></td>
                                <td><a class="btn-flat waves-effect waves-red" href="ObterFuncionarioServlet?login=<%= f.getLogin()%>" >Alterar</a> &nbsp; <a class="btn-flat waves-effect waves-red" href="ExcluirFuncionarioServlet?login=<%= f.getLogin()%>" >Excluir</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="fixed-action-btn">
                <a class="btn-floating btn-large red tooltipped" data-position="left" data-tooltip="Novo Funcionário" href="NovoFuncionarioServlet">
                    <i class="large material-icons">add</i>
                </a>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('.tooltipped').tooltip();
            });
        </script>
    </body>
</html>
