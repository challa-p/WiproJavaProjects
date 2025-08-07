package Package4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadEvenNumbers4_2{
    public static void main(String[] args) {
         
        String filePath = "C:\\Users\\Pruthvi Naidu\\Downloads\\numbers.txt.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");

            System.out.println("Even numbers from file:");

            while (scanner.hasNext()) {
                int num = Integer.parseInt(scanner.next().trim());
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
