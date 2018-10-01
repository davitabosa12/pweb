<%-- 
    Document   : novaCategoria
    Created on : 30/09/2018, 16:41:38
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../layout.jsp" %>
        <title>Nova Categoria</title>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h4>Nova Categoria</h4>
            <div class="row">
                <%@include file="../message.jsp" %>
            </div>
            <div class="row">
                <form action="InserirCategoriaServlet" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="desc">Descrição</label>
                            <input type="text" name="descricao" id="desc"/>
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
    </body>
</html>
