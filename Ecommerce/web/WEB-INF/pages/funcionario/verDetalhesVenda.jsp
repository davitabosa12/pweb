<%-- 
    Document   : verDetalhesVenda
    Created on : 20/11/2018, 22:41:00
    Author     : Davi
--%>

<%@page import="modelo.venda.ProdutoVenda"%>
<%@page import="modelo.venda.Venda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <<head>
        <%@include file="../layout.jsp" %>
        <title>Ver detalhes da venda</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <% Venda venda = (Venda) request.getAttribute("venda");%>

        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Ver detalhes da venda</h4>
                </div>
            </div>
            <div class="row">

                <div class="col s8">
                    <%@include file="../message.jsp" %>

                    <table>
                        <thead>
                            <tr>
                                <th>Nome Produto</th>
                                <th>Preço Praticado</th>
                                <th>Quantidade</th>
                                <th>Sub-total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <% 
                            for(ProdutoVenda pv : venda.getProdutos()){ 
                        %>
                            <tr>
                                <td><%= pv.getProduto().getDescricao()  %></td>
                                <td>R$ <%= pv.getPrecoUnitario() %></td>
                                <td><%= pv.getQuantidade() %></td>
                                <td>R$ <%= pv.getPrecoUnitario() * pv.getQuantidade() %></td>
                                <td><a class="btn-flat waves-effect waves-red" href="ObterProdutoServlet?id=<%= pv.getProduto().getId()%>" >Ver Produto</a></td>
                            </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                        <h3>Total da venda: R$<strong><%= venda.getGrandeTotal() %></strong></h3>
                </div>
            </div>
    </body>
</html>
