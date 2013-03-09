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

    /**
     * simple getter
     * @return testAttribute
     */
    public String getTestAttribute() {
        return testAttribute;
    }

    /**
     * simple setter
     * @param testAttribute
     */
    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }

    /**
     * reset testAttribute
     */
    void initAttributes()
    {
        testAttribute = "";
    }

    /**
     * do end tag uses EL to evaluate value and print back out
     * @return tag directive value
     * @throws JspException
     */
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
