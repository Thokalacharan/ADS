import java.util.*;

class DijkstraList {
    private int vertices;

    public DijkstraList(int vertices) {
        this.vertices = vertices;
    }

    public void dijkstra(List<List<Node>> adjList, int src) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        printDistances(dist, src);
    }

    private void printDistances(int[] dist, int src) {
        System.out.println("Distances from source " + src + " using Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new Node(1, 5));
        adjList.get(0).add(new Node(3, 9));
        adjList.get(1).add(new Node(0, 5));
        adjList.get(1).add(new Node(2, 2));
        adjList.get(1).add(new Node(4, 6));
        adjList.get(2).add(new Node(1, 2));
        adjList.get(2).add(new Node(3, 3));
        adjList.get(3).add(new Node(0, 9));
        adjList.get(3).add(new Node(2, 3));
        adjList.get(3).add(new Node(4, 2));
        adjList.get(4).add(new Node(1, 6));
        adjList.get(4).add(new Node(3, 2));
        adjList.get(4).add(new Node(5, 5));
        adjList.get(5).add(new Node(4, 5));

        DijkstraList dijkstraList = new DijkstraList(vertices);
        dijkstraList.dijkstra(adjList, 0);
    }
}
