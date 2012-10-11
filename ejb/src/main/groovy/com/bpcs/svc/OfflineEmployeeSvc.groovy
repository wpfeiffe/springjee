package com.bpcs.svc

import javax.jms.ConnectionFactory
import javax.annotation.Resource

import com.bpcs.jpa.Employee
import javax.jms.Connection
import javax.jms.Session
import javax.jms.MessageProducer
import javax.jms.ObjectMessage
import javax.jms.Queue
import javax.ejb.Local
import javax.ejb.EJB

/**
 * Employee services that operate offline via JMS
 * User: wpfeiffe
 * Date: 10/10/12
 */
@javax.ejb.Stateless(name = "OfflineEmployeeSvc")
@Local(OfflineEmployeeSvc.class)
class OfflineEmployeeSvc
{
    @Resource(name = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory

    @Resource(name = "java:/queue/employee")
    private Queue queue

    public OfflineEmployeeSvc()
    {

    }

    public void updateEmployeeLater(Employee emp)
    {
        Connection connection = connectionFactory.createConnection()
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
        MessageProducer messageProducer = session.createProducer(queue)
        ObjectMessage message = session.createObjectMessage()
        message.setObject(emp)
        messageProducer.send(message)
        messageProducer.close()
        session.close()
        connection.close()

    }

}