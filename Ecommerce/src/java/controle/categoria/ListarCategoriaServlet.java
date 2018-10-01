/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.categoria;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.categoria.Categoria;
import modelo.categoria.CategoriaNegocio;

/**
 *
 * @author Davi
 */
public class ListarCategoriaServlet extends HttpServlet {
   
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
        if(request.getSession(false) == null){
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        CategoriaNegocio negocio = new CategoriaNegocio();
        List<Categoria> categorias = negocio.obterTodos();
        
        request.setAttribute("lista_categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/categoria/listar.jsp");
        rd.forward(request, response);
    }
}
