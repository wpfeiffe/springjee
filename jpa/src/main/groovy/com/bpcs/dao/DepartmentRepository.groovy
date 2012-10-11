package com.bpcs.dao

import org.springframework.data.repository.CrudRepository
import com.bpcs.jpa.Department

/**
 * Department spring jpa data repo
 * User: wpfeiffe
 * Date: 10/11/12
 */
public interface DepartmentRepository extends CrudRepository<Department, Integer>
{
    Department findByDeptCode(String deptCode)
}