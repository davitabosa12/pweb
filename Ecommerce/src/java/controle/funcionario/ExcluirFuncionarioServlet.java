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
import modelo.funcionario.FuncionarioNegocio;

/**
 *
 * @author Davi
 */
public class ExcluirFuncionarioServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //checar sessao
        if(request.getSession(false) == null){
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        String login = request.getParameter("login");
        
        FuncionarioNegocio f = new FuncionarioNegocio();
        boolean success = f.excluir(login);
        
        if(success){
            request.setAttribute("success_message", "Usuário " + login + " excluído com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível excluir este usuário");
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionarioServlet");
        rd.forward(request, response);
    }
}
