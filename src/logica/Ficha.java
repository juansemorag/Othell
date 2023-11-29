import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ficha extends JComponent {
    private Color color;

    public Ficha(Color color) {
        this.color = color;
        setPreferredSize(new Dimension(50, 50)); // Tamaño predeterminado de la ficha
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(circle);

        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ficha Redonda");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Ficha ficha = new Ficha(Color.BLUE); // Puedes cambiar el color según tus preferencias
            frame.getContentPane().add(ficha);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
