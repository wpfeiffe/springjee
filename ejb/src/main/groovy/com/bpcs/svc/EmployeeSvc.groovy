package com.bpcs.svc;

import com.bpcs.dao.EmpDeptDAO;
import com.bpcs.dao.EmployeeRepository;
import com.bpcs.jpa.Employee;
import com.bpcs.dao.DepartmentRepository;
import com.bpcs.jpa.Department;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List
import javax.ejb.Local
import javax.annotation.Resource;

/**
 * Employee service handle add /update of employees.  Utilizes JPA for persistence and Infinispan for caching
 * User: wpfeiffe
 * Date: 8/24/12
 */
@javax.ejb.Stateless(name = "EmployeeSvc")
@Local(EmployeeSvc.class)
public class EmployeeSvc
{

    final private static String EMP_CACHE = "EMP_CACHE"

    private static List firstNames = ["Harry", "Steve", "Nancy", "Jennifer", "Stacy", "John", "Greg"]
    private static List lastNames = ["Smith", "Jones", "Stein", "Johnson", "Wills", "Bernard", "Stark"]
    private static List departments = ["MIS", "ACCT", "OPS", "MKT", "HR"]
    private static List titles = ["Developer", "Accounts Recievable", "Manager", "Ad Exec", "Benefits Coordinator"]
    private static Random random = new Random()

    @PersistenceContext(unitName = "EmployeeDept")
    EntityManager em;

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Resource(name="java:jboss/infinispan/employee")
    private org.infinispan.manager.CacheContainer container;
    private org.infinispan.Cache<String, Object> cache;

    /**
     * init called at PostConstruct.  Initializes Spring Data repositories and cache.
     */
    @PostConstruct
    public void init() {
       RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
       this.employeeRepository = factory.getRepository(EmployeeRepository.class);
       this.departmentRepository = factory.getRepository(DepartmentRepository.class);
       this.cache = this.container.getCache();
    }

    /**
     * Empty constructor
     */
    public EmployeeSvc()
    {
    }

    /**
     * Echos input with "EJB " prepended
     * @param src input value
     * @return "EJB " prepended string
     */
    public String doEcho(String src)
    {
        return "EJB " + src;
    }

    /**
     * Return list of all employees in the db
     * @return list of employess
     */
    public List getEmployees()
    {
        List emps;
        EmpDeptDAO empdao = new EmpDeptDAO(em);

        // look first in the cache
        List cachedEmployees = cache.get(EmployeeSvc.EMP_CACHE)

        // if found in cache
        if (cachedEmployees != null)
        {
            // return what is found
            emps = cachedEmployees
        }
        // test of empdao not null
        else if (empdao != null)
        {
            // getall emps from db and put in cache
            emps = empdao.getAllEmployees()
            cache.put(EmployeeSvc.EMP_CACHE, emps)
        }
        // nothing else worked, return empty list
        else
        {
            emps = new ArrayList()
        }
        return emps
    }

    /**
     * Get employee for given id
     * @param id Employee id to find
     * @return Employee found
     */
    public Employee getSpringJPAEmployee(Long id)
    {
        return employeeRepository.findById(id);
    }

    /**
     * Use spring data to find all employees with first name john
     * @return Employees with first name John
     */
    public List<Employee> getJohns()
    {
        return employeeRepository.findByFirstName("John");
    }

    /**
     * Uses static lists of values to create a random employee record
     * @return generated Employee
     */
    public Employee buildRandomEmployee()
    {
        // new empty emp
        Employee randomEmployee = new Employee()

        // select random values from lists or number
        randomEmployee.firstName = firstNames[random.nextInt(7)]
        randomEmployee.lastName = lastNames[random.nextInt(7)]
        int deptTitleIndex = random.nextInt(5)
        randomEmployee.dept = departmentRepository.findByDeptCode(departments[deptTitleIndex])
        randomEmployee.title = titles[deptTitleIndex]

        // build random ssn
        randomEmployee.ssn = ""
        for (int i = 1; i <= 9; i++)
        {
            randomEmployee.ssn += random.nextInt(10).toString()
            if ([3,5].contains(i))
            {
                randomEmployee.ssn += "-"
            }
        }

        return randomEmployee
    }

    /**
     * Persists the given new employee
     * @param newEmployee Employee to addd
     */
    public void addNewEmp(Employee newEmployee)
    {
        employeeRepository.save(newEmployee)

        // invalidate cache
        cache.remove(EmployeeSvc.EMP_CACHE)
    }

}
