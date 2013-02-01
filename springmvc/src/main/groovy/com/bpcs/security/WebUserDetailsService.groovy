package com.bpcs.security

import com.bpcs.jpa.User
import com.bpcs.svc.UserSvc
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import javax.ejb.EJB

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 1/24/13
 * Time: 6:43 AM
 * To change this template use File | Settings | File Templates.
 */
class WebUserDetailsService implements UserDetailsService
{

    @EJB(mappedName="java:module/UserSvc")
    UserSvc userSvc

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userSvc.getUserByLogin(username)
        if (!user) throw new UsernameNotFoundException()
        WebUserDetails webUserDetails = new WebUserDetails(user)
        return webUserDetails
    }
}
