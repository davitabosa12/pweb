/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.funcionario;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioNegocio;
import modelo.usuario.Usuario;

/**
 *
 * @author Davi
 */
public class LoginFuncionarioServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // entrada
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        //processamento
        FuncionarioNegocio negocio = new FuncionarioNegocio();
        boolean sucessoLogin = negocio.efetuarLogin(login, senha);
        
        if(sucessoLogin){
            HttpSession session = request.getSession(true); // cria e referencia a sessão do usuário
            session.setAttribute("login", login); // coloca o atributo login na sessão do usuário
            session.setAttribute("userType", "funcionario");
            Funcionario f = negocio.obterFuncionario(login);
            session.setAttribute("funcionarioBean", f);
            //RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/principal.jsp"); // despacha a requisição para a página main.jsp, encaminhando as instância de request e response 
            RequestDispatcher rd = request.getRequestDispatcher("PrincipalServlet");
            
            //Info do funcionario em JSON
            JsonObject obj = new JsonObject();
            obj.addProperty("login", login);
            obj.addProperty("userType", "funcionario");
            String cookieJSON = new Gson().toJson(obj);
            System.out.println("cookieJSON: " + cookieJSON);
            //TODO: Cookies no browser do funcionario
            
            Cookie loginCookie = new Cookie("ecommerce.login", cookieJSON);
            loginCookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(loginCookie);
            session.setAttribute("login", login);
            
            response.sendRedirect("funcionario/PrincipalServlet");
            //rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("loginFuncionario.jsp");
            request.setAttribute("error_message", "Usuario ou senha incorretos");
            rd.forward(request, response);
        }
    }
}
