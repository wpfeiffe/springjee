package com.bpcs.jpa

import org.springframework.security.core.GrantedAuthority

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Version

/**
 * Implementation of role for Spring Security
 * User: wpfeiffe
 * Date: 12/28/12
 * Time: 6:51 AM
 */
@Entity
@Table(name = "USER_ROLE")
class UserRole implements Serializable, GrantedAuthority
{
    /**
     * Id for this UserRole
     */
    @Id @GeneratedValue @Column(name = "USER_ROLE_ID") Long id

    /**
     * version for ORM optimistic locking
     */
    @Version @Column(name = "VERSION") Long version

    /**
     * Role name for associated user
     */
    @Column(name = "ROLE_NAME")
    @Basic String roleName

    /**
     * User associated to this role
     */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    User user

    /**
     * get the role name
     * @return role name
     */
    String getAuthority()
    {
        roleName
    }

    /**
     * toString returns role name
     * @return role name
     */
    String toString()
    {
        roleName
    }
}
