<%-- 
    Document   : mostrarVendasUsuario
    Created on : 20/11/2018, 22:30:45
    Author     : Davi
--%>

<%@page import="modelo.venda.Venda"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Vendas</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <% List<Venda> vendas = (List<Venda>) request.getAttribute("vendas"); %>
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
                                <th>ID</th>
                                <th>Total Compra</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <% 
                            for(Venda v : vendas){ 
                        %>
                            <tr>
                                <td><%= v.getId()%></td>
                                <td>R$ <%= v.getGrandeTotal()%></td>
                                <td><a class="btn-flat waves-effect waves-red" href="VerDetalhesVenda?venda_id=<%= v.getId()%>" >Ver detalhes</a> </td>
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
