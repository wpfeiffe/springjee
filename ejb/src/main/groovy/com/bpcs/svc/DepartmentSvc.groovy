package com.bpcs.svc

import com.bpcs.dao.DepartmentRepository
import com.bpcs.jpa.Department
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory
import org.springframework.data.repository.core.support.RepositoryFactorySupport

import javax.annotation.PostConstruct
import javax.ejb.Local
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * wrapping DepartmentRepository
 */
@javax.ejb.Stateless(name = "DepartmentSvc")
@Local(DepartmentSvc.class)
class DepartmentSvc
{
    @PersistenceContext(unitName = "EmployeeDept")
    EntityManager em;

    private DepartmentRepository departmentRepository;

    /**
     * init called at PostConstruct.  Initializes Spring Data repositories and cache.
     */
    @PostConstruct
    public void init() {
       RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
       this.departmentRepository = factory.getRepository(DepartmentRepository.class);
    }

    /**
     * Empty constructor
     */
    public DepartmentSvc()
    {
    }

    public Department addOrUpdateDepartment(Department department)
    {
        departmentRepository.save(department)
        return department
    }

    public Department deleteDepartment(Long id)
    {
        departmentRepository.delete(id)
    }

    public Department getDepartment(Long id)
    {
        return departmentRepository.findOne(id)
    }

    public List<Department> listDepartments()
    {
        return departmentRepository.findAll()
    }

}
