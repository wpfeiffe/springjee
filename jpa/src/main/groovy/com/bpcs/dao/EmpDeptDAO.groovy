package com.bpcs.dao

import javax.persistence.EntityManagerFactory
import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.persistence.PersistenceContext

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 8/25/12
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
class EmpDeptDAO
{
    EntityManager em;

    EmpDeptDAO(EntityManager em)
    {
        this.em = em
    }

    List getAllEmployees()
    {
        List emps = em.createQuery("select emp from Employee emp").getResultList()
        return emps
    }
}
