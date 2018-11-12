<%-- 
    Document   : alterar
    Created on : 30/09/2018, 16:41:24
    Author     : Davi
--%>

<%@page import="modelo.categoria.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../layout.jsp" %>
        <title>Alterar Categoria</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria");%>

        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Alterar Categoria</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <%@include file="../message.jsp" %>
                    <form action="AlterarCategoriaServlet" method="post">
                        <label for="name">Descrição</label>
                        <input type="text" name="descricao" id="desc" value="<%= categoria.getDescricao() %>"/>
                        <input type="hidden" name="id" id="id" value="<%= categoria.getId() %>"/>
                        <input class="btn waves-button-input"type="submit" value="Alterar"/>
                    </form>
                </div>
            </div>
    </body>
</html>
