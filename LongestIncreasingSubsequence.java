import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int findLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        // Initialize LIS values for all indices to 1
        Arrays.fill(lis, 1);

        // Compute optimized LIS values in bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Find the maximum value in lis array
        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            if (lis[i] > maxLIS) {
                maxLIS = lis[i];
            }
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80}; // Example input
        int result = findLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}
