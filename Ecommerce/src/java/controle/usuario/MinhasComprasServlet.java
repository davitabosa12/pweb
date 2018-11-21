/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.venda.Venda;
import modelo.venda.VendaDAO;

/**
 *
 * @author Davi
 */
public class MinhasComprasServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
            String login = (String) session.getAttribute("login");
        
        VendaDAO v = new VendaDAO();
        List<Venda> vendas = v.obterVendaPorUsuario(login);
        request.setAttribute("vendas", vendas);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/usuario/minhasCompras.jsp");
        rd.forward(request, response);
    }
}
