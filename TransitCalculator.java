import java.util.ArrayList;
import java.util.Scanner;

public class TransitCalculator {
    int days;
    int individualRides;


    String[] options = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] fare = {2.75, 33.00, 127.00};

    public TransitCalculator(int numDays, int numRides) {
        if (numDays >= 1 && numDays <= 30 && numRides > 1) {
            days = numDays;
            individualRides = numRides;
        } else System.out.println("Invalid options!");
    }

    public double unlimited7Price() {
        double weeks = Math.ceil(((double) days / 7));
        double pricePerRide;

        pricePerRide = fare[1] / individualRides * weeks;
        return Math.round(pricePerRide * 100.0) / 100.0;

    }

    public ArrayList<Double> getRidePrices() {
        ArrayList<Double> pricePerRide = new ArrayList<>();
        pricePerRide.add(fare[0]);
        pricePerRide.add(unlimited7Price());
        pricePerRide.add(Math.round((fare[2] / individualRides) * 100.0) / 100.0);
        return pricePerRide;
    }

    public String getBestFare() {
        double lowestPrice = getRidePrices().get(0);
        String bestFare = "";

        for (int i = 0; i < 3; i++) {
            if (getRidePrices().get(i) < lowestPrice) {
                lowestPrice = getRidePrices().get(i);
                bestFare = options[i];
            }
        }
        String message = "You should get the " + bestFare + "option at $" + lowestPrice + " per ride";
        return message;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rides: ");
        int rides = input.nextInt();
        System.out.print("Enter the number of days: ");
        int days = input.nextInt();


        TransitCalculator tc = new TransitCalculator(days, rides);
        System.out.println(tc.getBestFare());


    }
}
