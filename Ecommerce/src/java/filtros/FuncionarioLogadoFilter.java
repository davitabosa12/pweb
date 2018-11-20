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

/**
 *
 * @author Davi
 */
public class FuncionarioLogadoFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public FuncionarioLogadoFilter() {
    }    
    
  
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
            if(session.getAttribute("userType").equals("funcionario")){
                System.out.println("ok!");
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher("/Ecommerce").forward(request, response);
            }
            
        } else {
            //nao ha sessao, verificar cookie
            String loginJson = checkCookies(req);
            if(loginJson == null)
                req.getRequestDispatcher("/Ecommerce").forward(request, response);
            else{
                JsonObject obj = new Gson().fromJson(loginJson, JsonObject.class);
                String login = obj.get("login").getAsString();
                String userType = obj.get("userType").getAsString();
                session = req.getSession(true);
                session.setAttribute("login", login);
                session.setAttribute("userType", userType);
                FuncionarioNegocio f = new FuncionarioNegocio();
                request.setAttribute("funcionarioBean", f.obterFuncionario(login));
                chain.doFilter(request, response);
            }
        }
        } catch(Exception e){
            e.printStackTrace();
            res.sendRedirect("/Ecommerce");
            
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
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
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
        System.out.println("filtros.FuncionarioLogadoFilter.destroy()");
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("FuncionarioLogadoFilter:Initializing filter");
            }
        }
        System.out.println("filtros.FuncionarioLogadoFilter.init()");
    }
    
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
