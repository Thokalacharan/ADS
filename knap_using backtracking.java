public class KnapsackBacktracking {
    static int maxProfit = 0; // To store the maximum profit

    // Method to solve the 0/1 Knapsack problem using backtracking
    public static void knapsack(int[] weights, int[] values, int capacity, int currentIndex, int currentProfit, int currentWeight) {
        // Base case: If we've reached the end of the items
        if (currentIndex == weights.length) {
            // Update maximum profit if the current profit is greater
            maxProfit = Math.max(maxProfit, currentProfit);
            return;
        }

        // Option 1: Exclude the current item
        knapsack(weights, values, capacity, currentIndex + 1, currentProfit, currentWeight);

        // Option 2: Include the current item (if it doesn't exceed capacity)
        if (currentWeight + weights[currentIndex] <= capacity) {
            knapsack(weights, values, capacity, currentIndex + 1,
                    currentProfit + values[currentIndex],
                    currentWeight + weights[currentIndex]);
        }
    }

    public static void main(String[] args) {
        int[] weights = {2,3,4,5};   // Weights of items
        int[] values = {1,2,5,6}; // Values of items
        int capacity = 8;            // Capacity of the knapsack

        // Start backtracking from the first item
        knapsack(weights, values, capacity, 0, 0, 0);

        System.out.println("Maximum value that can be achieved: " + maxProfit);
    }
}
