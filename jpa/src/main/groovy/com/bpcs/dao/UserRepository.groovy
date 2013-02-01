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
    User findByLogin(String login);
    User findById(Long id);
    List<UserRole> findRolesByLogin(String login);
}