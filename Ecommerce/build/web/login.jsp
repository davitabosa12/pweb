<%-- 
    Document   : login
    Created on : 22/09/2018, 14:01:19
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página de Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.css" type="text/css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/inputcolor.css" type="text/css" rel="stylesheet" />
        <link href="css/customcomponent.css" type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="js/materialize.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="valign-wrapper">
                <div class="row">
                    <div class="row">
                        <div class="col s12">
                            <h4>Identificação do Usuário</h4>
                        </div>
                    </div>

                    <%
                        String mensagem = (String) request.getAttribute("error_message");
                        if (mensagem != null) {
                    %>
                    <div class="row">
                        <div class="col s8 offset-s2 error_message">
                            <div class="valign-wrapper">
                                <div class="col push-s2 s10">
                                    <%= mensagem%>
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
                        <form action="LoginServlet" method="post" class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="login">Login</label>
                                    <input type="text" name="login"  id="login" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="senha">Senha</label>
                                    <input type="password" name="senha" id="senha" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s3">
                                    <input class="btn waves-button-input" type="submit" value="Entrar" />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="row">
                        <div class="col s12"> 
                            <a href="novoUsuario.jsp">Criar novo usuário</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12"> 
                            <a href="index.jsp">Voltar à página inicial</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12"> 
                            <a href="loginFuncionario.jsp">Login como Funcionário</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
