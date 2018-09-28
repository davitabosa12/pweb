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
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioNegocio;

/**
 *
 * @author aluno
 */
public class VerUsuarioServlet extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
        
        String login = (String) session.getAttribute("login");
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        Usuario usuario = usuarioNegocio.obterUsuarioPorLogin(login);
        System.out.println(usuario.getLogin());
        request.setAttribute("usuarioBean", usuario);
        RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/pages/verUsuario.jsp");
        rd.forward(request, response);
        }
        catch (Exception e){
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

   

}
