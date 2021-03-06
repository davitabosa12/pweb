/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author Davi
 */
public class AlterarDadosServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        String nome = request.getParameter("name");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        UsuarioNegocio u = new UsuarioNegocio();
        boolean sucesso = u.alterar(nome, login, senha);
        if(sucesso){
            request.setAttribute("success_message", "Dados alterados com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível alterar dados");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("UsuarioDashboardServlet");
        rd.forward(request, response);
    }
}
