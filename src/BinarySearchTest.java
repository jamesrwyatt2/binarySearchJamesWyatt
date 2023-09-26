import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {

    public static int binarySearch(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do { // Loop to search for element
            //Print remaining elements of array
            System.out.print(remainingElements(data, low, high));

            //output spaces for alignment
            for (int i = 0; i < middle; i++) {
                System.out.print("  ");
            }
            System.out.println(" * "); // indicates current middle

            //If the element is found at the middle
            if(key == data[middle]){
                location = middle; // location is current middle
            }
            else if (key < data[middle]) {// middle element is too high
                high = middle - 1; // eliminate the higher half
            }
            else {
                low = middle + 1; // eliminate the lower half
            }

            middle = (low + high + 1) / 2; // recalculate the middle
        } while ((low <= high) && (location == -1));

        return location;

    }

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
            int location = binarySearch(data, searchInt);

            if(location == -1) { // not found
                System.out.printf("%d was not found%n%n", searchInt);
            }
            else { // found
                System.out.print("%d was found in position %d%n%n");
            }

            //Get input from user
            System.out.print("Please enter an integer value -1 to quit: ");
            searchInt = input.nextInt();
        }




    }
}
