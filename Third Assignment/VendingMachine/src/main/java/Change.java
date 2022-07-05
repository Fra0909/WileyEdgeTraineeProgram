import java.math.BigDecimal;

enum Money {
    QUARTER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);

    private final int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

public class Change {

    public static int[] calculateChange(BigDecimal amountInserted, BigDecimal itemPrice) {

        //Calculating change and returning an array with the four different coins and the total amount.

        int change = amountInserted.subtract(itemPrice).intValue();
        int remainingAmount = change;

        int numberOfQuarters = remainingAmount / Money.QUARTER.getValue();
        remainingAmount = remainingAmount % Money.QUARTER.getValue();

        int numberOfDimes = remainingAmount / Money.DIME.getValue();
        remainingAmount = remainingAmount % Money.DIME.getValue();

        int numberOfNickels = remainingAmount / Money.NICKEL.getValue();
        remainingAmount = remainingAmount % Money.NICKEL.getValue();

        int numberOfPennies = remainingAmount / Money.PENNY.getValue();

        return new int[]{numberOfQuarters, numberOfNickels, numberOfDimes, numberOfPennies, change};
    }

    //Method to print the change given in a nicely formatted way
    public static void printChange(int[] change) {
        System.out.println("This is your change (" + (double) change[4] / 100 + "$):\nQuarters (0.25$): " +
                change[0] + "\nDimes (0.10$): " + change[1] + "\nNickels ($0.05): " + change[2] +
                "\nPennies ($0.01): " + change[3]);
    }
}
