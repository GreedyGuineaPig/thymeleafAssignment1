public class Item {
    public final String name;
    public final int quantity;
    public final double itemPrice;

    public Item(String name, int quantity, double itemPrice) {
        this.name = name;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getTotalPrice() {
        return quantity * itemPrice;
    }
}
