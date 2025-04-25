import java.util.*;

class ShortestPathGraph { // Changed class name from 'Graph' to 'ShortestPathGraph'
    private int vertices;
    private List<List<Node>> adjList;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    ShortestPathGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Node(dest, weight));
        adjList.get(dest).add(new Node(src, weight)); // If graph is undirected
    }

    void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        ShortestPathGraph g = new ShortestPathGraph(6); // Updated class name in object creation
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 4, 3);
        g.addEdge(4, 5, 2);

        g.dijkstra(0);
    }
}
