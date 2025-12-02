import javax.swing.*;

public class LogInPage extends JFrame {

    JTextField userField = new JTextField(10);
    JPasswordField passField = new JPasswordField(10);

    JButton loginButton = new JButton("Login");
    JLabel userLabel = new JLabel("Username:");
    JLabel passLabel = new JLabel("Password:");

    public LogInPage() {

        setTitle("Rollins College - Login");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        // Add components to the panel  
        panel.add(userLabel);
        panel.add(userField);

        panel.add(passLabel);
        panel.add(passField);

        panel.add(loginButton);

        add(panel);
        
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("Student") && password.equals("CMS270")) {
                new MenuPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Incorrect username or password.");
            }
        });

        setVisible(true);
    }
    
}
