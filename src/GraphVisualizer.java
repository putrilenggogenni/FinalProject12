import javax.swing.*;

public class GraphVisualizer {
    public static void main(String[] args) {
        // Example adjacency matrix (0 means no edge)
        double[][] adjacencyMatrix = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        WeightedDirectedGraph graph = new WeightedDirectedGraph(adjacencyMatrix);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Weighted Directed Graph Visualizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new GraphPanel(graph));
            frame.setSize(900, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
