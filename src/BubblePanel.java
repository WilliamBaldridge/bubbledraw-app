import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Random;

public class BubblePanel extends JPanel {

    Random rand = new Random();
    ArrayList<Bubble> bubbleArrayList;
    int size = 25;

    public BubblePanel() {

        bubbleArrayList = new ArrayList<Bubble>();
        setBackground(Color.black);
        // testBubbles();
        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
        addMouseWheelListener(new BubbleListener());
    }

    public void paintComponent(Graphics canvas) {

        super.paintComponent(canvas);
        for (Bubble b : bubbleArrayList) {
            b.draw(canvas);
        }
    }

    public void testBubbles() {
        for (int i = 0; i < 100; i += 1) {
            int x = rand.nextInt(600);
            int y = rand.nextInt(400);
            int size = rand.nextInt(50);
            bubbleArrayList.add(new Bubble(x, y, size));
        }
        repaint();
    }

    private class BubbleListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {

            bubbleArrayList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        public void mouseDragged(MouseEvent e) {

            bubbleArrayList.add(new Bubble(e.getX(), e.getY(), size));
            repaint();
        }

        public void mouseWheelMoved(MouseWheelEvent e) {

            if (size > 3) {
                size += e.getUnitsToScroll();
            } else {
                size = 3;
            }
        }

    }

    private class Bubble {

        private int x;
        private int y;
        private int size;
        private Color color;

        public Bubble(int newX, int newY, int newSize) {
            x = newX;
            y = newY;
            size = newSize;
            color = new Color(
                    rand.nextInt(256),
                    rand.nextInt(256),
                    rand.nextInt(256)
            );
        }

        public void draw(Graphics canvas) {
            canvas.setColor(color);
            canvas.fillOval(x - size / 2, y - size / 2, size, size);
        }


    }

    public static void main(String[] args) {


    }



}
