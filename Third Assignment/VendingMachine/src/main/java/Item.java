import java.math.BigDecimal;
import java.util.ArrayList;

public class Item {
    private final BigDecimal price;
    private int stock;
    private final String name;
    private final int itemId;
    public static ArrayList<Item> items = new ArrayList<>();
    public static int amountOfItems = 0;


    public Item(String[] attributes) {
        this.name = attributes[0];
        this.price = new BigDecimal(attributes[1]);
        this.stock = Integer.parseInt(attributes[2]);
        this.itemId = amountOfItems + 1;
        amountOfItems++;
        items.add(this);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setStock(int amount) {
        this.stock = amount;
    }

    public void decreaseStock() {
        this.setStock(this.getStock() - 1);
    }

    @Override
    public String toString() {
        return this.getName() + "," + this.getPrice() + "," + this.getStock();
    }

    //Method to print all the items using a lambda function.
    public static void printInventory() {
        items.forEach(item -> System.out.println("Id: " + item.getItemId()
                + ", Item: " + item.getName() + ", Price: " + item.getPrice().divide(new BigDecimal(100))));
    }



}
