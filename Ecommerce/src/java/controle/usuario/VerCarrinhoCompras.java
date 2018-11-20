/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.usuario;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carrinho.CarrinhoCompras;

/**
 *
 * @author aluno
 */
public class VerCarrinhoCompras extends HttpServlet {

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
        Cookie[] cookies = request.getCookies();
        String carrinhoJson = null;
        for(Cookie c : cookies){
            if(c.getName().equals("ecommerce.carrinho")){
                carrinhoJson = c.getValue();
                break;
            }
        }
        if(carrinhoJson == null) {
            //carrinho vazio
        } else {
            Gson gson = new Gson();
            CarrinhoCompras c = gson.fromJson(carrinhoJson, CarrinhoCompras.class);
            request.setAttribute("carrinho_compras", c);
        }
        request.getRequestDispatcher("/Ecommerce/verCarrinhoCompras.jsp").forward(request, response);
    }

}
