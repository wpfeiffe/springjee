package com.bpcs.rest

import com.bpcs.jpa.Department
import com.bpcs.svc.DepartmentSvc
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

import javax.ejb.EJB


/**
 * Class implements rest api for Department class
 */

@Controller
//@RequestMapping("/api")
class DepartmentApi
{
    @EJB(mappedName="java:module/DepartmentSvc")
    DepartmentSvc departmentSvc

    @RequestMapping(value="/department", method=RequestMethod.GET)
    @ResponseBody
    public Collection<Department> getDepartments()
    {
        return departmentSvc.listDepartments()
    }

    @RequestMapping(value="/department/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Department getDepartment(@PathVariable("id") String id)
    {
        return departmentSvc.getDepartment(Long.parseLong(id))
    }

    @RequestMapping(value="/department", method=RequestMethod.POST)
    @ResponseBody
    public Department addDepartment(@RequestBody Department department)
    {
        return departmentSvc.addOrUpdateDepartment(department)
    }

    @RequestMapping(value="/department/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Department updateDepartment(@PathVariable("id") String id,
                                       @RequestBody Department department)
    {
        Department currDepartment = departmentSvc.getDepartment(Integer.parseInt(id))
        department.deptCode = currDepartment.deptCode
        department.deptName = currDepartment.deptName
        department.deptText = currDepartment.deptText
        return departmentSvc.addOrUpdateDepartment(department)
    }

    @RequestMapping(value="/department/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public Department removeDepartment(@PathVariable("id") String id)
    {
        departmentSvc.deleteDepartment(Integer.parseInt(id))
    }
}
