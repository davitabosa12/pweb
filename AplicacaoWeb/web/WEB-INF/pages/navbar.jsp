<%-- 
    Document   : navbar
    Created on : 22/09/2018, 14:28:15
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
    <div class="nav-wrapper materialize-red">
      <a href="#" class="brand-logo">Logo</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <% if(session.getAttribute("login") == null){%>
            <li><a href="login.jsp">Login</a></li>
        <% } else { %>
            <li><a href="LogoutServlet">Logout</a></li>
        <% } %>
            
        <li><a href="novoUsuario.jsp">Cadastro</a></li>
        
        
      </ul>
    </div>
</nav>