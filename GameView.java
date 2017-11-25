import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.*;

public class GameView {
	private final Grid grid;

    private JPanel canvas;

    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawBg(graphics);

                drawSnake(graphics, grid.getSnake());

                drawFood(graphics, grid.getFood());
            }
        };
    }

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public void draw() {
        Graphics graphics = canvas .getGraphics();
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
        canvas.repaint();
    }

    private int ns = Config.NODE_SIZE;

    private void drawSquare(Graphics graphics, Node node, Color color) {
        graphics.setColor(color);
        graphics.fillRect(node.getX() * ns, node.getY() * ns, ns - 1, ns - 1);
    }

    private void drawCycle(Graphics graphics, Node node, Color color) {
        graphics.setColor(color);
        graphics.fillOval(node.getX() * ns, node.getY() * ns, ns, ns);
    }

    public void drawBg(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0,0, grid.getWidth() * ns, grid.getHeight() * ns);
    }

    /**
     * @param graphics
     * @param snake
     */
    public void drawSnake(Graphics graphics, Snake snake) {
        Color c = Color.red;
        java.util.Iterator<Node> it = snake.getBody().iterator();
        while (it.hasNext()) {
            Node n = it.next();
            drawSquare(graphics, n, c);
        }
    }

    /**
     * 
     * @param graphics
     * @param food
     */
    public void drawFood(Graphics graphics, Node food) {
        drawCycle(graphics, grid.getFood(), Color.green);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(null, "you sucks ", "game over dude", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
