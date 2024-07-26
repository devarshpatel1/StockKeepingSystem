/**
 * Author : Devarsh Patel
 * Filename : Product.java
 * Description: This java file creates a class of products and sets their attributes, methods, and constructor.
 * Version : 1.0
 * Date : 19-07-2024
 */

public class Product {
    private String sku;
    private String name;
    private double unitCost;
    private double salePrice;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Default constructor
    public Product() {
        this("12345ABC", "Default Product", 0.0, 0.0, 0, 0, "None");
    }

    // Parametrized constructor
    public Product(String sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setName(name);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantityOnHand);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // Getters and Setters with validation

    // Getter for SKU
    public String getSku() {
        return sku;
    }

    // Setter for SKU with the Validation.
    public void setSku(String sku) {
        if (sku.length() >= 8) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("SKU must be at least 8 digits.");
        }
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Setter for Name
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
    }

    // Getter for UnitCost
    public double getUnitCost() {
        return unitCost;
    }

    // Setter for UnitCost
    public void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit cost must be >= 0.");
        }
    }

    // Getter for Sale Price
    public double getSalePrice() {
        return salePrice;
    }

    // Setter for Sale Price
    public void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("Sale price must be >= 0.");
        }
    }

    // Getter for Quantity on Hand
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    // Setter for Quantity on Hand
    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand >= 0) {
            this.quantityOnHand = quantityOnHand;
        } else {
            throw new IllegalArgumentException("Quantity on hand must be >= 0.");
        }
    }

    // Getter for Quantity Needed
    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    // Setter for Quantity Needed
    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("Quantity needed must be >= 0.");
        }
    }

    // Getter for Special Instructions
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    // Setter for Special Instructions
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // toString Method to print all the attributes of the class
    public String toString() {
        return "SKU: " + sku + "\n" +
                "Product Name: " + name + "\n" +
                "Unit Cost: $" + unitCost + "\n" +
                "Sale Price: $" + salePrice + "\n" +
                "Quantity on hand: " + quantityOnHand + "\n" +
                "Quantity Needed: " + quantityNeeded + "\n" +
                "Special Instructions: " + specialInstructions;
    }
}