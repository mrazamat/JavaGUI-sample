import javax.swing.JFrame;
public class FirstGui extends JFrame{
    public static void main(String[] args) {
        FirstGui gui = new FirstGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200,200);
        gui.setTitle("First GUI");
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

    }

}
