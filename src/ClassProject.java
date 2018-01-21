/* Nico Julian, CS&141, Project 1, 1/13/18 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class ClassProject {

    public static void main(String[] args) {
        Scanner scan;
        Random random;
        int maxValue = 0;
        int minValue = 0;
        int randomNumber;
        int arrayTotal;
        int[] randomArray = new int[20];
        boolean validInput;
        boolean keepGoing;

        // This outer do while loop will run the program once, then allow the user to choose if they wish to continue.
        do {
            arrayTotal = 0;

            // This inner do while loop will run once, then prompt for new values if minValue > maxValue.
            do {

                // This do while will run once, then prompt for a new 'maxValue' if the user enters something other than a number.
                do {
                    // Try catch to avoid input errors stopping the program.
                    try {
                        System.out.print("\nPlease enter the max random integer: ");
                        scan = new Scanner(System.in);
                        maxValue = scan.nextInt();
                        validInput = true;
                    } catch (InputMismatchException ime) {
                        validInput = false;
                        System.out.println("\nInput must be an integer value.");
                    }
                } while (!validInput);

                // This do while will run once, then prompt for a new 'minValue' if the user enters something other than a number.
                do {
                    // Try catch to avoid input errors stopping the program.
                    try {
                        System.out.print("Please enter the minimum random integer: ");
                        scan = new Scanner(System.in);
                        minValue = scan.nextInt();
                        validInput = true;
                    } catch (InputMismatchException ime) {
                        validInput = false;
                        System.out.println("\nInput must be an integer value.");
                    }
                } while (!validInput);

                // Checks for invalid values and alerts the user if there's an error.
                if (maxValue < minValue) {
                    System.out.println("\nMax value must be greater than minimum value.");
                }

            } while (maxValue < minValue);

            // This for loop goes for 20 iterations; once for each index in the array 'randomArray'.
            for (int i = 0; i < 20; i++) {
                /* During each iteration the follow steps take place:
                  1) A new random is generated and stored in the variable 'random'.
                  2) This variable is bumped up to the next integer, getting rid any decimal value.
                  3) Its absolute value is taken.
                  4) This value is now divided by the difference between 'maxValue' and 'minValue' plus one.
                  5) Any remainder produced from the last step plus the minimum value given is now stored into the variable 'randomNumber'.
                  6) 'randomNumber' is stored in 'randomArray' at the current i index.
                  7) The value of 'randomNumber' is added to 'arrayTotal'.
                */
                random = new Random();
                randomNumber = (Math.abs(random.nextInt()) % (maxValue - minValue + 1)) + minValue;
                randomArray[i] = randomNumber;
                arrayTotal += randomNumber;
                // The following line of code can be uncommented to display each of the 20 numbers generated. */
                // System.out.print((i + 1) + ") " + randomNumber + "\n");
            }

            // The combined total of the entries in 'arrayTotal' is divided by the number of entries, giving the array's average value.
            double arrayAverage = (double) arrayTotal / randomArray.length;
            System.out.print("After 20 rolls, the average of the integers rolled was " + arrayAverage + "\n");

            // This section allows the user to choose if they want the program to run again.
            System.out.print("\nWould you like to continue? Y/N: ");
            scan = new Scanner(System.in);
            String response = scan.next();
            keepGoing = response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");

        } while (keepGoing);

    }

}