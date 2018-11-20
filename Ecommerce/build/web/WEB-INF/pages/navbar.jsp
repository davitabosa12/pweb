<%-- 
    Document   : navbar
    Created on : 22/09/2018, 14:28:15
    Author     : Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
    <div class="nav-wrapper materialize-red">
      <% if(session.getAttribute("login") == null){%>
            <a href="/Ecommerce" class="brand-logo">Ecommerce</a>
    <%    
         } else {
    %>
            <a href="/Ecommerce/funcionario/PrincipalServlet" class="brand-logo">Ecommerce</a>
    <%
        }
    %>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li><a href="/Ecommerce/VerCarrinhoComprasServlet"><i class="material-icons left">shopping_cart</i>(9)</a></li>
        <% if(session.getAttribute("login") == null){%>
            <li><a href="./login.jsp">Login</a></li>
            <li><a href="novoUsuario.jsp">Cadastro</a></li>
        <% } else { %>
            <li><a href="/Ecommerce/LogoutServlet">Logout</a></li>
            
        <% } %>
            
        
        
        
      </ul>
    </div>
</nav>