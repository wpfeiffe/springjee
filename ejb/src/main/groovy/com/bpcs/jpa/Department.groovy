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
    /**
     * id of department
     */
    @Id @GeneratedValue Long id
    @Version Long version

    /**
     * department code
     */
    @Column(name="DEPT_CODE")
    @Basic String deptCode

    /**
     * departement name
     */
    @Column(name="DEPT_NAME")
    @Basic String deptName

    /**
     * departement text
     */
    @Column(name="DEPARTMENT_TEXT")
    @Basic String deptText

    /**
     * Empty constructor
     */
    public Department() {}

    /**
     * Constructor with data values
     * @param deptCode
     * @param deptName
     */
    public Department(String deptCode, String deptName, String deptText)
    {
        this.deptCode = deptCode
        this.deptName = deptName
        this.deptText = deptText

    }

    /**
     * Returns string representation of department
     * @return string representation of department
     */
    public String toString()
    {
        return "Department ID: $id, Version: $version, Name: $deptName, Code: $deptCode, Text: $deptText"
    }


}
