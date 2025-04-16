import java.util.Random;

public class QuickSort {
    // Function to perform QuickSort using first element as pivot
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);  // Sort left half
            quickSort(arr, pi + 1, high); // Sort right half
        }
    }

    // Partition function with first element as pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // First element as pivot
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot with arr[j]
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j; // New pivot position
    }

    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver method to test the sorting and measure execution time
    public static void main(String[] args) {
        Random rand = new Random();

        // Average case: Random array
        int[] avgArr = rand.ints(25, 0, 100).toArray();
        System.out.println("Average Case (Before Sorting):");
        printArray(avgArr);
        long startTime = System.nanoTime();
        quickSort(avgArr, 0, avgArr.length - 1);
        long endTime = System.nanoTime();
        System.out.println("QuickSort (Average Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Average Case (After Sorting):");
        printArray(avgArr);

        // Worst case: Sorted in descending order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 100 - i;
        }
        System.out.println("Worst Case (Before Sorting):");
        printArray(worstArr);
        startTime = System.nanoTime();
        quickSort(worstArr, 0, worstArr.length - 1);
        endTime = System.nanoTime();
        System.out.println("QuickSort (Worst Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Worst Case (After Sorting):");
        printArray(worstArr);

        // Best case: Sorted array
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        System.out.println("Best Case (Before Sorting):");
        printArray(bestArr);
        startTime = System.nanoTime();
        quickSort(bestArr, 0, bestArr.length - 1);
        endTime = System.nanoTime();
        System.out.println("QuickSort (Best Case) Time: " + (endTime - startTime) + " ns");
        System.out.println("Best Case (After Sorting):");
        printArray(bestArr);
    }
}





import java.util.Random;
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

        while (i <= mid) {
            b[k++] = a[i++];
        }

        while (j <= high) {
            b[k++] = a[j++];
        }

        for (int h = low; h <= high; h++) {
            a[h] = b[h];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Random rand = new Random();

        // AVERAGE CASE: Random Array
        int[] avgArr = rand.ints(25, 0, 100).toArray();
                b = new int[avgArr.length];

        System.out.print("Average Case (Before Sorting): ");
        printArray(avgArr);
        long start = System.nanoTime();
        mergeSort(avgArr, 0, avgArr.length - 1);
        long end = System.nanoTime();
        System.out.print("Average Case (After Sorting): ");
        printArray(avgArr);
        System.out.println("Time taken (Average Case): " + (end - start) + " ns\n");

        // WORST CASE: Descending Order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 100 - i;
        }
        b = new int[worstArr.length];
        System.out.print("Worst Case (Before Sorting): ");
        printArray(worstArr);
        start = System.nanoTime();
        mergeSort(worstArr, 0, worstArr.length - 1);
        end = System.nanoTime();
        System.out.print("Worst Case (After Sorting): ");
        printArray(worstArr);
        System.out.println("Time taken (Worst Case): " + (end - start) + " ns\n");

        // BEST CASE: Already Sorted
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        b = new int[bestArr.length];
        System.out.print("Best Case (Before Sorting): ");
        printArray(bestArr);
        start = System.nanoTime();
        mergeSort(bestArr, 0, bestArr.length - 1);
        end = System.nanoTime();
        System.out.print("Best Case (After Sorting): ");
        printArray(bestArr);
        System.out.println("Time taken (Best Case): " + (end - start) + " ns\n");

        
    }
}
