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
                <form action="InserirProdutoServlet" method="post" enctype="multipart/form-data" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="desc">Descrição</label>
                            <input type="text" name="descricao" id="desc"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="preco">Preço</label>
                            <input type="number" step="0.01" name="preco" id="preco"/>
                        </div>
                    </div>   
                    <div class="row">
                        <div class="input-field col s12">

                            <select name="categoria_id">
                                <% for (Categoria c : categorias) {
                                %>
                                <option value="<%= c.getId()%>"><%=c.getDescricao()%></option>
                                <%
                                    }
                                %>
                                <label for="categoria_id">Categoria</label>
                            </select>
                        </div>
                        <div class="file-field input-field">
                            <div class="btn">
                                <span>File</span>
                                <input type="file" name="imagem" id="imagem">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
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
