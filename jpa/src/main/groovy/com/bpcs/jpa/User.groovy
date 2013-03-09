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
    /**
     * Id for this User
     */
    @Id @GeneratedValue @Column(name = "USER_ID") Long id

    /**
     * version for ORM optimistic locking
     */
    @Version @Column(name = "VERSION") Long version

    /**
     * User login value
     */
    @Column(name = "LOGIN", unique = true)
    @Basic String login

    /**
     * encrypted password value
     */
    @Column(name = "PASSWORD")
    @Basic String password

    /**
     * Date of credential expiration
     */
    @Column(name = "CRED_EXPIRE_DATE")
    @Basic Date credExpireDate

    /**
     * Date the account expires
     */
    @Column(name = "ACCT_EXPIRE_DATE")
    @Basic Date acctExpireDate

    /**
     * Flag indicates if this User account is locked
     */
    @Column(name =  "ACCT_LOCKED")
    @Basic Boolean acctLocked

    /**
     * Flag indicates if this User account is enabled
     */
    @Column(name =  "ACCT_ENABLED")
    @Basic Boolean acctEnabled

    /**
     * List of roles for this given user
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<UserRole> roles

}
