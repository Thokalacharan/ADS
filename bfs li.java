import java.util.*;

public class DFSUsingAM {
    public static void dfs(int[][] adjacencyMatrix, boolean[] visited, int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfs(adjacencyMatrix, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        boolean[] visited = new boolean[adjacencyMatrix.length];
        System.out.println("DFS Traversal:");
        dfs(adjacencyMatrix, visited, 0);
    }
}
matrix dfs

  import java.util.*;

public class DFSUsingAL {
    public static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(1).add(4);
        adjacencyList.get(2).add(4);

        boolean[] visited = new boolean[vertices];
        System.out.println("DFS Traversal:");
        dfs(adjacencyList, visited, 0);
    }
}
 list dfs

   import java.util.*;

public class BFSUsingAM {
    public static void bfs(int[][] adjacencyMatrix, int start) {
        int vertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
        };

        bfs(adjacencyMatrix, 0);
    }
}
matrix bfs

  import java.util.*;

public class BFSUsingAL {
    public static void bfs(int vertices, List<List<Integer>> adjacencyList, int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(1).add(4);
        adjacencyList.get(2).add(4);

        bfs(vertices, adjacencyList, 0);
    }
}
list bfs

  import java.util.Arrays;
import java.util.Scanner;

class MaxHeap {
    int[] arr;
    int maxSize, heapSize;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        heapSize = 0;
        arr = new int[maxSize];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int lChild(int i) {
        return 2 * i + 1;
    }

    int rChild(int i) {
        return 2 * i + 2;
    }

    int getMax() {
        return arr[0];
    }

    int curSize() {
        return heapSize;
    }

    void MaxHeapify(int i) {
        int l = lChild(i);
        int r = rChild(i);
        int largest = i;
        if (l < heapSize && arr[l] > arr[i])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(largest);
        }
    }

    void removeMax() {
        if (heapSize <= 0)
            System.out.println("Heap is empty");
        if (heapSize == 1)
            heapSize--;
        else {
            arr[0] = arr[heapSize - 1];
            heapSize--;
            MaxHeapify(0);
        }
    }

    void insertKey(int x) {
        if (heapSize == maxSize) {
            System.out.println("\nOverflow: Could not insertKey\n");
            return;
        }
        int i = heapSize;
        arr[i] = x;
        heapSize++;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);
        int elements[] = {3, 10, 12, 8, 2, 14};

        for (int e : elements)
            h.insertKey(e);
        System.out.println("The current size of the heap is " + h.curSize());
        System.out.println("The current maximum element is " + h.getMax());
        h.removeMax();
        System.out.println("The current size of the heap is " + h.curSize());
        
        // Inserting 2 new keys into the heap.
        h.insertKey(15);
        h.insertKey(5);
        System.out.println("The current size of the heap is " + h.curSize());
        System.out.println("The current maximum element is " + h.getMax());
    }
}


import java.util.Arrays;
class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit; 
    }
}
public class JobScheduling {
    public static void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        boolean[] slots = new boolean[maxDeadline]; // Track occupied slots
        int[] result = new int[maxDeadline]; // Store job sequence
        int totalProfit = 0;
        // Step 2: Assign jobs to available slots
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!slots[j]) { // If slot is free, assign the job
                    slots[j] = true;
                    result[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        // Step 3: Print the job sequence and total profit
        System.out.print("Selected Jobs: ");
        for (int id : result) {
            if (id > 0) {
                System.out.print(id + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };
        scheduleJobs(jobs);
    }
}


import java.util.Arrays;

public class MergeSortStatic {

    private static int[] b; // Auxiliary array for merging

    // MergeSort Method
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    // Merge Method
    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                b[k++] = arr[i++];
            } else {
                b[k++] = arr[j++];
            }
        }

        // Copy remaining elements from the left subset
        while (i <= mid) {
            b[k++] = arr[i++];
        }

        // Copy remaining elements from the right subset
        while (j <= high) {
            b[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        for (int h = low; h <= high; h++) {
            arr[h] = b[h];
        }
    }

    // Main Method
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        b = new int[array.length]; // Initialize auxiliary array

        System.out.println("Original Array: " + Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array (MergeSort): " + Arrays.toString(array));
    }
}



import java.util.Arrays;

public class QuickSortFirstPivot {
    // Method to perform QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // Sort left subarray
            quickSort(arr, pivotIndex + 1, high); // Sort right subarray
        }
    }

    // Partition method with first element as pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Choose first element as pivot
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
                swap(arr, i, j);
            }
        }
        swap(arr, low, j); // Place pivot at its correct position
        return j;
    }

    // Swap method
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test QuickSort
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
public class Knapsack {
    // Method to solve the 0/1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] weights = {2,3,5,7,1,4,1};
        int[] values = {10,5,15,7,6,18,3};
        int capacity = 15;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value that can be achieved: " + maxValue);
    }
}

public class KnapsackBacktracking {

    // Variables to store the maximum value
    private static int maxValue = 0;

    // Method to solve the 0/1 Knapsack problem using Backtracking
    public static void knapsack(int[] weights, int[] values, int capacity, int currentIndex, int currentValue, int currentWeight) {
        // Base case: If the weight exceeds the capacity, return
        if (currentWeight > capacity) {
            return;
        }

        // Update the maximum value
        if (currentValue > maxValue) {
            maxValue = currentValue;
        }

        // If all items are considered, return
        if (currentIndex == weights.length) {
            return;
        }

        // Explore including the current item
        knapsack(weights, values, capacity, currentIndex + 1, currentValue + values[currentIndex], currentWeight + weights[currentIndex]);

        // Explore excluding the current item
        knapsack(weights, values, capacity, currentIndex + 1, currentValue, currentWeight);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4};
        int[] values = {10, 20, 30, 40};
        int capacity = 5;

        knapsack(weights, values, capacity, 0, 0, 0);

        System.out.println("Maximum value that can be achieved: " + maxValue);
    }
}
import java.util.Random;

public class MergeSort {
    // Function to perform MergeSort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver method to test the sorting and measure execution time
    public static void main(String[] args) {
        Random rand = new Random();

        // Average case: Random array
        int[] avgArr = rand.ints(25, 0, 1000).toArray();
        System.out.print("Before Sorting: ");
        displayArray(avgArr); 
        long startTime = System.nanoTime();
        mergeSort(avgArr);
        long endTime = System.nanoTime();
        System.out.println("MergeSort (Average Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(avgArr);
        System.out.println();

        // Worst case: Sorted in descending order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 1000 - i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(worstArr); 
        mergeSort(worstArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Worst Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(worstArr); 
        System.out.println();

        // Best case: Sorted array
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(bestArr);
        mergeSort(bestArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Best Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(bestArr);
    }
}import java.util.Random;

public class MergeSort {
    // Function to perform MergeSort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Function to merge two sorted subarrays
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver method to test the sorting and measure execution time
    public static void main(String[] args) {
        Random rand = new Random();

        // Average case: Random array
        int[] avgArr = rand.ints(25, 0, 1000).toArray();
        System.out.print("Before Sorting: ");
        displayArray(avgArr); 
        long startTime = System.nanoTime();
        mergeSort(avgArr);
        long endTime = System.nanoTime();
        System.out.println("MergeSort (Average Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(avgArr);
        System.out.println();

        // Worst case: Sorted in descending order
        int[] worstArr = new int[25];
        for (int i = 0; i < worstArr.length; i++) {
            worstArr[i] = 1000 - i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(worstArr); 
        mergeSort(worstArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Worst Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(worstArr); 
        System.out.println();

        // Best case: Sorted array
        int[] bestArr = new int[25];
        for (int i = 0; i < bestArr.length; i++) {
            bestArr[i] = i;
        }
        startTime = System.nanoTime();
        System.out.print("Before Sorting: ");
        displayArray(bestArr);
        mergeSort(bestArr);
        endTime = System.nanoTime();
        System.out.println("MergeSort (Best Case) Time: " + (endTime - startTime) + " ns");
        System.out.print("After Sorting: ");
        displayArray(bestArr);
    }
}
