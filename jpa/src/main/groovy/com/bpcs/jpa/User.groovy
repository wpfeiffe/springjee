package com.bpcs.jpa

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Version

/**
 * Implementation of User for use Spring Security.
 * User: wpfeiffe
 * Date: 12/28/12
 * Time: 6:44 AM
 */
@Entity
@Table(name = "USER_ACCT")
class User implements Serializable
{
    @Id @GeneratedValue @Column(name = "USER_ID") Long id

    @Version @Column(name = "VERSION") Long version

    @Column(name = "LOGIN", unique = true)
    @Basic String login

    @Column(name = "PASSWORD")
    @Basic String password

    @Column(name = "CRED_EXPIRE_DATE")
    @Basic Date credExpireDate

    @Column(name = "ACCT_EXPIRE_DATE")
    @Basic Date acctExpireDate

    @Column(name =  "ACCT_LOCKED")
    @Basic Boolean acctLocked

    @Column(name =  "ACCT_ENABLED")
    @Basic Boolean acctEnabled

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<UserRole> roles

}
