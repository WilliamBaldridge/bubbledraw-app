import javax.swing.JFrame;

public class BubbleDraw extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("William's BubbleDraw App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BubblePanel());
        frame.setSize(new java.awt.Dimension(1000,800));
        frame.setVisible(true);

    }



}
