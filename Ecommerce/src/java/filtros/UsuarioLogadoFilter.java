/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.funcionario.FuncionarioNegocio;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author aluno
 */
public class UsuarioLogadoFilter implements Filter {
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println("filtros.FuncionarioLogadoFilter.doFilter()");
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        try{
        if(session != null){
            if(session.getAttribute("userType") != null &&
                    session.getAttribute("userType").equals("usuario")){
                System.out.println("ok!");
                chain.doFilter(request, response);
            } else {
                 session.setAttribute("error_message", "Faça login para continuar");
                 res.sendRedirect("/Ecommerce");
            }
            
        } else {
            //nao ha sessao, verificar cookie
            String loginJson = checkCookies(req);
            if(loginJson == null)
            {
                session.setAttribute("error_message", "Faça login para continuar");
                res.sendRedirect("/Ecommerce");
                
            }
                
            else{
                JsonObject obj = new Gson().fromJson(loginJson, JsonObject.class);
                String login = obj.get("login").getAsString();
                String userType = obj.get("userType").getAsString();
                session = req.getSession(true);
                session.setAttribute("login", login);
                session.setAttribute("userType", userType);
                UsuarioNegocio u = new UsuarioNegocio();
                request.setAttribute("funcionarioBean", u.obterUsuario(login));
                chain.doFilter(request, response);
            }
        }
        } catch(Exception e){
            e.printStackTrace();
            session.setAttribute("error_message", "Faça login para continuar");
                res.sendRedirect("/Ecommerce");
            
        }
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filtros.UsuarioLogadoFilter.init()");
    }

    @Override
    public void destroy() {
        System.out.println("filtros.UsuarioLogadoFilter.destroy()");
    }

    public String checkCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie loginCookie = null;
        for(Cookie c : cookies){
            if(c.getName().equals("ecommerce.login"))
            {
                loginCookie = c;
                break;
            }
        }
        if(loginCookie == null)
            return null;
        return loginCookie.getValue();
        
    }
}
