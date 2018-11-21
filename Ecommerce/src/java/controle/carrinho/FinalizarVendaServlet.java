/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.carrinho.CarrinhoCompras;
import modelo.carrinho.CarrinhoComprasItem;
import modelo.usuario.Usuario;
import modelo.venda.ProdutoVenda;
import modelo.venda.Venda;
import modelo.venda.VendaDAO;


/**
 *
 * @author Davi
 */
public class FinalizarVendaServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        System.out.println("controle.carrinho.FinalizarVendaServlet.service()");
        HttpSession session = request.getSession(false);
        String client_login = (String) session.getAttribute("login");
        CarrinhoCompras cc;
        cc = CarrinhoCompras.fromCookieArray(request.getCookies());
        List<ProdutoVenda> produtos = new ArrayList();
        for(CarrinhoComprasItem item : cc.getItens()){
            produtos.add(
                    (new ProdutoVenda(item.getProduto(), item.getQuantidade(), item.getProduto().getPreco()))
            );
        }
        Venda venda = new Venda();
        Usuario u = new Usuario();
        u.setLogin(client_login);
        venda.setUsuario(u);
        venda.setProdutos(produtos);
        VendaDAO vendaDAO = new VendaDAO();
        boolean sucesso = vendaDAO.inserirVenda(venda);
        if(sucesso){
            System.out.println("        Venda realizada com sucesso");
            Cookie c = findAndRemoveCookie(request.getCookies());
            if(c != null)
                response.addCookie(c);
            request.setAttribute("success_message", "Venda Realizada com sucesso!");
            
        } else{
            System.out.println("        Erro ao realizar venda");
            request.setAttribute("error_message", "Erro ao realizar venda");
        }
        
        request.getRequestDispatcher("/WEB-INF/pages/compras/compraFeita.jsp").forward(request, response);
        
    }

    private Cookie findAndRemoveCookie(Cookie[] cookies) {
        for(Cookie c : cookies){
            if(c.getName() == "ecommerce.carrinho"){
                c.setMaxAge(0);
                return c;
            }
        }
        return null;
    }
}
