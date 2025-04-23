import java.util.*;

class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; // If the graph is undirected
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = getMinimumDistanceVertex(distances, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != 0 &&
                        distances[u] != Integer.MAX_VALUE &&
                        distances[u] + adjacencyMatrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjacencyMatrix[u][v];
                }
            }
        }

        printSolution(distances);
    }

    private int getMinimumDistanceVertex(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void printSolution(int[] distances) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t" + distances[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 4);

        graph.dijkstra(0);
    }
}
