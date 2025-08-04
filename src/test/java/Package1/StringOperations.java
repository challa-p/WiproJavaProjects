package Package1;

public class StringOperations {

    public static String performOperation(String input, int choice) {
        switch (choice) {
            case 1:
               
                return input + input;
                
            case 2:
                
                StringBuilder replaced = new StringBuilder(input);
                for (int i = 0; i < replaced.length(); i++) {
                    if (i % 2 == 0) { 
                        replaced.setCharAt(i, '#');
                    }
                }
                return replaced.toString();
                
            case 3:
                
                StringBuilder noDuplicates = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (noDuplicates.indexOf(String.valueOf(c)) == -1) {
                        noDuplicates.append(c);
                    }
                }
                return noDuplicates.toString();
                
            case 4:
               
                StringBuilder oddUpper = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (i % 2 == 0) {  
                        oddUpper.append(Character.toUpperCase(c));
                    } else {
                        oddUpper.append(c);
                    }
                }
                return oddUpper.toString();
                
            default:
                return "Invalid choice";
        }
    }

    public static void main(String[] args) {
        String test = "program";
        
        System.out.println(performOperation(test, 1)); // Add string to itself
        System.out.println(performOperation(test, 2)); // Replace odd positions with '#'
        System.out.println(performOperation(test, 3)); // Remove duplicates
        System.out.println(performOperation(test, 4)); // Change odd chars to uppercase
    }
}
