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
    /**
     * Employee identifier
     */
    @Id @GeneratedValue Long id

    /**
     * ORM version for optimistic locking
     */
    @Version Long version

    /**
     * first name
     */
    @Column(name="FIRST_NAME")
    @Basic String firstName

    /**
     * last name
     */
    @Column(name="LAST_NAME")
    @Basic String lastName

    /**
     * Social Security Number
     */
    @Column(name="SSN")
    @Basic String ssn

    /**
     * Job title
     */
    @Column(name="TITLE")
    @Basic String title

    /**
     * indicates if employee is active
     */
    @Column(name="ACTIVE")
    @Basic Boolean active

    /**
     * Employee start date
     */
    @Column(name="START_DATE")
    @Basic Date startDate

    /**
     * Text about the employee
     */
    @Column(name="EMPLOYEE_TEXT")
    @Basic String employeeText

    /**
     * Department of the employee
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="DEPARTMENT_ID")
    Department dept;

    /**
     * basic constructor
     */
    public Employee()
    {
        // set some defaults for new emps
        this.active = true
        this.startDate = new Date()
        this.employeeText = "This is an employee"
    }

    /**
     * Full constructor
     * @param firstName
     * @param lastName
     * @param ssn
     * @param title
     */
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

    /**
     * toString
     * @return string value of Employee
     */
    public String toString()
    {
        return "Employee ID: $id, Version: $version, First: $firstName, Last: $lastName, SSN: $ssn, Title: $title, Dept:${dept.deptName} "
    }

}
