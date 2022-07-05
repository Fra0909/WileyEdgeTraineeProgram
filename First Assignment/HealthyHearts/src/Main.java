import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ageScanner = new Scanner(System.in);
        double MAXIMUMHEARTRATE = 220;
        System.out.println("Input your age.");
        double age = ageScanner.nextDouble();

        System.out.println("Your maximum heart rate is: " +(int)(MAXIMUMHEARTRATE-age));

        int minimumHeartRate = (int) ((MAXIMUMHEARTRATE-age)/100*50);
        int maximumHeartRate = (int) ((MAXIMUMHEARTRATE-age)/100*80);

        System.out.println("Your ideal heart rate is between " + minimumHeartRate + " and " + maximumHeartRate);
    }
}
