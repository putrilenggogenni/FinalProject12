import java.awt.*;
import java.awt.geom.Point2D;

public class Edge {
    private Node source;
    private Node target;
    private double weight;

    public Edge(Node source, Node target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Node getSource() { return source; }
    public Node getTarget() { return target; }
    public double getWeight() { return weight; }

    public void draw(Graphics2D g2d) {
        Point2D.Double start = source.getPosition();
        Point2D.Double end = target.getPosition();

        // Calculate arrow direction
        double dx = end.x - start.x;
        double dy = end.y - start.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Normalize
        dx /= distance;
        dy /= distance;

        // Adjust start and end to node boundaries
        double startX = start.x + dx * source.getRadius();
        double startY = start.y + dy * source.getRadius();
        double endX = end.x - dx * target.getRadius();
        double endY = end.y - dy * target.getRadius();

        // Draw line
        g2d.setColor(new Color(100, 100, 100));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine((int) startX, (int) startY, (int) endX, (int) endY);

        // Draw arrowhead
        drawArrowhead(g2d, endX, endY, Math.atan2(dy, dx));

        // Draw weight label
        double midX = (startX + endX) / 2;
        double midY = (startY + endY) / 2;
        drawWeightLabel(g2d, midX, midY, weight);
    }
    private void drawArrowhead(Graphics2D g2d, double x, double y, double angle) {
        int arrowSize = 10;
        double angle1 = angle + Math.PI * 3 / 4;
        double angle2 = angle - Math.PI * 3 / 4;

        int x1 = (int)(x + arrowSize * Math.cos(angle1));
        int y1 = (int)(y + arrowSize * Math.sin(angle1));
        int x2 = (int)(x + arrowSize * Math.cos(angle2));
        int y2 = (int)(y + arrowSize * Math.sin(angle2));

        g2d.fillPolygon(new int[]{(int)x, x1, x2}, new int[]{(int)y, y1, y2}, 3);
    }

    private void drawWeightLabel(Graphics2D g2d, double x, double y, double weight) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect((int)x - 15, (int)y - 10, 30, 20);
        g2d.setColor(new Color(200, 50, 50));
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        String weightStr = String.format("%.1f", weight);
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(weightStr);
        g2d.drawString(weightStr, (int)(x - textWidth / 2), (int)(y + 5));
    }
}
