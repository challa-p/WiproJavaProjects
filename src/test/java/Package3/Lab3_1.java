package Package3;

import java.util.Scanner;
 
class NameNotValidException extends Exception {
 public NameNotValidException(String message) {
     super(message);
 }
}

 class Employee {
 private int empId;
 private String firstName;
 private String lastName;
 private double salary;

 
 public Employee(int empId, String firstName, String lastName, double salary) throws NameNotValidException {
     if (firstName == null || firstName.trim().isEmpty() ||
         lastName == null || lastName.trim().isEmpty()) {
         throw new NameNotValidException("First name or Last name cannot be blank.");
     }
     this.empId = empId;
     this.firstName = firstName;
     this.lastName = lastName;
     this.salary = salary;
 }

 
 public void displayEmployee() {
     System.out.println("\n--- Employee Details ---");
     System.out.println("Employee ID: " + empId);
     System.out.println("Full Name  : " + firstName + " " + lastName);
     System.out.println("Salary     : " + salary);
 }
}

 
public class Lab3_1 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     try {
          
         System.out.print("Enter Employee ID: ");
         int empId = sc.nextInt();
         sc.nextLine(); 

         System.out.print("Enter First Name: ");
         String firstName = sc.nextLine();

         System.out.print("Enter Last Name: ");
         String lastName = sc.nextLine();

         System.out.print("Enter Salary: ");
         double salary = sc.nextDouble();

          
         Employee emp = new Employee(empId, firstName, lastName, salary);
         emp.displayEmployee();

     } catch (NameNotValidException e) {
         System.out.println("Exception caught: " + e.getMessage());
     }

     sc.close();
 }
}

