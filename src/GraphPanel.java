import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import static javax.swing.text.StyleConstants.setBackground;

public class GraphPanel extends JPanel{
    private WeightedDirectedGraph graph;

    public GraphPanel(WeightedDirectedGraph graph) {
        this.graph = graph;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw edges first (so they appear behind nodes)
        for (Edge edge : graph.getEdges()) {
            edge.draw(g2d);
        }

        // Draw nodes
        for (Node node : graph.getNodes()) {
            node.draw(g2d);
        }

        // Draw title
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("Weighted Directed Graph Visualization", 20, 30);
    }
}
