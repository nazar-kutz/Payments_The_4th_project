package com.nazar.controller.test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DynamicTag extends TagSupport implements DynamicAttributes {
    private static final long serialVersionUID = 1L;
    private Map<String, Object> map = new HashMap<>();

    @Override
    public int doStartTag() throws JspException {
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append( "<ul>" );
            for( String name : map.keySet() ){
                buffer.append( "<li>" )
                        .append( name )
                        .append( " - " )
                        .append( map.get( name ) )
                        .append( "</li>" );
            }
            buffer.append( "</ul>" );

            pageContext.getOut().print( buffer.toString() );
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public void setDynamicAttribute(String s, String s1, Object o) throws JspException {

    }
}
