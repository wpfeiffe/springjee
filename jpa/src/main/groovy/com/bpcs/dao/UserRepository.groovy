package com.bpcs.dao

import com.bpcs.jpa.User
import com.bpcs.jpa.UserRole
import org.springframework.data.repository.CrudRepository

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 12/28/12
 * Time: 7:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends CrudRepository<User, Integer>
{
    /**
     * Find User by login
     * @param login
     * @return User for given login
     */
    User findByLogin(String login);

    /**
     * Find User by id
     * @param id
     * @return User for given id
     */
    User findById(Long id);

    /**
     * Find roles for a user with a given login
     * @param login Login of user
     * @return List of roles for user with the given login
     */
    List<UserRole> findRolesByLogin(String login);
}