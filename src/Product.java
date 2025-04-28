import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Product {
    public int id;
    public String name;
    public double price;
    public int qty;

    static ArrayList<Product> ProductList = new ArrayList<>();

    public double CalculateAmount() {
        return this.price * this.qty;
    }

    public void AddProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.println("-----------------Add Product-----------------");
        System.out.print("How many products do you want to add? : ");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            Product newProduct = new Product();

            System.out.println("Product " + (i + 1));

            System.out.print("Input Id: ");
            newProduct.id = Integer.parseInt(scan.nextLine());

            System.out.print("Input Name: ");
            newProduct.name = scan.nextLine();

            System.out.print("Input Qty: ");
            newProduct.qty = Integer.parseInt(scan.nextLine());

            System.out.print("Input Price: ");
            newProduct.price = Double.parseDouble(scan.nextLine());

            ProductList.add(newProduct);
            System.out.println("✅ Product added successfully!");
        }
    }

    public void ShowProduct() {
        System.out.println("------------------------Product List------------------------");
        String columnHeader = String.format("%-5s %-15s %10s %10s %15s",
                "Id", "Name", "Qty", "Price", "Amount");

        System.out.println(columnHeader);
        System.out.println("------------------------------------------------------------");

        for (var item : ProductList) {
            String rows = String.format("%-5d %-15s %10d %10.2f %15.2f",
                    item.id, item.name, item.qty, item.price, item.CalculateAmount());
            System.out.println(rows);
        }
    }

    public void UpdateProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the product ID to update: ");
        int searchId = Integer.parseInt(scan.nextLine());

        boolean found = false;

        for (var item : ProductList) {
            if (item.id == searchId) {
                found = true;
                System.out.println("Updating Product ID: " + searchId);

                System.out.print("Enter new name: ");
                item.name = scan.nextLine();

                System.out.print("Enter new Qty: ");
                item.qty = Integer.parseInt(scan.nextLine());

                System.out.print("Enter new Price: ");
                item.price = Double.parseDouble(scan.nextLine());

                System.out.println("✅ Product updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Product not found!");
        }
    }

    public void DeleteProduct() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the product ID to delete: ");
        int deleteId = Integer.parseInt(scan.nextLine());


        Iterator<Product> iterator = ProductList.iterator();

        boolean found = false;

        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (item.id == deleteId) {
                iterator.remove();
                System.out.println("✅ Product with ID " + deleteId + " has been deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Product with ID " + deleteId + " does not exist in the system.");
        }
    }

    public void SearchProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the product ID to search: ");
        int searchProId = Integer.parseInt(scan.nextLine());

        boolean found = false;
        for (var item : ProductList) {
            if (item.id == searchProId) {
                System.out.println("✅ Product found:");
                System.out.println("------------------------------------");
                System.out.printf("ID: %d\nName: %s\nQty: %d\nPrice: %.2f\nAmount: %.2f\n",
                        item.id, item.name, item.qty, item.price, item.CalculateAmount());
                System.out.println("------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Product not found!");
        }
    }
}
