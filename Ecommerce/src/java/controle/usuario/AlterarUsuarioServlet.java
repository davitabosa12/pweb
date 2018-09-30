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
import modelo.usuario.UsuarioDAO;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author Davi
 */
public class AlterarUsuarioServlet extends HttpServlet {

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
        
        String nome = request.getParameter("name");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        UsuarioNegocio u = new UsuarioNegocio();
        boolean sucesso = u.alterar(nome, login, senha);
        if(sucesso){
            request.setAttribute("success_message", "Usuário inserido com sucesso!");
        } else if(!session.getAttribute("login").equals(login)){
            request.setAttribute("success_message", "Você alterou o que não devia!  :)");
        } else {
            request.setAttribute("error_message", "Não foi possível alterar este usuário");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("ObterUsuarioServlet?login=" + login);
        rd.forward(request, response);
    }


}
