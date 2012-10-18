package com.bpcs.controllers

import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import com.bpcs.jpa.Employee
import javax.ejb.EJB

import com.bpcs.svc.OfflineEmployeeSvc
import com.bpcs.svc.EmployeeSvc

/**
 * Provides employee specific actions
 * User: wpfeiffe
 * Date: 9/8/12
 */
@Controller
class EmployeeController
{
    @EJB(mappedName="java:module/EmployeeSvc")
    EmployeeSvc employeeSvc

    @EJB(mappedName="java:module/OfflineEmployeeSvc")
    OfflineEmployeeSvc offlineEmployeeSvc

    @RequestMapping("/listemp")
    public ModelAndView listEmployees()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("/jsp/twitboot/listemp")
        mav.addObject("message", "Hello")
        String message = employeeSvc.doEcho("Hello from the HelloGroovyController : Testing EL")
        List emps = employeeSvc.getEmployees()
        Employee emp = employeeSvc.getSpringJPAEmployee(6L)
        List<Employee> johns = employeeSvc.getJohns()
        mav.addObject("message", message)
        mav.addObject("employees", emps)
        mav.addObject("emp", emp)
        return mav
    }

    @RequestMapping("/addemp")
    public ModelAndView addEmployee()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("/jsp/twitboot/listemp")
        Employee newEmployee = employeeSvc.buildRandomEmployee()
        offlineEmployeeSvc.updateEmployeeLater(newEmployee)
        mav.addObject("employees", employeeSvc.getEmployees())
        mav.addObject("message", "Employee: $newEmployee added")
        return mav
    }
}
