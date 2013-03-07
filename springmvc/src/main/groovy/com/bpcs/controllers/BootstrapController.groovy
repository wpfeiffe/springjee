package com.bpcs.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Controller to play with bootstrap req/resp.
 * User: wpfeiffe
 * Date: 2/4/13
 */
@Controller
@RequestMapping("/bootstrap")
class BootstrapController
{
    @RequestMapping("/show")
    ModelAndView doShow()
    {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.addObject("hello", "Hello")
        modelAndView.setViewName("/jsp/bootstrap/show")
        return modelAndView
    }
}
