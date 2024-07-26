/**
 * Author : Devarsh Patel
 * Filename : PerishableProduct.java
 * Description: This java file creates a class for perishable products and sets their attributes, methods, and constructor.
 * Version : 1.0
 * Date : 25-07-2024
 */

import java.util.Date;
import java.text.SimpleDateFormat;

public class PerishableProduct extends Product {
    private Date expiryDate;

    // Default constructor
    public PerishableProduct() {
        super();
        this.expiryDate = new Date();
    }

    // Parametrized constructor
    public PerishableProduct(String sku, String name, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions, Date expiryDate) {
        super(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
        this.expiryDate = expiryDate;
    }

    // Getter and Setter for expiryDate
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Override display method
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return super.toString() + "\n" +
                "Expiry Date: " + dateFormat.format(expiryDate);
    }
}
