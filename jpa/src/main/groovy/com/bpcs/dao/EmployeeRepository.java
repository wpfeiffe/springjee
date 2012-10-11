package com.bpcs.dao;

import com.bpcs.jpa.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Spring extended Emp Repo
 * User: wpfeiffe
 * Date: 9/13/12
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
    Employee findById(Long id);
    List<Employee> findByFirstName(String firstName);

}
