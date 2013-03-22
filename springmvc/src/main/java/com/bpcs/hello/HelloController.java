package com.bpcs.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Simple java controller to show hello message
 * User: wpfeiffe
 * Date: Jan 7, 2010
 * Time: 11:59:13 PM
 */
@Controller
@RequestMapping("/test")
public class HelloController
{
    /**
     * shows hello message
     * @return ModelAndView with hello message
     */
    @RequestMapping("/hello")
    public ModelAndView hello()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("message", "Hello from the HelloController");
        return mav;
    }
}
