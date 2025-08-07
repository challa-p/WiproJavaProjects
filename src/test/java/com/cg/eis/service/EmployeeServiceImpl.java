package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void getEmployeeDetails(Employee emp) {
        // Set insurance scheme based on salary & designation
        emp.setInsuranceScheme(determineInsuranceScheme(emp));
    }

    @Override
    public String determineInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String desig = emp.getDesignation().toLowerCase();

        if (salary >= 5000 && salary < 20000 && desig.equals("system associate")) {
            return "Scheme C";
        } else if (salary >= 20000 && salary < 40000 && desig.equals("programmer")) {
            return "Scheme B";
        } else if (salary >= 40000 && desig.equals("manager")) {
            return "Scheme A";
        } else {
            return "No Scheme";
        }
    }

    @Override
    public void displayEmployeeDetails(Employee emp) {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID          : " + emp.getId());
        System.out.println("Name        : " + emp.getName());
        System.out.println("Salary      : ₹" + emp.getSalary());
        System.out.println("Designation : " + emp.getDesignation());
        System.out.println("Insurance   : " + emp.getInsuranceScheme());
    }
}
