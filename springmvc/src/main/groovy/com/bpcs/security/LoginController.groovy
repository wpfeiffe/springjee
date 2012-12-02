package com.bpcs.security

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMethod
import java.security.Principal
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * Handle all form based auth actions
 * User: wpfeiffe
 * Date: 11/18/12
 */
@Controller
class LoginController
{

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model)
    {
        return "/jsp/security/login"

    }

    @RequestMapping(value="/failLogin", method = RequestMethod.GET)
    public String failLogin(ModelMap model)
    {
        model.addAttribute("error", "true")
        return "/jsp/security/login"

    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String printMessage(ModelMap model, Principal principal)
    {

        String username = principal.getName()
        model.addAttribute("user", username)
        model.addAttribute("msg", "Spring Security Custom Login Form")
        return "/jsp/security/welcome"

    }
    @RequestMapping(value = "/logoff", method = RequestMethod.GET)
    public String logoff(ModelMap model)
    {
        return "/jsp/security/login";
    }
}
