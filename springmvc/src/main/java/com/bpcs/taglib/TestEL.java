package com.bpcs.taglib;

//import org.springframework.web.util.ExpressionEvaluationUtils;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.servlet.ServletContext;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Taglib to test Spring EL eval support
 * User: wpfeiffe
 * Date: 9/16/12
 *
 */
public class TestEL extends SimpleTagSupport
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
    public void doTag() throws JspException
    {

        try
        {
            ServletContext servletContext = ((PageContext) this.getJspContext()).getServletContext();
            JspApplicationContext jspAppContext = JspFactory.getDefaultFactory().getJspApplicationContext(servletContext);
            ELContext elContext = this.getJspContext().getELContext();
            ValueExpression valueExpression = jspAppContext.getExpressionFactory().createValueExpression(elContext, testAttribute, Object.class);
            Object evaluatedValue = valueExpression.getValue(elContext);
            JspWriter out = getJspContext().getOut();
            out.print(evaluatedValue);
            out.flush();
        } catch (Exception ex)
        {
            throw new JspException("Error in SimpleEvalTag tag", ex);
        }

    }
}
