/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoCompras;
import modelo.carrinho.CarrinhoComprasItem;
import modelo.produto.Produto;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author aluno
 */
public class AdicionarItemCarrinho extends HttpServlet {

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
        int produtoId = Integer.parseInt(request.getParameter("produto_id"));
        int qtde = Integer.parseInt(request.getParameter("quantidade"));
        Produto produto = new ProdutoNegocio().obter(produtoId);
        
        CarrinhoComprasItem item = new CarrinhoComprasItem(qtde, produto);
        CarrinhoCompras carrinho = CarrinhoCompras.fromCookieArray(request.getCookies());
        carrinho.adicionarItem(item);
        
        Cookie cookie = new Cookie("ecommerce.carrinho", carrinho.toString());
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        
        request.setAttribute("success_message", "Produto adicionado");
        request.getRequestDispatcher("/").forward(request, response);
    }

}
