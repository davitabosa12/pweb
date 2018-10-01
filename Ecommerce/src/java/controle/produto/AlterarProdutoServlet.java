/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.produto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.produto.ProdutoNegocio;

/**
 *
 * @author Davi
 */
public class AlterarProdutoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
        int id = Integer.parseInt(request.getParameter("id"));
        String desc = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int categoriaId = Integer.parseInt(request.getParameter("categoria_id"));
        ProdutoNegocio negocio = new ProdutoNegocio();
        boolean sucesso = negocio.alterar(id,desc,preco,categoriaId);
        if(sucesso){
            request.setAttribute("success_message", "Produto inserido com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível alterar este produto");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("ObterProdutoServlet?id=" + id);
        rd.forward(request, response);
    }
}
