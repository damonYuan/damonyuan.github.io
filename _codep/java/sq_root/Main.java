import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        SqRoot r = new SqRoot(number);
        System.out.println(r.getRoot());
    }

    private static class SqRoot {
        private double mValue;
        private double mAccuracy;
        private int mRound;

        SqRoot(double value, double accuracy, int round) {
            if (value < 0) {
                throw new RuntimeException("value should >= 0");
            } 
            if (accuracy <= 0) {
                throw new RuntimeException("accuracy should > 0");
            }
            if (round <= 0) {
                throw new RuntimeException("round should > 0");
            }
            mValue = value;
            mAccuracy = accuracy;
            mRound = round;
        }

        SqRoot(double value) {
            this(value, 0.0001f, 3);
        }

        private SqRoot() {}

        double getRoot() {
            double prev = 10;
            double next = 10;

            do {
                prev = next;
                next = (mValue + prev * prev) / (2 * prev);
                // System.out.println("prev: " + prev);
                // System.out.println("next: " + next);
            } while (Math.abs(prev - next) > mAccuracy);

            return Math.round(next * Math.pow(10, mRound)) / Math.pow(10, mRound);
        }
    }
}
