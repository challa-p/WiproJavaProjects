package Package4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductListSort4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();

        System.out.println("Enter number of products:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter product names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Product " + (i + 1) + ": ");
            products.add(sc.nextLine());
        }

        // Sort the ArrayList
        Collections.sort(products);

        // Display sorted names using for-each loop
        System.out.println("\nSorted Product Names:");
        for (String product : products) {
            System.out.println(product);
        }

        sc.close();
    }
}
