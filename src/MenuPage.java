import javax.swing.*;

public class MenuPage extends JFrame {

    JButton scheduleButton = new JButton("Access My Schedule");
    JButton addClassesButton = new JButton("Add Classes");
    JButton signOutButton = new JButton("Sign Out");   

    public MenuPage() {
        setTitle("Student Menu");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(scheduleButton);
        panel.add(Box.createVerticalStrut(10));  

        panel.add(addClassesButton);
        panel.add(Box.createVerticalStrut(20));  

        panel.add(signOutButton);

        add(panel);

        addClassesButton.addActionListener(e -> {
            new AddClassesPage();
            dispose();
        });

        scheduleButton.addActionListener(e -> {
            new CheckSchedulePage();
            dispose();
        });

        // ⭐ SIGN OUT LOGIC
        signOutButton.addActionListener(e -> {
            new LogInPage(); 
            dispose();       
        });

        setVisible(true);
    }
}
