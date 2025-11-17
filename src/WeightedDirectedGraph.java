import java.util.ArrayList;

public class WeightedDirectedGraph {
    private java.util.List<Node> nodes;
    private java.util.List<Edge> edges;
    private double[][] adjacencyMatrix;

    public WeightedDirectedGraph(double[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        buildGraph();
    }

    private void buildGraph() {
        int n = adjacencyMatrix.length;

        // Create nodes in circular layout
        double centerX = 450;
        double centerY = 350;
        double radius = 250;

        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n - Math.PI / 2;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            nodes.add(new Node(i, x, y));
        }

        // Create edges from adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    edges.add(new Edge(nodes.get(i), nodes.get(j), adjacencyMatrix[i][j]));
                }
            }
        }
    }

    public java.util.List<Node> getNodes() { return nodes; }
    public java.util.List<Edge> getEdges() { return edges; }
    public double[][] getAdjacencyMatrix() { return adjacencyMatrix; }
}
