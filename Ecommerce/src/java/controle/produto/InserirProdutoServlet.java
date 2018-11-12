/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.produto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.produto.ProdutoNegocio;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Davi
 */
public class InserirProdutoServlet extends HttpServlet {

    private String UPLOAD_DIRECTORY = "produto_imgs";

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
        HashMap<String, String> formData = new HashMap();
        //checar sessao
        if (request.getSession(false) == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        String desc;
        double preco;
        int categoriaId;
        String imgPath = null;

        //------INICIO MULTIPART
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // constructs the directory path to store upload file
                
                String uploadPath = getServletContext().getRealPath("")
                        + File.separator + UPLOAD_DIRECTORY;
                
                // creates the directory if it does not exist
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                factory.setRepository(new File(uploadPath + File.separator + "temp"));
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (!item.isFormField()) {
                        imgPath = item.getName();
                        item.write(new File(uploadPath + File.separator + item.getName()));
                    } else {
                        //file is formfield
                        String name = item.getFieldName();
                        String value = item.getString();
                        formData.put(name, value);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //------FIM MULTIPART

        desc = formData.get("descricao");
        preco = Double.parseDouble(formData.get("preco"));
        categoriaId = Integer.parseInt(formData.get("categoria_id"));
        
        ProdutoNegocio negocio = new ProdutoNegocio();
        boolean sucesso = negocio.inserir(desc, preco, categoriaId, imgPath);

        if (sucesso) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/produto/novoProduto.jsp");
            request.setAttribute("success_message", "Produto inserido com sucesso");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/produto/novoProduto.jsp");
            request.setAttribute("error_message", "Não foi possível inserir este produto");
            rd.forward(request, response);
        }
    }
}
