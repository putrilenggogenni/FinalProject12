import java.awt.*;
import java.awt.geom.Point2D;

public class Node {
    private int id;
    private Point2D.Double position;
    private static final int RADIUS = 25;

    public Node(int id, double x, double y) {
        this.id = id;
        this.position = new Point2D.Double(x, y);
    }

    public int getId() { return id; }
    public Point2D.Double getPosition() { return position; }
    public int getRadius() { return RADIUS; }

    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(70, 130, 180));
        g2d.fillOval((int)(position.x - RADIUS), (int)(position.y - RADIUS),
                RADIUS * 2, RADIUS * 2);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        String label = String.valueOf(id);
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(label);
        int textHeight = fm.getAscent();
        g2d.drawString(label,
                (int)(position.x - textWidth / 2),
                (int)(position.y + textHeight / 3));
    }
}
