package com.bpcs.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

/**
 * Controller to show bcrypt value for use in updating db
 * User: wpfeiffe
 * Date: 1/31/13
 */
@Controller
@RequestMapping(value = "/bcrypt")
class BcryptController
{
    /**
     * Init to show the bcrypt page
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init()
    {
        ModelAndView mav = new ModelAndView()
        mav.setViewName("/jsp/security/bcrypt")
        return mav
    }

    /**
     * Encode and display encoded password
     * @param textToEncode
     * @return ModelAndView
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView encryptText(@RequestParam("encode_text") String textToEncode)
    {
        ModelAndView mav = new ModelAndView()

        // encode and test encoded password
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
        String encodedText = passwordEncoder.encode(textToEncode)
        mav.addObject("password_match", passwordEncoder.matches(textToEncode, encodedText))

        // pass back encoded text for display
        mav.addObject("encoded_text", encodedText)


        mav.setViewName("/jsp/security/bcrypt")

        return mav
    }

}
