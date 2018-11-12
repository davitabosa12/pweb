<%-- 
    Document   : listar
    Created on : 30/09/2018, 16:41:31
    Author     : Davi
--%>

<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        <%@include file="../layout.jsp" %>
    </head>
    <body>

        <%@include file="../navbar.jsp" %>
        <% List<Produto> produtos = (List<Produto>) request.getAttribute("lista_produtos"); 
           CategoriaDAO categoriaDao = new CategoriaDAO();
           Categoria c;
        %>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Lista de Produtos</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descrição</th>
                                <th>Preço</th>
                                <th>Categoria</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Produto produto : produtos) {
                            %>
                            <tr>
                                <td><%= produto.getId()%></td>
                                <td><%= produto.getDescricao()%></td>
                                <td><%= produto.getPreco()%></td>
                                <% c = categoriaDao.obter(produto.getCategoriaId()); %>
                                <td><%= c.getDescricao()%></td>
                                <td><a class="btn-flat waves-effect waves-red" href="ObterProdutoServlet?id=<%= produto.getId()%>" >Alterar</a> &nbsp; <a class="btn-flat waves-effect waves-red" href="ExcluirProdutoServlet?id=<%= produto.getId()%>" >Excluir</a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="fixed-action-btn">
                <a class="btn-floating btn-large red tooltipped" data-position="left" data-tooltip="Novo Produto" href="NovoProdutoServlet">
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
