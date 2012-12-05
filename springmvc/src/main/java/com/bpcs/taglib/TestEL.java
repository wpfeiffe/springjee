package com.bpcs.taglib;

import org.springframework.web.util.ExpressionEvaluationUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Taglib to test Spring EL eval support
 * User: wpfeiffe
 * Date: 9/16/12
 *
 */
public class TestEL extends BodyTagSupport
{
    private String testAttribute = "";

    void initAttributes()
    {
        testAttribute = "";
    }

    public String getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }

    public int doEndTag() throws JspException
    {
        int returnValue = SKIP_BODY;

        String output = (String)ExpressionEvaluationUtils.evaluate("testAttribute", testAttribute, String.class, pageContext);

        try
        {
            pageContext.getOut().write(output);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }


        return returnValue;
    }
}
