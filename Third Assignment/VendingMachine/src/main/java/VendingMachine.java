import java.math.BigDecimal;

public class VendingMachine {

    //This method will process the transaction; it will first check if the item is available, and if so it will
    //proceed to check if the money inserted is enough. If the item is unavailable or the money is insufficient
    //custom exceptions will be thrown, and custom messages printed. If everything goes smoothly, the transaction
    //will proceed and the amount of that specific item in stock will decrease by 1.
    public static void attemptTransactiton(Item item, BigDecimal insertedMoney) {
        try {
            if (!(item.getStock() > 0)) {
                throw new ZeroStockException();
            } else {
                if (insertedMoney.compareTo(item.getPrice()) > 0) {
                    Change.printChange(Change.calculateChange(insertedMoney, item.getPrice()));
                    item.decreaseStock();
                } else {
                    throw new InsufficientFundsException();
                }
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds! The item costs $" + item.getPrice().doubleValue() / 100 + ".");
        } catch (ZeroStockException e) {
            System.out.println("There is no " + item.getName() + " in stock!");
        }
    }
}
