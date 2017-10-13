import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class JavaTextArea extends JFrame {
    private JMenuBar menubar;
    private JMenu file;
    private JMenuItem option;
    private JMenuItem about;
    private JTextField groupName, passwordOptionField,passwordlengthField ;
    private JTextArea textArea;
    private JButton button;
    private JLabel grouplabel, textAreaLabel, label;
    private String login, temp, lastName, nameWithFatherName;
    private String OU = "\n\"OU=TEMP,OU=Students,DC=inyaz,DC=uz\"";
    private String passwordOption;


    public JavaTextArea() {
        setLayout(new FlowLayout());

        menubar = new JMenuBar();
        setJMenuBar(menubar);
        file = new JMenu("File");
        menubar.add(file);
        option = new JMenuItem("Option");
        file.add(option);
        about = new JMenuItem("About");
        file.add(about);
        MyMenuEvent myMenuEvent = new MyMenuEvent();
        option.addActionListener(myMenuEvent);
        about.addActionListener(myMenuEvent);


        grouplabel = new JLabel("Group name");
        add(grouplabel);

        groupName = new JTextField(25);
        add(groupName);

        textAreaLabel = new JLabel("Students name, last name");
        add(textAreaLabel);

        textArea = new JTextArea(25, 25);
        add(textArea);

        JScrollPane scroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll);

        button = new JButton("Generate");
        add(button);

        label = new JLabel("");
        add(label);

        MyEvent e = new MyEvent();
        button.addActionListener(e);
    }

    public class MyMenuEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == about) {
                showAbout();
            } else if (e.getSource() == option) {
                setPasswordOption();
            }
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(null, "This application created by Razakov Azamat", "About me", JOptionPane.INFORMATION_MESSAGE);
    }

    private void setPasswordOption() {
        passwordOption = JOptionPane.showInputDialog(null,
                "Defining a Character Set:");
    }

    public class MyEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String text = textArea.getText();
            if (text.equals("")) {
                label.setText("Please enter some text");
            } else {
                try {
                    PrintWriter writer = new PrintWriter("import_users.csv", "UTF-8");
                    PrintWriter writerLoginPassword = new PrintWriter(getGroupName() + ".txt", "UTF-8");
                    writer.print("OU,CN,GivenName,Initials,SN,DisplayName,SamAccountName,OfficeName,Description,eMail,StreetAddress,L,PostalCode,CO,UPN,Company,Department,ID,Title,Phone,Manager,Password\n");
                    for (String line : textArea.getText().split("\\n")) {
                        line = line.replaceAll("’", "'");
                        line = line.replaceAll("  ", "");
                        line = line.replaceAll("   ", "");
                        String login = getLogin(line);
                        String password = getSaltString();

                        if (getGroupName().equals("null")) {
                            JOptionPane.showMessageDialog(null, "Please enter group name!");
                            break;
                        } else {
                            writer.print(OU + "," + login + "," + getNameFatherName(line) + getLastName(line) + line + "," + login + ",," + getGroupName() + ", " + getEmail(login) + ",,,,," + getSecondEmail(login) + ",,,,,,," + password);
                            writerLoginPassword.println(line + " Login: " + login + " Password: " + password);
                        }
                    }
                    writerLoginPassword.close();
                    writer.close();
                    JOptionPane.showMessageDialog(null, "You CSV genereted!");
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            }
        }
    }

    public static void main(String[] args) {
        JavaTextArea gui = new JavaTextArea();
        gui.setTitle("AD cvn generator");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(330, 570);
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }


    private String getSaltString() {
        String SALTCHARS;
        if (passwordOption == null) {
            SALTCHARS = "ABCDEF123456789";
        } else {
            SALTCHARS = passwordOption;
        }

        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        while (salt.length() < 8) {
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }


    protected String getLogin(String line) {
        String[] arr = line.split(" ");

        login = "";
        temp = "";
        login = (arr[0] + "-");

        login = (login.toLowerCase());
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[0]) {
                continue;
            } else {
                temp += arr[i].charAt(0);
                temp = (temp.toLowerCase());
            }
        }
        login += temp;
        login = login.replaceAll("[^a-zA-Z-]", "");
        return login;
    }

    protected String getGroupName() {
        if (groupName.getText().equals(""))
            return "null";
        return groupName.getText();
    }

    protected String getEmail(String login) {
        return login += "@samdchti.uz";
    }

    protected String getSecondEmail(String login) {
        return login += "@inyaz.uz";
    }

    protected String getLastName(String line) {
        String[] lastNameArr = line.split(" ");
        lastName = "";
        lastName = (lastNameArr[0] + ",");
        return lastName;
    }

    protected String getNameFatherName(String line) {
        String[] nameFatherNameArr = line.split(" ");
        temp = "";
        for (int i = 0; i < nameFatherNameArr.length; i++) {
            if (nameFatherNameArr[i] == nameFatherNameArr[0]) {
                continue;
            } else if (nameFatherNameArr[i] == nameFatherNameArr[nameFatherNameArr.length - 1]) {
                temp += nameFatherNameArr[i];
            } else {
                temp += nameFatherNameArr[i] + " ";
            }
        }
        return temp + ",,";
    }

}
