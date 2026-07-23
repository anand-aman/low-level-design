package com.lld.structural.facade;

public class EmployeeDAO {

    public void insert() {
        //insert into employee table
    }

    public void updateEmployeeName() {
        //updating employee name
    }

    public Employee getEmployeeDetails(String emailId) {
        //get employee details based on Email Id
        return new Employee();
    }

    public Employee getEmployeeDetails(int empId) {
        //get employee details based on Emp ID
        return new Employee();
    }
}
