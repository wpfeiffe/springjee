package com.bpcs.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: wpfeiffe
 * Date: Jan 7, 2010
 * Time: 11:59:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/test")
public class HelloController
{
    @RequestMapping("/hello")
    public ModelAndView hello()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("message", "Hello from the HelloController");
        return mav;
    }
}
