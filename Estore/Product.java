package Estore;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private String productDescription;
    private ProductCategory productCategory;

    public Product(int productId, String productName, double price, String productDescription, ProductCategory productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
    }
}
