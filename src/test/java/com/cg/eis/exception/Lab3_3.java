package com.cg.eis.exception;

import java.util.Scanner;
import com.cg.eis.exception.EmployeeException;

public class Lab3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            if (salary < 3000) {
                throw new EmployeeException("Salary should not be less than 3000.");
            }

            System.out.println("\nEmployee Name: " + name);
            System.out.println("Employee Salary: " + salary);
        } catch (EmployeeException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
