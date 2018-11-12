<%-- 
    Document   : listar
    Created on : 30/09/2018, 11:14:58
    Author     : Davi
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Listagem de Usuários</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("lista_usuarios"); %>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Lista de Usuários</h4>
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
                            for(Usuario u : usuarios){ 
                        %>
                            <tr>
                                <td><%= u.getNome()%></td>
                                <td><%= u.getLogin()%></td>
                                <td><a class="btn-flat waves-effect waves-red" href="ObterUsuarioServlet?login=<%= u.getLogin()%>" >Alterar</a> &nbsp; <a class="btn-flat waves-effect waves-red" href="ExcluirUsuarioServlet?login=<%= u.getLogin()%>" >Excluir</a></td>
                            </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
            
        </div>
    </body>
</html>
