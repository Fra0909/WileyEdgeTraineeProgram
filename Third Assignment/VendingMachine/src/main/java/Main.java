import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileHandler.loadFromFile();
        Scanner amountScanner = new Scanner(System.in);

        Item.printInventory();
        System.out.println("Insert the amount of money in pennies (Ex. £5 -> 500).\nInsert '" +
                (Item.amountOfItems + 1) + "' to exit.");

        BigDecimal insertedMoney = new BigDecimal(amountScanner.nextLine());

        //Just a hacky way to calculate the value to exit the program
        if (insertedMoney.intValue() == Item.amountOfItems + 1) {
            System.out.println("Goodbye!");
            return;
        }

        Scanner itemScanner = new Scanner(System.in);
        System.out.println("Insert an item ID: ");
        Item item = Item.items.get(Integer.parseInt(itemScanner.nextLine()) - 1);
        System.out.println("Selected: " + item.getName() + "\nPrice: $" + item.getPrice().doubleValue() / 100);
        VendingMachine.attemptTransactiton(item,insertedMoney);
        FileHandler.saveToFile();
    }
}
