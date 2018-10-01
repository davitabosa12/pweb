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
public class ExcluirProdutoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //checar sessao
        if (request.getSession(false) == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));

        ProdutoNegocio negocio = new ProdutoNegocio();
        boolean success = negocio.excluir(id);

        if (success) {
            request.setAttribute("success_message", "Produto excluída com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível excluir este produto");
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListarProdutoServlet");
        rd.forward(request, response);
    }
}
