/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author aluno
 */
public class CarroTag extends TagSupport{

    
    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
    
    
    
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    
    
    
}
