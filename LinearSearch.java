public class LinearSearch {
    public static int linearSearch(int[] array, int target) {
        // Traverse the array element by element
        for (int i = 0; i < array.length; i++) {
            // If the target is found, return the index
            if (array[i] == target) {
                return i;
            }
        }
        // Return -1 if the target is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60};
        int target = 40;

        System.out.println("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nTarget: " + target);

        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
