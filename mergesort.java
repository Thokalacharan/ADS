import java.util.Scanner;

public class MergeSort {

    private static int[] b; // Auxiliary array for merging

    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        // Copy remaining elements from the left subset
        while (i <= mid) {
            b[k++] = a[i++];
        }

        // Copy remaining elements from the right subset
        while (j <= high) {
            b[k++] = a[j++];
        }

        // Copy the merged elements back into the original array
        for (int h = low; h <= high; h++) {
            a[h] = b[h];
        }
    }

    // Main method to test MergeSort
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        b = new int[n]; // Initialize the auxiliary array

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
