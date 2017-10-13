import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomGame extends JFrame {
    int randomNum, guess;
    private JButton button;
    private JTextField textField;
    private JLabel promptLabal;
    private JLabel resultLabel;
    private JLabel randomLabel;

    public RandomGame() {
        setLayout(new FlowLayout());
        promptLabal = new JLabel("Enter a random number 1-10");
        add(promptLabal);

        textField = new JTextField(5);
        add(textField);

        button = new JButton("Guess!");
        add(button);

        resultLabel = new JLabel("");
        add(resultLabel);

        randomLabel = new JLabel("");
        add(randomLabel);

        MyEvent e = new MyEvent();
        button.addActionListener(e);
    }

    public class MyEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            randomNum = (int) (Math.random() * 10 + 1);
            try {
                guess = (int) (Double.parseDouble(textField.getText()));
                if (guess == randomNum) {
                    resultLabel.setText("You won the game!");
                } else if (guess != randomNum){
                    resultLabel.setText("You lost the game!");
                }
                randomLabel.setText("The random number generated was: " + randomNum);
            } catch (Exception ex){
                randomLabel.setText("Please enter numbers only!");
            }
        }
    }

    public static void main(String[] args) {
        RandomGame gui = new RandomGame();
        gui.setTitle("Random Number Guessing Game");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300,150);
        gui.setVisible(true);
    }
}
