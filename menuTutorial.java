import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuTutorial extends JFrame {
    JMenuBar menubar;
    JMenu file;
    JMenuItem exit;

    public menuTutorial() {
        setLayout(new FlowLayout());

        menubar = new JMenuBar();
        setJMenuBar(menubar);

        file = new JMenu("File");
        menubar.add(file);

        exit = new JMenuItem("Exit");
        file.add(exit);

        MyEvent e = new MyEvent();
        exit.addActionListener(e);
    }

    public class MyEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        menuTutorial gui = new menuTutorial();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200,200);
        gui.setVisible(true);
    }
}
