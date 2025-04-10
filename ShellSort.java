public class ShellSort {
    public static void shellSort(int[] array) {
        int n = array.length;

        // Start with a large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                // Shift elements of the array that are greater than temp
                // to their correct positions
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 34, 54, 2, 3};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        shellSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
