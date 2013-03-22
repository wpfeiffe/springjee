package com.bpcs.svc

import com.bpcs.dao.UserDAO
import com.bpcs.dao.UserRepository
import com.bpcs.jpa.User
import com.bpcs.jpa.UserRole
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.data.repository.core.support.RepositoryFactorySupport

import javax.annotation.PostConstruct
import javax.ejb.Local
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * Service class to provide all access to user lookup and login
 * User: wpfeiffe
 * Date: 1/19/13
 * Time: 7:51 AM
 */
@javax.ejb.Stateless(name = "UserSvc")
@Local(UserSvc.class)
public class UserSvc
{
    @PersistenceContext(unitName = "EmployeeDept")
    EntityManager em;

    private UserRepository userRepository
    private UserDAO userDAO

    /**
     * method for EJB PostConstruct call
     */
    @PostConstruct
    public void init()
    {
        RepositoryFactorySupport factorySupport = new JpaRepositoryFactory(em);
        this.userRepository = factorySupport.getRepository(UserRepository.class);
        this.userDAO = new UserDAO(em)
    }

    /**
     * Empty constructor
     */
    public UserSvc()
    {
    }

    /**
     * Returns User object for the given id
     * @param id User id
     * @return Found User object
     */
    public User getUserById(Long id)
    {
        return userRepository.findById(id)
    }

    /**
     * Returns User for given login string
     * @param login Login string
     * @return User for the given login string
     */
    public User getUserByLogin(String login)
    {
        User user = userRepository.findByLogin(login)
        return user
    }

    /**
     * Gets all users in the db
     * @return List of all users in the db
     */
    public List<User> getAllUsers()
    {
        return userDAO.getAllUsers()
    }

}
