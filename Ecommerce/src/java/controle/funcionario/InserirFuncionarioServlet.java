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
public class InserirFuncionarioServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = (String) request.getParameter("nome");
        String login = (String) request.getParameter("login");
        String senha = (String) request.getParameter("senha");
        double salario = Double.NaN;
        String sal =(String) request.getParameter("salario");
        try{
            salario = Double.parseDouble(sal);        
        } catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("novoFuncionario.jsp");
            request.setAttribute("error_message", "Salario deve ser um número: " + sal);
            rd.forward(request, response);
            return;
        }
        
        FuncionarioNegocio fn = new FuncionarioNegocio();
        boolean sucesso = fn.inserir(nome, login, senha, salario);
        if(sucesso){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/funcionario/novoFuncionario.jsp");
            request.setAttribute("toast_message", "Funcionario inserido com sucesso");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/funcionario/novoFuncionario.jsp");
            request.setAttribute("error_message", "Não foi possível inserir este funcionario");
            rd.forward(request, response);
        }
    }
}
