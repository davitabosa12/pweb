<%-- 
    Document   : adicionarItemCarrinho
    Created on : 14/11/2018, 14:33:52
    Author     : aluno
--%>

<%@page import="modelo.produto.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar item no carrinho</title>
        <%@include file="../layout.jsp" %>
        <% Produto produto = (Produto) request.getAttribute("produto");
        %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h3>Adicionar ao carrinho</h3>
            <div class="row">
                <div class="col s6">

                    <div class="col s12">
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="./produto_imgs/<%= produto.getImgPath()%>">
                            </div>
                            <div class="card-stacked">
                                <form name="review" method="POST" action="/Ecommerce/AdicionarItemCarrinho">
                                    <div class="card-content">
                                        <div class="input-field">
                                            <label for="qtde">Quantidade:</label>
                                            <input type="number" step="1" min="1" name="quantidade" id="qtde"/>
                                        </div>
                                    </div>
                                    <div class="card-action">

                                        <input type="hidden" name="produto_id" value="<%= produto.getId()%>">

                                        <a href="#" onclick="document.review.submit()">Adicionar ao carrinho</a>


                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>
    </div>

</body>
</html>
