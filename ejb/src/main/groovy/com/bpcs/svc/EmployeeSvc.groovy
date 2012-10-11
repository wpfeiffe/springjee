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
import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 8/24/12
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.ejb.Stateless(name = "EmployeeSvc")
@Local(EmployeeSvc.class)
public class EmployeeSvc
{
    private static List firstNames = ["Harry", "Steve", "Nancy", "Jennifer", "Stacy", "John", "Greg"]
    private static List lastNames = ["Smith", "Jones", "Stein", "Johnson", "Wills", "Bernard", "Stark"]
    private static List departments = ["MIS", "ACCT", "OPS", "MKT", "HR"]
    private static List titles = ["Developer", "Accounts Recievable", "Manager", "Ad Exec", "Benefits Coordinator"]
    private static Random random = new Random()

    @PersistenceContext(unitName = "EmployeeDept")
    EntityManager em;

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @PostConstruct
    public void init() {
       RepositoryFactorySupport factory = new JpaRepositoryFactory(em);
       this.employeeRepository = factory.getRepository(EmployeeRepository.class);
       this.departmentRepository = factory.getRepository(DepartmentRepository.class);
    }

    public EmployeeSvc()
    {
    }

    public String doEcho(String src)
    {
        return "EJB " + src;
    }

    public List getEmployees()
    {
        List emps;
        EmpDeptDAO empdao = new EmpDeptDAO(em);
        if (empdao != null)
        {
            emps = empdao.getAllEmployees();
        }
        else
        {
            emps = new ArrayList();
        }
        return emps;
    }

    public Employee getSpringJPAEmployee(Long id)
    {
        return employeeRepository.findById(id);
    }

    public List<Employee> getJohns()
    {
        return employeeRepository.findByFirstName("John");
    }

    public Employee buildRandomEmployee()
    {
        Employee randomEmployee = new Employee()
        randomEmployee.firstName = firstNames[random.nextInt(7)]
        randomEmployee.lastName = lastNames[random.nextInt(7)]
        int deptTitleIndex = random.nextInt(5)
        randomEmployee.dept = departmentRepository.findByDeptCode(departments[deptTitleIndex])
        randomEmployee.title = titles[deptTitleIndex]
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

    public void addNewEmp(Employee newEmployee)
    {
        employeeRepository.save(newEmployee)
    }
}
