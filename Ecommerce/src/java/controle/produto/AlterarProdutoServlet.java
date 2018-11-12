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
import modelo.produto.Produto;
import modelo.produto.ProdutoNegocio;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

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
    String UPLOAD_DIRECTORY = "produto_imgs";
    private HashMap<String, String> formData;
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        if(request.getSession(false) == null){
            RequestDispatcher rd = request.getRequestDispatcher("/");
            rd.forward(request, response);
            return;
        }
        int id; 
        String desc;
        double preco;
        int categoriaId;
        String imgPath = null;
        formData = new HashMap();
        
        
        
        
        
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
                        if(item.getSize() > 0) 
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
        ProdutoNegocio negocio = new ProdutoNegocio();
        desc = formData.get("descricao");
        preco = Double.parseDouble(formData.get("preco"));
        categoriaId = Integer.parseInt(formData.get("categoria_id"));
        id = Integer.parseInt(formData.get("id"));
        Produto produtoAntigo = negocio.obter(id);
        
        if(imgPath == null || imgPath.equals("")){
            imgPath = produtoAntigo.getImgPath();
        }
        
        
        
        boolean sucesso = negocio.alterar(id,desc,preco,categoriaId, imgPath);
        if(sucesso){
            request.setAttribute("success_message", "Produto alterado com sucesso!");
        } else {
            request.setAttribute("error_message", "Não foi possível alterar este produto");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("ObterProdutoServlet?id=" + id);
        rd.forward(request, response);
    }
}
