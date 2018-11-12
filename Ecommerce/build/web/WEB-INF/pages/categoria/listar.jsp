<%-- 
    Document   : listar
    Created on : 30/09/2018, 16:41:31
    Author     : Davi
--%>

<%@page import="modelo.categoria.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categorias</title>
        <%@include file="../layout.jsp" %>
    </head>
    <body>

        <%@include file="../navbar.jsp" %>
        <% List<Categoria> categorias = (List<Categoria>) request.getAttribute("lista_categorias"); %>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Lista de Categorias</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descrição</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Categoria categoria : categorias) {
                            %>
                            <tr>
                                <td><%= categoria.getId()%></td>
                                <td><%= categoria.getDescricao()%></td>
                                <td><a class="btn-flat waves-effect waves-red" href="ObterCategoriaServlet?id=<%= categoria.getId()%>" >Alterar</a> &nbsp; <a class="btn-flat waves-effect waves-red" href="ExcluirCategoriaServlet?id=<%= categoria.getId()%>" >Excluir</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="fixed-action-btn">
                <a class="btn-floating btn-large red tooltipped" data-position="left" data-tooltip="Nova Categoria" href="NovaCategoriaServlet">
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
