<%-- 
    Document   : novaProduto
    Created on : 30/09/2018, 16:41:38
    Author     : Davi
--%>

<%@page import="modelo.categoria.CategoriaDAO"%>
<%@page import="modelo.categoria.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Nova Produto</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <%
            List<Categoria> categorias = new CategoriaDAO().obterTodos();
        %>
        <div class="container">
            <h4>Novo Produto</h4>
            <div class="row">
                <%@include file="../message.jsp" %>
            </div>
            <div class="row">
                <form action="InserirProdutoServlet" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="desc">Descrição</label>
                            <input type="text" name="descricao" id="desc"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="preco">Preço</label>
                            <input type="text" name="preco" id="preco"/>
                        </div>
                    </div>   
                    <div class="row">
                        <div class="input-field col s12">
                            
                            <select name="categoria_id">
                            <%
                                for (Categoria c : categorias) {
                            %>
                                <option value="<%= c.getId()%>"><%=c.getDescricao()%></option>
                            <%
                                }
                            %>
                            <label for="categoria_id">Categoria</label>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s3">
                            <input type="submit" class="btn waves-button-input" value="Cadastrar"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
                            <script type="text/javascript">
                                $('select').formSelect();
                            </script>
    </body>
</html>
