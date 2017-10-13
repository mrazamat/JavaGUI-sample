import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    private JButton button1, button2, button3;
    private JLabel label1, label2, label3;

    public Layout(){
        setLayout(new GridLayout(2,3));

        button1 = new JButton("Button 1");
        add(button1);
        label1 = new JLabel("Label 1");
        add(label1);
        button2 = new JButton("Button 2");
        add(button2);
        label2 = new JLabel("Label 2");
        add(label2);
        button3 = new JButton("Button 3");
        add(button3);
        label3 = new JLabel("Label 3");
        add(label3);
    }

    public static void main(String[] args) {
        Layout gui = new Layout();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("A wonderful grid program");

    }
}
