import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner dogNameScanner = new Scanner(System.in);
        System.out.println("Input dog name:");
        String dogName = dogNameScanner.nextLine();

        String[] dogBreeds = {"Labrador", "Corgi", "German Shepherd", "Golden Retriever", "Husky"};
        double[] percentages = new double[5];
        int percentage = 100;
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            double temp = random.nextInt(percentage) + 1;
            //The line above will generate a number from 1 up to the "remaining" percentage
            percentage -= temp;
            percentages[i] = temp;
        }
        percentages[4] = percentage;
        //The remaining percentage is automatically assigned to the last breed.


        System.out.println(dogName + "'s breed is:");
        for (int i = 0; i < dogBreeds.length; i++) {
            System.out.println(dogBreeds[i] + " - " + Math.round(percentages[i]) + "%");
        }
    }
}
