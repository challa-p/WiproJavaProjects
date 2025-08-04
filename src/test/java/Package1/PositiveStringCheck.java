package Package1;

public class PositiveStringCheck {

    public static boolean isPositiveString(String input) {
         
        input = input.toUpperCase();

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) <= input.charAt(i - 1)) {
                
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPositiveString("ANT"));     
        System.out.println(isPositiveString("APPLE")); 
        System.out.println(isPositiveString("ABC"));     
        System.out.println(isPositiveString("ACB"));     
    }
}
