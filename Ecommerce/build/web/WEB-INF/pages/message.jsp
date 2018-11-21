<%-- 
    Document   : message
    Created on : 30/09/2018, 13:57:22
    Author     : Davi
    JSP que trata mensagens de erro e sucesso
--%>

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

<%
    String mensagemSucesso  = (String) request.getAttribute("success_message");
    if (mensagemSucesso != null) {
%>
<div class="row">
    <div class="col s8 offset-s2 ok_message">
        <div class="valign-wrapper">
            <div class="col push-s2 s10">
                <%= mensagemSucesso%>
            </div>
            <div class="col s2 pull-s10">
                <i class="material-icons small" style="margin-top: 2px">done</i>
            </div>
        </div>
    </div>
</div>

<%
    }
%>