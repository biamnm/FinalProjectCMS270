import javax.swing.*;
import java.util.Comparator;

public class CheckSchedulePage extends JFrame {

    public CheckSchedulePage() {
        setTitle("My Schedule");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea(12, 30);
        area.setEditable(false);

        StudentSchedule.enrolled.sort(Comparator.comparingInt(c -> c.startMinutes));

        StringBuilder sb = new StringBuilder();
        sb.append("Enrolled Classes:\n");
        if (StudentSchedule.enrolled.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Course c : StudentSchedule.enrolled) {
                sb.append("  - ").append(c.getDisplayText()).append("\n");
            }
        }

        sb.append("\nWaitlisted Classes:\n");
        if (StudentSchedule.waitlisted.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Course c : StudentSchedule.waitlisted) {
                sb.append("  - ").append(c.getDisplayText()).append("  (WAITLISTED)\n");
            }
        }

        area.setText(sb.toString());

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(e -> {
            new MenuPage();
            dispose();
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(area));
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }
}
