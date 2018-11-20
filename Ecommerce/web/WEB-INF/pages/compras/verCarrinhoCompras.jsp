<%-- 
    Document   : verCarrinhoCompras
    Created on : 14/11/2018, 15:41:14
    Author     : aluno
--%>

<%@page import="modelo.carrinho.CarrinhoComprasItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<CarrinhoComprasItem> itens = (List<CarrinhoComprasItem>) request.getAttribute("lista_produtos");
   %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Carrinho de Compras</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h3>Carrinho de compras</h3>
            <table>
                <thead>
                    <tr>
                        <th>Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Unitário</th>
                        <th>Valor Total</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (CarrinhoComprasItem item : itens) { %>
                    <tr>
                        
                        <td><%= item.getProduto().getDescricao()%></td>
                        <td><%= item.getQuantidade() %></td>
                        <td><%= item.getProduto().getPreco() %></td>
                        <td><%= item.getProduto().getPreco() * item.getQuantidade() %></td>
                        
                    </tr>
                    <% }%>

                </tbody>
            </table>
                    <a href="/Ecommerce/usuario/FinalizarVendaServlet" class="btn">Finalizar Compras</a>        </div>

    </body>
</html>
