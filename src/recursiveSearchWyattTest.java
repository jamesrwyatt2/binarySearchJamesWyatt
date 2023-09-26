import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * recursiveSearchWyattTest for searching through array of int to find requested int index
 * @author james wyatt
 */
public class recursiveSearchWyattTest {

    /**
     * recursiveSearchWyatt taking in the below parameters, will recursive call self adjusting start and end point till
     * key is found or start is no longer small then end point
     * @param data original int[]
     * @param key request int to find
     * @param start index start point for search
     * @param end index end point for search
     * @return the found index or if not found returns -1
     */
    public static int recursiveSearchWyatt(int[] data, int key, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;
            System.out.print(remainingElements(data, start, end));
            for (int i = 0; i < middle; i++) {
                System.out.print("   ");
            }
            System.out.println(" * ");
            //If the element is found at the middle
            if (key == data[middle]) {
                return middle; // location is current middle
            } else if (key < data[middle]) { // middle element is too high
                // recursiveSearch end point is middle -1, start point the same
                return recursiveSearchWyatt(data, key, start, middle - 1);
            } else { // middle element is too low
                //recursiveSearch start point is middle plus 1, end point the same
                return recursiveSearchWyatt(data, key, middle + 1, end);
            }
        }
        return -1;
    }

    /**
     *  Prints a line of remaining ints being searched
     * @param data original int[]
     * @param low start index to find
     * @param high end index to find
     * @return returns a string of remaining search ints
     */
    private static String remainingElements(int[] data, int low, int high){
        StringBuilder temporary = new StringBuilder();

        // append spaces for alignment
        for(int i = 0; i < low; i++){
            temporary.append("   ");
        }
        //append elements left in array
        for(int i = low; i<= high; i++) {
            temporary.append(data[i]+" ");
        }

        return String.format("%s%n", temporary);
    }

    /**
     * Main to run application
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        // Create array of 15 random integers in sorted order
        int[] data = generator.ints(15, 10, 91).sorted().toArray();
        System.out.printf("%s%n%n", Arrays.toString(data)); //display array

        // Get input from user
        System.out.print("Please enter an integer value -1 to quit: ");
        int searchInt = input.nextInt();

        // Repeatedly input an integer; -1 terminates the program
        while(searchInt != -1) {
            int location = recursiveSearchWyatt(data, searchInt, 0, data.length-1);

            if(location == -1) { // not found
                System.out.printf("%d was not found%n%n", searchInt);
            }
            else { // found
                System.out.printf("%d was found in position %d%n%n", searchInt, location);
            }

            //Get input from user
            System.out.print("Please enter an integer value -1 to quit: ");
            searchInt = input.nextInt();
        }
    }
}
