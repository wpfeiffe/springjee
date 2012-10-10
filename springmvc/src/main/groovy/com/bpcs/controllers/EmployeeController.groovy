package com.bpcs.controllers

import org.springframework.web.servlet.ModelAndView
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import com.bpcs.svc.HelloWorldBean
import javax.naming.InitialContext
import com.bpcs.jpa.Employee

/**
 * Provides employee specific actions
 * User: wpfeiffe
 * Date: 9/8/12
 */
@Controller
class EmployeeController
{
    @RequestMapping("/listemp")
    public ModelAndView listemp()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("/jsp/twitboot/listemp")
        mav.addObject("message", "Hello")
        HelloWorldBean hello = new InitialContext().lookup("java:app/springmvc/HelloWorldEJB")
        String message = hello.doEcho("Hello from the HelloGroovyController : Testing EL")
        List emps = hello.getEmployees()
        Employee emp = hello.getSpringJPAEmployee(6L)
        List<Employee> johns = hello.getJohns()
        mav.addObject("message", message)
        mav.addObject("employees", emps)
        mav.addObject("emp", emp)
        return mav
    }
}
