package com.bpcs.jpa

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Basic
import javax.persistence.Version
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn
import javax.persistence.Column

/**
 * Created with IntelliJ IDEA.
 * User: wpfeiffe
 * Date: 8/25/12
 * Time: 7:40 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
class Employee implements Serializable
{
    @Id @GeneratedValue Long id

    @Version Long version

    @Column(name="FIRST_NAME")
    @Basic String firstName

    @Column(name="LAST_NAME")
    @Basic String lastName

    @Column(name="SSN")
    @Basic String ssn

    @Column(name="TITLE")
    @Basic String title

    @Column(name="ACTIVE")
    @Basic Boolean active

    @Column(name="START_DATE")
    @Basic Date startDate

    @Column(name="EMPLOYEE_TEXT")
    @Basic String employeeText

    @ManyToOne(optional=false)
    @JoinColumn(name="DEPARTMENT_ID")
    Department dept;

    public Employee()
    {
        // set some defaults for new emps
        this.active = true
        this.startDate = new Date()
        this.employeeText = "This is an employee"
    }

    public Employee(String firstName, String lastName, String ssn, String title)
    {
        this.firstName = firstName
        this.lastName = lastName
        this.ssn = ssn
        this.title = title
        this.active = true
        this.startDate = new Date()
        this.employeeText = "This is an employee"

    }

    public String toString()
    {
        return "Employee ID: $id, Version: $version, First: $firstName, Last: $lastName, SSN: $ssn, Title: $title, Dept:${dept.deptName} "
    }

}
