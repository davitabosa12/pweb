/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.categoria;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.categoria.CategoriaNegocio;

/**
 *
 * @author Davi
 */
public class ExcluirCategoriaServlet extends HttpServlet {

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
        //checar sessao
        if (request.getSession(false) == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));

        CategoriaNegocio negocio = new CategoriaNegocio();
        boolean success = negocio.excluir(id);

        if (success) {
            request.setAttribute("success_message", "Categoria excluída com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível excluir esta categoria");
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListarCategoriaServlet");
        rd.forward(request, response);
    }
}
