<%-- 
    Document   : navbar
    Created on : 22/09/2018, 14:28:15
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
    <div class="nav-wrapper materialize-red">
        <% String userType = (String) session.getAttribute("userType");
            String userLogin = (String) session.getAttribute("login");
        %>
        <%if (session.getAttribute("login") == null) {%>
        <a href="/Ecommerce" class="brand-logo">Ecommerce</a>
        <% } else {
        %>
        <a href="/Ecommerce" class="brand-logo">Ecommerce</a>
        <%     }
        %>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <% if (userLogin != null) {%>
            <li>Olá, <%= userLogin%>!</li>
                <% }%>
                <% if (userType != null && userType.equals("funcionario")) { %>
            <li><a href="/Ecommerce/funcionario/PrincipalServlet" class="">Dashboard</a></li>
                <%
                } else if (userType != null && userType.equals("usuario")) {
                %>
            <li><a href="/Ecommerce/usuario/UsuarioDashboardServlet" class="">Painel de Controle</a></li>
                <% }
                %>
            <li><a href="/Ecommerce/VerCarrinhoComprasServlet"><i class="material-icons left">shopping_cart</i>Carrinho</a></li>
                <% if (session.getAttribute("login") == null) {%>
            <li><a href="./login.jsp">Login</a></li>
            <li><a href="novoUsuario.jsp">Cadastro</a></li>
                <% } else { %>
            <li><a href="/Ecommerce/LogoutServlet">Logout</a></li>

            <% }%>




        </ul>
    </div>
</nav>