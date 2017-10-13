import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Beeper extends JFrame {
    private JLabel label;
    private int counter = 0, x = 0;
    private String s;

    private Beeper() {
        setLayout(new GridLayout(3,3));

        JButton button = new JButton("CLICK FOR SOUND");
        add(button);

        label = new JLabel("");
        add(label);

        MyEvent e = new MyEvent();
        button.addActionListener(e);
    }

    public class MyEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Toolkit.getDefaultToolkit().beep();
            counter++;
            if (x == 0) {
                s = "time";
            } else if (x == 1) {
                s = "times";
            }
            label.setText("You have clicked " + counter + " " + s);
            x = 1;
        }
    }

    public static void main(String[] args) {
        Beeper gui = new Beeper();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(300,200);
        gui.setVisible(true);
        gui.setTitle("Beeper");
        gui.setLocationRelativeTo(null);
    }
}
