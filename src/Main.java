import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Question 1:

        // A.
        int[] dataPoints = new int[100];

        // B.
        Random rnd = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // C.
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }

        // D.
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;

        System.out.println("\n\nThe sum of the random array dataPoints is: " + sum + " from inline code.");
        System.out.println("The sum of the random array dataPoints is: " + sum(dataPoints) + " from function.");
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Question 2:
        // A.
        int userInput = SafeInput.getRangedInt(new Scanner(System.in), "Enter an integer", 1, 100);

        // B.
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInput) {
                count++;
            }
        }
        System.out.println("The value " + userInput + " is found " + count + " times in the array from inline code.");

        System.out.println("The value " + userInput + " is found " + occurrenceScan(dataPoints, userInput) + " times in the array from function.");

        // C.
        userInput = SafeInput.getRangedInt(new Scanner(System.in), "Enter another integer", 1, 100);
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInput) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The value " + userInput + " was found at array index " + position + " from inline code.");
        } else {
            System.out.println("The value " + userInput + " was not found in the array from inline code.");
        }

        if (contains(dataPoints, userInput) != -1) {
            System.out.println("The value " + userInput + " was found at array index " + position + " from function.");
        }
        else {
            System.out.println("The value " + userInput + " was not found in the array from function.");
        }

        // D.
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("\nMinimum value in the array from inline code: " + min);
        System.out.println("Maximum value in the array from inline code: " + max);

        System.out.println("\nMinimum value in the array from function: " + min(dataPoints));
        System.out.println("Maximum value in the array from function: " + max(dataPoints));

        // E.
        System.out.println("\nAverage of dataPoints is: " + getAverage(dataPoints));
    }

    // E.
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return (double) sum / values.length;
    }

    // Extra Credit:
    public static int min(int[] values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public static int occurrenceScan(int[] values, int target) {
        int count = 0;
        for (int val : values) {
            if (val == target) {
                count++;
            }
        }
        return count;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum;
    }

    public static int contains(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
}