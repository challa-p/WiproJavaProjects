package Package4;

import java.io.*;


public class FileContentReverser4_1 {
    public static void main(String[] args) {
        
        String filePath = "C:\\Users\\Pruthvi Naidu\\Downloads\\sample.txt.txt";

        try {
           
            FileReader reader = new FileReader(filePath);
            StringBuilder content = new StringBuilder();

            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            reader.close();

             
            content.reverse();

            
            FileWriter writer = new FileWriter(filePath);
            writer.write(content.toString());
            writer.close();

            System.out.println("File content reversed and saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

   