package com.bpcs.controllers

import com.bpcs.svc.UserSvc
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import javax.ejb.EJB

/**
 * User management controller
 * User: wpfeiffe
 * Date: 1/19/13
 */
@Controller
@RequestMapping("/user")
class UserController
{
    @EJB(mappedName = "java:module/UserSvc")
    UserSvc userSvc

    @RequestMapping("/list")
    public ModelAndView listUsers()
    {
        ModelAndView mav = new ModelAndView()
        mav.addObject("userList", userSvc.getAllUsers())
        mav.setView("/jsp/user/list")
        return mav
    }
}
