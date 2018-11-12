/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.funcionario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author Davi
 */
public class PrincipalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null){
            //nao fez login
            request.setAttribute("error_message", "Login ou senha incorreta"); // coloca uma mensagem no objeto request
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); // despacha a requisição para a página index.jsp, encaminhando as instância de request e response
            rd.forward(request, response);
        } else {
            FuncionarioNegocio f = new FuncionarioNegocio();
            
            request.setAttribute("funcionarioBean", f.obterFuncionario((String) session.getAttribute("login"))); 
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/principal.jsp");
            rd.forward(request, response);
        }
    }

}
