<%-- 
    Document   : cadastroFuncionario
    Created on : 22/09/2018, 20:58:09
    Author     : Davi
--%>
<%
    String login = (String) session.getAttribute("login");
    if (login != null) {

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/inputcolor.css" type="text/css" rel="stylesheet" />
        <link href="css/customcomponent.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/materialize.js"></script>
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <%@include file="/WEB-INF/pages/navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col s12 center">
                    <h4>Novo Funcionario</h4>
                </div>
            </div>
            <%  String mensagem = (String) request.getAttribute("error_message");
                if (mensagem != null) {
            %>
            <div class="row">
                <div class="col s8 offset-s2 error_message">
                    <div class="valign-wrapper">
                        <div class="col push-s2 s10">
                            <%= mensagem%>
                        </div>
                        <div class="col s2 pull-s10">
                            <i class="material-icons small" style="margin-top: 2px">ok</i>
                        </div>
                    </div>
                </div>
            </div>

            <%
                }
            %>
            <%
                        String confirmacao = (String) request.getAttribute("toast_message");
                        if (confirmacao != null) {
                    %>
                    <div class="row">
                        <div class="col s8 offset-s2 ok_message">
                            <div class="valign-wrapper">
                                <div class="col push-s2 s10">
                                    <%= confirmacao%>
                                </div>
                                <div class="col s2 pull-s10">
                                    <i class="material-icons small" style="margin-top: 2px">warning</i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%
                        }
                    %>
            <div class="row">
                <form action="NovoFuncionarioServlet" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="nome">Nome</label>
                            <input type="text" name="nome" id="nome"/>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="salario">Salario</label>
                            <input type="number" name="salario" id="salario"/>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="login">Login</label>
                            <input type="text" name="login" id="login"/>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="senha">Senha</label>
                            <input type="password" name="senha" id="senha"/>
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
<%
    } else {
        request.setAttribute("error_message", "Você não possui um login válido");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>