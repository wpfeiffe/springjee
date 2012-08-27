package com.bpcs.jpa

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Basic
import javax.persistence.Version
import javax.persistence.Column

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 8/25/12
 * Time: 7:34 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
class Department implements Serializable
{
    @Id @GeneratedValue Long id
    @Version Long version

    @Column(name="DEPT_CODE")
    @Basic String deptCode

    @Column(name="DEPT_NAME")
    @Basic String deptName

    public Department() {}

    public Department(String deptCode, String deptName)
    {
        this.deptCode = deptCode
        this.deptName = deptName

    }

    public String toString()
    {
        return "Department ID: $id, Version: $version, Name: $deptName, Code: $deptCode"
    }


}
