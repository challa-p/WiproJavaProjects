package Package4;

import java.util.*;
 
class Employee {
 private int id;
 private String name;
 private double salary;
 private String designation;
 private String insuranceScheme;

 public Employee(int id, String name, double salary, String designation, String insuranceScheme) {
     this.id = id;
     this.name = name;
     this.salary = salary;
     this.designation = designation;
     this.insuranceScheme = insuranceScheme;
 }

 public String getInsuranceScheme() {
     return insuranceScheme;
 }

 @Override
 public String toString() {
     return "ID: " + id +
            ", Name: " + name +
            ", Salary: " + salary +
            ", Designation: " + designation +
            ", Insurance Scheme: " + insuranceScheme;
 }
}

 
public class Lab4_4 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     HashMap<Integer, Employee> employeeMap = new HashMap<>();

     while (true) {
         System.out.println("\n--- Employee Management Menu ---");
         System.out.println("1. Add Employee");
         System.out.println("2. Display Employees by Insurance Scheme");
         System.out.println("3. Delete Employee");
         System.out.println("4. Display All Employees");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         int choice = sc.nextInt();
         sc.nextLine(); // consume newline

         switch (choice) {
             case 1: 
                 System.out.print("Enter Employee ID: ");
                 int id = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter Name: ");
                 String name = sc.nextLine();
                 System.out.print("Enter Salary: ");
                 double salary = sc.nextDouble();
                 sc.nextLine();
                 System.out.print("Enter Designation: ");
                 String designation = sc.nextLine();
                 System.out.print("Enter Insurance Scheme: ");
                 String scheme = sc.nextLine();

                 Employee emp = new Employee(id, name, salary, designation, scheme);
                 employeeMap.put(id, emp);
                 System.out.println("Employee added successfully!");
                 break;

             case 2:  
                 System.out.print("Enter Insurance Scheme to search: ");
                 String searchScheme = sc.nextLine();
                 boolean found = false;
                 for (Employee e : employeeMap.values()) {
                     if (e.getInsuranceScheme().equalsIgnoreCase(searchScheme)) {
                         System.out.println(e);
                         found = true;
                     }
                 }
                 if (!found) {
                     System.out.println("No employees found with scheme: " + searchScheme);
                 }
                 break;

             case 3:  
                 System.out.print("Enter Employee ID to delete: ");
                 int delId = sc.nextInt();
                 if (employeeMap.remove(delId) != null) {
                     System.out.println("Employee deleted successfully!");
                 } else {
                     System.out.println("Employee ID not found!");
                 }
                 break;

             case 4:  
                 if (employeeMap.isEmpty()) {
                     System.out.println("No employees to display.");
                 } else {
                     for (Employee e : employeeMap.values()) {
                         System.out.println(e);
                     }
                 }
                 break;

             case 5:  
                 System.out.println("Exiting...");
                 sc.close();
                 return;

             default:
                 System.out.println("⚠️ Invalid choice, please try again.");
         }
     }
 }
}
