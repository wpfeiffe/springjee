package com.bpcs.hello

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.naming.InitialContext

import com.bpcs.svc.EmployeeSvc

/**
 * Initial hello world controller with groovy
 * User: wpfeiffe
 * Date: Jan 12, 2010
 */

@Controller
class HelloGroovyController
{
    /**
     * Simple groovy test controller to show a message
     * @return ModelAndView with message and employee list
     */
    @RequestMapping("/helloGroovy")
    public ModelAndView helloGroovy()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("hello")
        EmployeeSvc hello = new InitialContext().lookup("java:module/HelloWorldEJB")
        String message = hello.doEcho("MY New Stuff: Hello from the HelloGroovyController")
        List emps = hello.getEmployees()
        mav.addObject("message", message)
        mav.addObject("employees", emps)
        return mav
    }
}
