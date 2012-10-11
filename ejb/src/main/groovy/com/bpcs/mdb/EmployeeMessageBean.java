package com.bpcs.mdb;

import com.bpcs.jpa.Employee;
import com.bpcs.svc.EmployeeSvc;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Handles employee message
 * User: wpfeiffe
 * Date: 10/10/12
 */
@MessageDriven(name = "EmployeeMessageMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/employee"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "durable", propertyValue = "true")
})
public class EmployeeMessageBean implements MessageListener
{
    @EJB
    EmployeeSvc employeeSvc;




    public EmployeeMessageBean() {}

    public void onMessage(Message message)
    {
        Employee employee;
        try
        {
            if (message instanceof ObjectMessage  && ((ObjectMessage) message).getObject() instanceof Employee)
            {
                employee = (Employee) ((ObjectMessage) message).getObject();
                employeeSvc.addNewEmp(employee);
            }
            else
            {
                return;
            }
        }
        catch (JMSException e)
        {
            return;
        }
    }
}
