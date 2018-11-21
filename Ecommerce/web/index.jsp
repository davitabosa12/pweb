<%-- 
    Document   : index
    Created on : 12/09/2018, 15:28:30
    Author     : leoomoreira
--%>

<%@page import="modelo.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page import="modelo.produto.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bem-vindo ao Ecommerce</title>
        <meta charset="UTF-8">
        <%@include file="WEB-INF/pages/layout.jsp" %>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="js/materialize.js"></script>
    </head>
    <body>
        
        <% ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.obterVarios(9);
        %>
        <%@include file="WEB-INF/pages/navbar.jsp" %>
        <section class="container">
            <%@include file="WEB-INF/pages/message.jsp" %>
            <%@include file="WEB-INF/pages/session_message.jsp" %>
            <h3 class="center">Bem-vindo</h3>
            <div class="row"id="produtos">
                <% for (Produto p : produtos) {%>

                <div class="col s12 m6 l4">
                    <div class="card">
                        <div class="card-image">
                            <img src="produto_imgs/<%= p.getImgPath()%>" class="responsive-img" height="100px">
                            <span class="card-title"><%= p.getDescricao()%></span>
                        </div>
                        <div class="card-content">
                            <p>R$ <%= p.getPreco()%></p>
                        </div>
                        <div class="card-action">
                            <a href="/Ecommerce/ConfirmarItemCarrinho?produto_id=<%= p.getId()%>"
                               >Comprar</a>
                        </div>
                    </div>
                </div>

                <% }%>
            </div>
        </section>
    </body>
</html>
