import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class events extends JFrame {
    private JLabel label;
    private JButton button, closeButton;
    private int userChoice;

    public events() {
        setLayout(new FlowLayout());

        button = new JButton("Click for text");
        add(button);

        closeButton = new JButton("Close");
        add(closeButton);

        label = new JLabel("");
        add(label);

        MyEvent e = new MyEvent();

        button.addActionListener(e);
        closeButton.addActionListener(e);
    }

    public class MyEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                label.setText("Now you can see words here");
            }
            else if (e.getSource() == closeButton) {
                userChoice=JOptionPane.showConfirmDialog(null,"Do you want it?");
                if (userChoice == 0) {
                    System.exit(0);
                }
                else if  (userChoice == 1) {
                    label.setText("You are the best man!!!");
                }
                else{
                    label.setText("You canceled!");
                }
            }
        }
    }

    public static void main(String[] args) {
        events gui = new events();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Events Programm");
        gui.setSize(300, 100);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }


}
