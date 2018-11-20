/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoCompras;

/**
 *
 * @author aluno
 */
public class VerCarrinhoComprasServlet extends HttpServlet {

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
        CarrinhoCompras carrinho = CarrinhoCompras.fromCookieArray(request.getCookies());
        request.setAttribute("lista_produtos", carrinho.getItens());
        request.getRequestDispatcher("/WEB-INF/pages/compras/verCarrinhoCompras.jsp").forward(request, response);
    }


}
