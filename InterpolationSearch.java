import java.util.Arrays;

public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            // Estimate the position of the target using interpolation formula
            int pos = low + ((target - array[low]) * (high - low) / (array[high] - array[low]));

            // If the target is found
            if (array[pos] == target) {
                return pos;
            }

            // If the target is larger, narrow the search range to the upper portion
            if (array[pos] < target) {
                low = pos + 1;
            }
            // If the target is smaller, narrow the search range to the lower portion
            else {
                high = pos - 1;
            }
        }

        return -1; // If the target is not found
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Target: " + target);

        int index = interpolationSearch(array, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
