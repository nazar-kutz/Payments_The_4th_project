package com.nazar.controller.test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class TagController extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String myValue;

    public void setMyValue(String value){
        this.myValue = value;
    }

    @Override
    public int doStartTag() throws JspException {
        try{
            pageContext.getOut().print(this.myValue);
        } catch (IOException e){
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}
