package com.bpcs.svc;

import com.bpcs.dao.EmpDeptDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 8/24/12
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.ejb.Stateless(name = "HelloWorldEJB")
public class HelloWorldBean
{
    @PersistenceContext(unitName = "EmployeeDept")
    EntityManager em;

    public HelloWorldBean()
    {
    }

    public String doEcho(String src)
    {
        return "EJB " + src;
    }

    public List getEmployees()
    {
        List emps;
        EmpDeptDAO empdao = new EmpDeptDAO(em);
        if (empdao != null)
        {
            emps = empdao.getAllEmployees();
        }
        else
        {
            emps = new ArrayList();
        }
        return emps;
    }
}
