/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import bean.CarroBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class CadastroCarroServlet extends HttpServlet {

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
        
        String modelo = request.getParameter("modelo");
        String cor = request.getParameter("cor");
        String marca = request.getParameter("marca");
        int portas = Integer.parseInt(request.getParameter("portas"));
        int velMax = Integer.parseInt(request.getParameter("velocidadeMaxima"));
        
        CarroBean c = new CarroBean();
        c.setCor(cor);
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setPortas(portas);
        c.setVelocidadeMaxima(velMax);
        
        request.setAttribute("meuCarro", c);
        RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
        rd.forward(request, response);
        
    }

    

}
