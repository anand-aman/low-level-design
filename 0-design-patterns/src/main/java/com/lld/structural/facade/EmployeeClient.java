package com.lld.structural.facade;

public class EmployeeClient {

    public void getEmployeeDetails() {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        Employee employeeDetails = employeeFacade.getEmployeeDetails(121222);
    }
}
