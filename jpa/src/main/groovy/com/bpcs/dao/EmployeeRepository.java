package com.bpcs.dao;

import com.bpcs.jpa.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Spring extended Emp Repo
 * User: wpfeiffe
 * Date: 9/13/12
 */

/**
 * Spring data repository interface for Employee objects
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    /**
     * Finds employees for first and last name values
     * @param lastName
     * @param firstName
     * @return List of employee objects that match first and last name values
     */
    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);

    /**
     * Finds employee by id
     * @param id Employee id
     * @return Employee for given id
     */
    Employee findById(Long id);


    /**
     * Finds employees with given first name value
     * @param firstName
     * @return List of employee objects that match first name value
     */
    List<Employee> findByFirstName(String firstName);

}
