<%
    String mensagemSession = (String) session.getAttribute("error_message");
    session.removeAttribute("error_message");
    if (mensagemSession != null) {
%>
<div class="row">
    <div class="col s8 offset-s2 error_message">
        <div class="valign-wrapper">
            <div class="col push-s2 s10">
                <%= mensagemSession%>
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
    String mensagemSucessoSession  = (String) session.getAttribute("success_message");
    session.removeAttribute("success_message");
    if (mensagemSucessoSession != null) {
%>
<div class="row">
    <div class="col s8 offset-s2 ok_message">
        <div class="valign-wrapper">
            <div class="col push-s2 s10">
                <%= mensagemSucessoSession%>
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