package com.bpcs.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Used to forward to simple index page
 */
@Controller
class DepartmentController
{
    @RequestMapping("/backdept")
    public ModelAndView backdept()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("/jsp/department/index")
        return mav
    }


}
