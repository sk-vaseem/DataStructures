import java.util.Arrays;

public class MaxProductArray {
    public static int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Case 1: Maximum product from the largest three numbers
        int case1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Case 2: Maximum product from two smallest negative numbers and the largest number
        int case2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of both cases
        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -10, 5, 2}; // Example input

        int result = maximumProduct(nums);

        System.out.println("Maximum product of three numbers: " + result);
    }
}
