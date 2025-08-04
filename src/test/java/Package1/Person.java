package Package1;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private Gender gender;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.phoneNumber = "Not Provided";
        this.gender = Gender.M; // Default gender
    }

    // Parameterized constructor
    public Person(String name, int age, String phoneNumber, Gender gender) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    // Method to set phone number separately
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Person Details:");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Phone  : " + phoneNumber);
        System.out.println("Gender : " + gender.getDisplayName());
    }
}


