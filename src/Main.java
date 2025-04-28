import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Declare Scanner once

        while (true) {
            System.out.println("---------------POS System---------------");
            System.out.println("1. Add Product");
            System.out.println("2. Show Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("6. Exit");

            System.out.print("Please Select option: ");

            int option;
            try {
                option = Integer.parseInt(scan.nextLine()); // Changed to nextLine()
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue; // Skip to next loop iteration
            }

            Product product = new Product();

            switch (option) {
                case 1:
                    product.AddProduct();
                    break;
                case 2:
                    product.ShowProduct();
                    break;
                case 3:
                    product.UpdateProduct();
                    break;
                case 4:
                    product.DeleteProduct();
                    break;
                case 5:
                    product.SearchProduct();
                    scan.nextLine();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using the POS system!");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option! Please select a number between 1 and 6.");
            }
        }
    }
}
