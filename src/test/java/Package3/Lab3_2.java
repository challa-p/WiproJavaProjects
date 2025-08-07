package Package3;

import java.util.Scanner;
 
class AgeNotValidException extends Exception {
 public AgeNotValidException(String message) {
     super(message);
 }
}

 
class Person {
 private String name;
 private int age;

 
 public Person(String name, int age) throws AgeNotValidException {
     if (age <= 15) {
         throw new AgeNotValidException("Age must be above 15.");
     }
     this.name = name;
     this.age = age;
 }
 
 public void displayPerson() {
     System.out.println("\n--- Person Details ---");
     System.out.println("Name: " + name);
     System.out.println("Age : " + age);
 }
}

 
public class Lab3_2 {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     try {
          System.out.print("Enter Name: ");
         String name = sc.nextLine();

         System.out.print("Enter Age: ");
         int age = sc.nextInt();

          Person p = new Person(name, age);
         p.displayPerson();

     } catch (AgeNotValidException e) {
         System.out.println("Exception caught: " + e.getMessage());
     }

     sc.close();
 }
}

