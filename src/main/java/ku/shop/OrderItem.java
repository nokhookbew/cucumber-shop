package ku.shop;

public class OrderItem {
    private int quantity;
    private Product prod;

    public OrderItem(Product prod, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("OrderItem quantity must be positive");

        this.prod = prod;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return prod.getPrice() * quantity;
    }

    public void checkStock() throws NotEnoughException{
        if (this.quantity <= prod.getQuantity()) {
            prod.quantityAfterBuy(quantity);
        }
        else {
            throw new NotEnoughException("Product not enough.");
        }
    }

}
