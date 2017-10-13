import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainClick extends JFrame {
    private JButton jButton;
    private JTextField jTextField;
    private JLabel jLabel;
    private JPanel jPanel;
    private int clickCounter;

    public MainClick() {
        jButton = new JButton("Press Me");
        jTextField = new JTextField("0");
        jLabel = new JLabel("Mouse clicks:");

        JPanel jp = new JPanel(new GridLayout(1, 3));
        jp.add(jLabel);
        jp.add(jTextField);
        jp.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Clicks: " + clickCounter);
                clickCounter = 0;
                jTextField.setText("" + clickCounter);
            }
        });

        jPanel = new JPanel();
        jPanel.setBackground(new Color(0x62D2A6));
        jPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clickCounter++;
                jTextField.setText("" + clickCounter);
            }
        });
        clickCounter = 0;

//        setLayout(new FlowLayout());

        add(jp,BorderLayout.NORTH);
        add(jPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame =new MainClick();
                jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                jFrame.setSize(400,200);
                jFrame.setLocationRelativeTo(null);
                jFrame.setVisible(true);
                JOptionPane.showMessageDialog(jFrame.getContentPane(), "Click on green field! ");
            }
        });
    }
}
