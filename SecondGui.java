import java.awt.*;
import javax.swing.*;
public class SecondGui extends JFrame{
    private JLabel label;
    private JButton button;
    private JTextField textField;

    public SecondGui(){
//        super("Second GUI");
        setLayout(new FlowLayout());

        label = new JLabel("Hi, I am a label");
        add(label);

        textField = new JTextField(15);
        add(textField);

        button = new JButton("CLICK ME!!!");
        add(button);
    }

    public static void main(String[] args) {
        SecondGui gui = new SecondGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200,125);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}
