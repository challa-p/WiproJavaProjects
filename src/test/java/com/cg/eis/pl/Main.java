 package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();

        System.out.println("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter Designation (System Associate / Programmer / Manager): ");
        String designation = sc.nextLine();

        Employee emp = new Employee(id, name, salary, designation);
        service.getEmployeeDetails(emp);
        service.displayEmployeeDetails(emp);

        sc.close();
    }
}
