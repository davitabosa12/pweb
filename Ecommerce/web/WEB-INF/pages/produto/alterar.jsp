<%-- 
    Document   : alterar
    Created on : 30/09/2018, 16:41:24
    Author     : Davi
--%>

<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="modelo.produto.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../layout.jsp" %>
        <title>Alterar Produto</title>
    </head>
    <body>
        <%
            List<Categoria> categorias = new CategoriaDAO().obterTodos();
        %>
        <%@include file="../navbar.jsp" %>
        <% Produto produto = (Produto) request.getAttribute("produto");%>

        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h4>Alterar Produto</h4>
                </div>
            </div>
            <div class="row">
                <div class="col s8">
                    <%@include file="../message.jsp" %>
                    <form action="AlterarProdutoServlet" method="post">
                        <label for="preco">Descrição</label>
                        <input type="text" name="descricao" id="desc" value="<%= produto.getDescricao()%>"/>
                        <label for="preco">Preço</label>
                        <input type="text" name="preco" id="preco" value="<%= produto.getPreco()%>"/>
                        <select name="categoria_id">
                            <%
                                for (Categoria c : categorias) {
                            %>
                            <option value="<%= c.getId()%>"><%=c.getDescricao()%></option>
                            <%
                                }
                            %>
                        </select>
                        <input type="hidden" name="id" id="id" value="<%= produto.getId()%>"/>
                        <input class="btn waves-button-input"type="submit" value="Alterar"/>
                    </form>
                </div>
            </div>
                        <script type="text/javascript">
                        
                            $('select').formSelect();
                        
                            var select = document.getElementsByName("categoria")[0];
                            select.value = <%= produto.getCategoriaId() %>;
                        </script>
    </body>
</html>
