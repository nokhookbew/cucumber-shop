package ku.shop;

public class Product {
    private double price;
    private String name;
    private int quantity;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() { return quantity; }

    public void quantityAfterBuy(int quantity) { this.quantity -= quantity; }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }
}
