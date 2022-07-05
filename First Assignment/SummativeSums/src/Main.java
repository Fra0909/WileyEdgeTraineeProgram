import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6};
        System.out.println(arraySum(test));
    }

    static int arraySum(int[] array) {
        int total = 0;

        for (int j : array) {
            total += j;
        }
        return total;
    }
    //The method above simply sums up all the elements of the array that gets passed to it and returns the total.
}
