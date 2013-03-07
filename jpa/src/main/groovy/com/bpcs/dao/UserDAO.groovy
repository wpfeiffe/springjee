package com.bpcs.dao

import com.bpcs.jpa.User

import javax.persistence.EntityManager

/**
 * Data access around users
 * User: wpfeiffe
 * Date: 1/19/13
 * Time: 7:46 AM
 */
class UserDAO
{
    EntityManager em;

    UserDAO(EntityManager em)
    {
        this.em = em
    }

    List<User> getAllUsers()
    {
        List<User> users = em.createQuery("select user from User user").getResultList()
        return users
    }

}
