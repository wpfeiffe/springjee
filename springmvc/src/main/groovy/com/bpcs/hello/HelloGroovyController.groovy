package com.bpcs.hello

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.naming.InitialContext

import com.bpcs.svc.EmployeeSvc

/**
 * Created by IntelliJ IDEA.
 * User: wpfeiffe
 * Date: Jan 12, 2010
 * Time: 5:18:02 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
class HelloGroovyController
{
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
