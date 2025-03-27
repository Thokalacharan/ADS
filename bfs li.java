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
