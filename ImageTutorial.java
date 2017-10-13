import javax.swing.*;
import java.awt.*;

public class ImageTutorial extends JFrame {
    private ImageIcon image1;
    private JLabel label1;
    private ImageIcon image2;
    private JLabel label2;

    ImageTutorial() {
        setLayout(new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("earth.jpg"));

        label1 = new JLabel(image1);
        add(label1);

        image2 = new ImageIcon(getClass().getResource("minion.jpg"));

        label2 = new JLabel(image2);
        add(label2);
    }

    public static void main(String[] args) {
        ImageTutorial gui = new ImageTutorial();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Image Programm");
        gui.setLocationRelativeTo(null);
        gui.setSize(1024,768);
        gui.setVisible(true);
    }
}
