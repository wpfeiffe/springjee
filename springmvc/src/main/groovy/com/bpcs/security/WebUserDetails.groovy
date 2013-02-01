package com.bpcs.security

import com.bpcs.jpa.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Spring Security UserDetails implementation wrapping User entity
 * User: wpfeiffe
 * Date: 1/24/13
 */
class WebUserDetails implements UserDetails
{
    // User entity
    User user

    WebUserDetails(User user)
    {
        this.user = user
    }

    Collection<? extends GrantedAuthority> getAuthorities()
    {
        return user.roles
    }

    String getPassword()
    {
        return user.password
    }

    String getUsername()
    {
        return user.login
    }

    boolean isAccountNonExpired()
    {
        return user.acctExpireDate.after(new Date())
    }

    boolean isAccountNonLocked()
    {
        return !user.acctLocked
    }

    boolean isCredentialsNonExpired()
    {
        return user.credExpireDate.after(new Date())
    }

    boolean isEnabled()
    {
        return user.acctEnabled
    }
}
