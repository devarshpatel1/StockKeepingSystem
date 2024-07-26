/**
 * Author : Devarsh Patel
 * Filename : Main.java
 * Description: This main file Create, Edit, Delete, Display all product and Display product by SKU.
 * Version : 1.0
 * Date : 26-07-2024
 */

// Imports Time
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

// Main class
public class Main {
    // Product List Method and scanner instance created
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Set the keepLooping condition and set it to trus
        boolean keepLooping = true;
        while (keepLooping) {
            // Printing some instruction to choose options to create,update,delete or print product
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Edit Product by SKU");
            System.out.println("4) Delete Product by SKU");
            System.out.println("5) Display Product by SKU");
            System.out.println("6) Display all Products");
            System.out.println("7) Exit");

            // Declare VAriable to Validate the choice
            boolean validateChoise = true;
            // Loop to check the Validate input and do some operation accroding to user choise
            while (validateChoise){
                try {
                    // Ask the user to choose an option
                    System.out.print("Enter Your Choise :  ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    validateChoise = false;
                    // Swich statements to do some operations according to user choise by calling methods
                    switch (choice) {
                        case 1:
                            createProduct(choice);
                            break;
                        case 2:
                            createProduct(choice);
                            break;
                        case 3:
                            editProductBySku();
                            break;
                        case 4:
                            deleteProductBySku();
                            break;
                        case 5:
                            displayProductBySku();
                            break;
                        case 6:
                            displayAllProducts();
                            break;
                        case 7:
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }catch (Exception e){
                    // This Catch block print error if user input is not numeric
                    System.out.println("Please Enter Numeric Value");
                }
            }
        }
    }

    // Method to create Product
    private static void createProduct(int choice) {
        try {
            // Ask user to enter SKU
            System.out.print("Enter SKU : ");
            String sku = scanner.nextLine();
            // Ask user to enter Product Name
            System.out.print("Enter Product Name : ");
            String name = scanner.nextLine();
            // Ask user to enter Unit cost
            System.out.print("Enter Unit Cost : ");
            double unitCost = Double.parseDouble(scanner.nextLine());
            // Ask user to enter Sale Price
            System.out.print("Enter Sale Price : ");
            double salePrice = Double.parseDouble(scanner.nextLine());
            // Ask user to enter Quantity on hand
            System.out.print("Enter Quantity on hand : ");
            int quantityOnHand = Integer.parseInt(scanner.nextLine());
            // Ask user to enter quantity needed
            System.out.print("Enter Quantity needed : ");
            int quantityNeeded = Integer.parseInt(scanner.nextLine());
            // Ask user to enter Special Instruction.
            System.out.print("Enter Special Instructions : ");
            String specialInstructions = scanner.nextLine();

            // If user choice is 2 then create Pershible Product.
            if(choice == 2){
                // Enter Expiry Date.
                System.out.print("Enter Expiry Date (yyyy-mm-dd) : ");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate inputDate = LocalDate.parse(scanner.nextLine(),dtf);
                Date expiryDate = Date.from(inputDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                // Add Pershiable product
                PerishableProduct perishableProduct = new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions, expiryDate);
                products.add(perishableProduct);
                System.out.println("Perishable Product created successfully.");
            }else {
                // Add Product
                Product product = new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
                products.add(product);
                System.out.println("Product created successfully.");
            }
        } catch (Exception e) {
            // This will print error if user enter invalid data typle
            System.out.println("Error creating product: " );
            System.out.println("Please Enter Valid Data Type"+ e.getMessage());
        }
    }

    // Method to edit product
    private static void editProductBySku() {
        System.out.print("Enter SKU : ");
        String sku = scanner.nextLine();
        Product product = findProductBySku(sku);

        // If the product is null then print no product found
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        // Give options to user to edit the product and re ask all the details
        try {
            // Product Name
            System.out.print("Enter new Product Name : ");
            String name = scanner.nextLine();
            // Unit cost
            System.out.print("Enter new Unit Cost : ");
            double unitCost = Double.parseDouble(scanner.nextLine());
            // Sale Price
            System.out.print("Enter new Sale Price : ");
            double salePrice = Double.parseDouble(scanner.nextLine());
            // Quantity on hand
            System.out.print("Enter new Quantity on hand : ");
            int quantityOnHand = Integer.parseInt(scanner.nextLine());
            // Quantity Needed
            System.out.print("Enter new Quantity needed : ");
            int quantityNeeded = Integer.parseInt(scanner.nextLine());
            // Special Instruction
            System.out.print("Enter new Special Instructions : ");
            String specialInstructions = scanner.nextLine();

            product.setName(name);
            product.setUnitCost(unitCost);
            product.setSalePrice(salePrice);
            product.setQuantityOnHand(quantityOnHand);
            product.setQuantityNeeded(quantityNeeded);
            product.setSpecialInstructions(specialInstructions);

            // If the Product is instance of Perishable Product.
            if(product instanceof PerishableProduct){
                // Enter Expiry Date
                System.out.print("Enter Expiry Date (yyyy-mm-dd) : ");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate inputDate = LocalDate.parse(scanner.nextLine(),dtf);
                Date expiryDate = Date.from(inputDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                ((PerishableProduct) product).setExpiryDate(expiryDate);
            }

            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            // If there is any error in the try block it prints error message
            System.out.println("Error updating product: ");
            System.out.println("Please Enter Valid Data Type"+ e.getMessage());
        }
    }

    // Method to delete Product by SKU
    private static void deleteProductBySku() {
        // Ask user to enter SKU
        System.out.print("Enter SKU : ");
        String sku = scanner.nextLine();
        // Select the product from sku
        Product product = findProductBySku(sku);

        // If product is null, then print product not found
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        // Remove the product from the list
        products.remove(product);
        System.out.println("Product deleted successfully.");
    }

    // Method to Display Product By SKU.
    private static void displayProductBySku() {
        // Ask user to enter SKU.
        System.out.print("Enter SKU of the product to display: ");
        String sku = scanner.nextLine();
        // Select the product by sku.
        Product product = findProductBySku(sku);
        // If the Product does not found then print Product not found.
        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println(product);
        }
    }

    // Method to Display all product
    private static void displayAllProducts() {
        // If there is no product in array, print No Product Available.
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        // Start the for loop for products and printing all the products using loop
        for (Product product : products) {
            System.out.println("  Product  :  " + product.getName());
            System.out.println(product);
        }
    }

    // Method to Find Product By SKU.
    private static Product findProductBySku(String sku) {
        // Start the for loop for product to check the SKU and return Product
        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                return product;
            }
        }
        return null;
    }
}