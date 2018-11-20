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
import modelo.produto.Produto;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author aluno
 */
public class ConfirmarItemCarrinho extends HttpServlet {

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
        System.out.println("controle.carrinho.ConfirmarItemCarrinho.service()");
        int produtoId = Integer.parseInt(request.getParameter("produto_id"));
        Produto produto = new ProdutoNegocio().obter(produtoId);
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("/WEB-INF/pages/compras/adicionarItemCarrinho.jsp")
                .forward(request, response);
    }

}
