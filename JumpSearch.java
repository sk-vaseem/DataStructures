import java.util.Arrays;

public class JumpSearch {
    public static int jumpSearch(int[] array, int target) {
        int n = array.length;
        int step = (int) Math.sqrt(n); // Block size to jump

        int prev = 0; // Previous block start index
        while (array[Math.min(step, n) - 1] < target) {
            prev = step; // Move to the next block
            step += (int) Math.sqrt(n);
            if (prev >= n) { // If out of bounds
                return -1;
            }
        }

        // Linear search within the current block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1; // If the target is not found
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 15;

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Target: " + target);

        int index = jumpSearch(array, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
