package com.nazar.controller.jstl;

import com.nazar.language.LanguageManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

import static com.nazar.util.GlobalConst.ERROR;
import static com.nazar.util.GlobalConst.LANGUAGE;

public class JTextErr extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String output = "";

    public void setValue(String err){
        if(err == null || err.isEmpty()){
            return;
        }
        LanguageManager language = (LanguageManager) pageContext.getSession().getAttribute(LANGUAGE);
        if(language == null){
            language = new LanguageManager();
        }
        if(err.contains(":")) {
            String[] errorMessageParts = err.split(":");    //2 strings: key and message
            String key = errorMessageParts[0];
            String message = errorMessageParts[1];
            this.output = language.get(key) + ": " + message;
        } else {
            this.output = language.get(err);
        }
    }

    public void setBefore(String additionalText){
        output = additionalText + output;
    }

    public void setAfter(String additionalText){
        output += additionalText;
    }

    @Override
    public int doStartTag() throws JspException {
        try{
            pageContext.getOut().print(this.output);
        } catch (IOException e){
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }
}