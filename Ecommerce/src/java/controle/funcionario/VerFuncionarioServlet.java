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
import modelo.funcionario.Funcionario;
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author Davi
 */
public class VerFuncionarioServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
         try{
            HttpSession session = request.getSession(false);
        
        String login = (String) session.getAttribute("login");
        FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();
        Funcionario funcionario = funcionarioNegocio.obterFuncionario(login);
        if(funcionario != null){
            request.setAttribute("funcionario", funcionario);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/verFuncionario.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error_message", "Você não possui um login válido");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        }
        catch (Exception e){
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }


}
