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
public class AlterarFuncionarioServlet extends HttpServlet {

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
        
        if(request.getSession(false) == null){
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
            
        
        String nome = request.getParameter("name");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        double salario = -1;
        try{
            salario = Double.parseDouble(request.getParameter("salario"));
        } catch (Exception e){
            System.out.println("salario nao é um numero");
        }
        
        FuncionarioNegocio f = new FuncionarioNegocio();
        boolean sucesso = f.alterar(nome, login, senha, salario);
        if(sucesso){
            request.setAttribute("success_message", "Funcionário inserido com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível alterar este funcionário");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("ObterFuncionarioServlet?login=" + login);
        rd.forward(request, response);

    }

    
}
