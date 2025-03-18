import java.util.Arrays;

public class TravellingSalesperson {
    private static final int INF = Integer.MAX_VALUE;

    // Method to find the minimum cost of the TSP using Branch and Bound
    public static int tsp(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true; // Start from the first city

        int minCost = branchAndBound(graph, visited, 0, n, 1, 0, INF);

        return minCost;
    }

    private static int branchAndBound(int[][] graph, boolean[] visited, int currentCity, int n, int count, int cost, int minCost) {
        // If all cities are visited and we are back to the start city
        if (count == n && graph[currentCity][0] > 0) {
            return Math.min(minCost, cost + graph[currentCity][0]);
        }

        // Traverse all the cities to find the minimum cost
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[currentCity][i] > 0) {
                visited[i] = true;
                minCost = branchAndBound(graph, visited, i, n, count + 1, cost + graph[currentCity][i], minCost);
                visited[i] = false; // Backtrack
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        // Example graph representing distances between cities
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int result = tsp(graph);
        System.out.println("The minimum cost of the TSP is: " + result);
    }
}
