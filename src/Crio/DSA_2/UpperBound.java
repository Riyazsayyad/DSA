package Crio.DSA_2;
import java.util.*;
public class UpperBound {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 13, 21);

// Search for the upper bound of the value 4
        int value = 23;
        int index = Collections.binarySearch(list, value);

// If the value is not in the list, the binary search method
// returns the insertion point as a negative number.
// To get the index of the upper bound, we need to negate the
// insertion point and subtract 1
        if (index < 0) {
            index = -index - 1;
        }

// Print the upper bound of the value
        System.out.println("Upper bound of " + value + ": " + index);

    }
}
