import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Register {
    private static Map<String, String> registeredUsers = new HashMap<>();
    private static QuizManager quizManager = new QuizManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("LOGIN AND REGISTRATION");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        String[] roles = {"Admin", "Moderator", "Corporate Moderator", "Student"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(150, 180, 200, 30);
        frame.add(roleComboBox);

        JButton login = new JButton("Log In");
        login.setBounds(150, 220, 200, 50);
        frame.add(login);

        JButton register = new JButton("Register");
        register.setBounds(350, 220, 200, 50);
        frame.add(register);
        register.setEnabled(false);

        roleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRole = (String) roleComboBox.getSelectedItem();
                register.setEnabled(!"Admin".equals(selectedRole));
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedRole = (String) roleComboBox.getSelectedItem();
                String username = JOptionPane.showInputDialog(frame, "Enter your username:");
                String password = JOptionPane.showInputDialog(frame, "Enter your password:");

                if (selectedRole != null && username != null && password != null) {
                    if (selectedRole.equals("Admin")) {
                        showAdminInterface();
                    } else if (registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
                        switch (selectedRole) {
                            case "Moderator":
                                quizManager.showModeratorInterface();
                                break;
                            case "Corporate Moderator":
                                quizManager.showCorporateModeratorInterface();
                                break;
                            case "Student":
                                quizManager.showStudentInterface();
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password. Please register first.");
                    }
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegisterInterface();
            }
        });

        frame.setVisible(true);
    }

    private static void showAdminInterface() {
        JFrame adminFrame = new JFrame("Admin Interface");
        adminFrame.setSize(500, 400);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setLayout(null);

        JLabel adminLabel = new JLabel("WELCOME, ADMIN!");
        adminLabel.setBounds(50, 50, 300, 30);
        adminFrame.add(adminLabel);

        adminFrame.setVisible(true);
    }

    private static void showRegisterInterface() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setSize(600, 500);
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setLayout(null);

        JLabel label1 = new JLabel("Name: ");
        label1.setBounds(50, 50, 200, 30);
        registerFrame.add(label1);

        JTextField field1 = new JTextField();
        field1.setBounds(200, 50, 300, 30);
        registerFrame.add(field1);

        JLabel label2 = new JLabel("Email: ");
        label2.setBounds(50, 100, 200, 30);
        registerFrame.add(label2);

        JTextField field2 = new JTextField();
        field2.setBounds(200, 100, 300, 30);
        registerFrame.add(field2);

        JLabel label3 = new JLabel("Password: ");
        label3.setBounds(50, 150, 200, 30);
        registerFrame.add(label3);

        JPasswordField field3 = new JPasswordField();
        field3.setBounds(200, 150, 300, 30);
        registerFrame.add(field3);

        JLabel label4 = new JLabel("Confirm Password: ");
        label4.setBounds(50, 200, 200, 30);
        registerFrame.add(label4);

        JPasswordField field4 = new JPasswordField();
        field4.setBounds(200, 200, 300, 30);
        registerFrame.add(field4);

        JButton submit = new JButton("Submit");
        submit.setBounds(250, 300, 100, 30);
        registerFrame.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = field1.getText();
                String email = field2.getText();
                String password = new String(field3.getPassword());
                String confirmPassword = new String(field4.getPassword());

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(registerFrame, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(registerFrame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (registeredUsers.containsKey(name)) {
                    JOptionPane.showMessageDialog(registerFrame, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    registeredUsers.put(name, password);
                    JOptionPane.showMessageDialog(registerFrame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    registerFrame.dispose();
                }
            }
        });

        registerFrame.setVisible(true);
    }
}
