/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taglib;

import bean.CarroBean;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author aluno
 */
public class CarroTag extends TagSupport {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
        CarroBean c = (CarroBean) req.getAttribute(getNome());

        JspWriter out = pageContext.getOut();
        try {
            if (c != null && c instanceof CarroBean) {
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Modelo</td>");
                out.println("<td>Marca</td>");
                out.println("<td>Portas</td>");
                out.println("<td>Cor</td>");
                out.println("<td>Velocidade</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + c.getModelo() +"</td>");
                out.println("<td>"+ c.getMarca() + "</td>");
                out.println("<td>"+ c.getPortas()+ "</td>");
                out.println("<td>"+ c.getCor() + "</td>");
                out.println("<td>"+ c.getVelocidadeMaxima()+ "</td>");
                out.println("</tr>");
                out.println("</table>");
            } else {
                out.println("<div> ERRO!! </div>");
            }
        } catch (Exception e) {

        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
