import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    void areCoinValuesAccurate() {
        assertEquals(Money.QUARTER.getValue(), 25);
        assertEquals(Money.DIME.getValue(), 10);
        assertEquals(Money.NICKEL.getValue(), 5);
        assertEquals(Money.PENNY.getValue(), 1);
    }

    @Test
    void isChangeAmountCorrect() {
        var amountInserted = new BigDecimal("500");
        var itemPrice = new BigDecimal("400");
        assertEquals(Change.calculateChange(amountInserted, itemPrice)[4], 100);

        itemPrice = new BigDecimal("100");
        assertEquals(Change.calculateChange(amountInserted, itemPrice)[4], 400);

    }

    @Test
    void doesTransactionDecreaseStock() {
        Item testItem = new Item(new String[]{"TEST", "100", "10"});
        testItem.decreaseStock();
        assertEquals(testItem.getStock(), 9);
    }

    @Test
    void doesLoadingDataFromFileWork() {
        FileHandler.loadFromFile();
        assertNotEquals(Item.items.size(), 0);
    }

    @Test
    void doesSavingDataFromFileWork() {
        FileHandler.loadFromFile();
        Item testItem = Item.items.get(0);
        testItem.decreaseStock();
        FileHandler.saveToFile();

        FileHandler.loadFromFile();
        Item testItem2 = Item.items.get(0);
        assertEquals(testItem.getStock(), testItem2.getStock());
    }

    @Test
    void doesCreatingItemInstanceAddItToArraylist() {
        Item testItem = new Item(new String[]{"TEST", "100", "10"});
        assertEquals(Item.items.get(Item.items.size() - 1), testItem);
    }

    @Test()
    void notEnoughMoneyThrowsException() {
        var insertedAmount = new BigDecimal("100");
        Item testItem = new Item(new String[]{"TEST", "100", "10"});

        VendingMachine.attemptTransactiton(testItem, insertedAmount);
    }

    @Test()
    void zeroStockException() {
        var insertedAmount = new BigDecimal("100");
        Item testItem = new Item(new String[]{"TEST", "100", "0"});

        VendingMachine.attemptTransactiton(testItem, insertedAmount);

    }

}
