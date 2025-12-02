import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AddClassesPage extends JFrame {

    // Options for each dropdown
    private final String[] options = {"Do nothing", "Add", "Waitlist"};

    // Your actual courses
    private Course[] courses = {
        // name,       days, start, end, seatsLeft
        new Course("Intro to Computer Science",      "MWF", 10*60,    10*60+50, 4),
        new Course("Programming and Software Development",   "TR",  13*60,    14*60+15, 8),
        new Course("Comp Organization & Architecture",      "TR",  14*60,    15*60+15, 0),
        new Course("Artificial Intelligence","MWF", 11*60,    11*60+50,16),
        new Course("Computer Science Capstone",      "TR",  8*60,     9*60+15,  1)
    };

    private JComboBox<String>[] choices;

    public AddClassesPage() {
        setTitle("Add Classes");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        choices = new JComboBox[courses.length];

        for (int i = 0; i < courses.length; i++) {
            JPanel row = new JPanel();
            JLabel label = new JLabel(courses[i].getDisplayText());
            JComboBox<String> combo = new JComboBox<>(options);
            choices[i] = combo;

            row.add(label);
            row.add(combo);

            panel.add(row);
        }

        JButton confirmButton = new JButton("Confirm Selections");
        panel.add(confirmButton);

        add(new JScrollPane(panel));

        // CONFIRM LOGIC
        confirmButton.addActionListener(e -> handleConfirm());

        setVisible(true);
    }

    private void handleConfirm() {
        List<Course> toEnroll = new ArrayList<>();
        List<Course> toWaitlist = new ArrayList<>();

        // Collect selections
        for (int i = 0; i < courses.length; i++) {
            String choice = (String) choices[i].getSelectedItem();
            Course c = courses[i];

            if ("Add".equals(choice)) {
                if (c.seatsLeft <= 0) {
                    JOptionPane.showMessageDialog(this,
                            c.name + " is full. You will be waitlisted instead.");
                    toWaitlist.add(c);
                } else {
                    toEnroll.add(c);
                }
            } else if ("Waitlist".equals(choice)) {
                toWaitlist.add(c);
            }
        }

        // Check conflicts among selected "Add" courses
        for (int i = 0; i < toEnroll.size(); i++) {
            for (int j = i + 1; j < toEnroll.size(); j++) {
                if (StudentSchedule.haveConflict(toEnroll.get(i), toEnroll.get(j))) {
                    JOptionPane.showMessageDialog(this,
                            "Time conflict between:\n" +
                            toEnroll.get(i).name + " and " +
                            toEnroll.get(j).name);
                    return; // stop, do not add anything
                }
            }
        }

        // Check conflicts with already enrolled
        for (Course newCourse : toEnroll) {
            if (StudentSchedule.hasConflictWithEnrolled(newCourse)) {
                JOptionPane.showMessageDialog(this,
                        "Time conflict between:\n" +
                        newCourse.name + " and a class already in your schedule.");
                return;
            }
        }

        // If everything is OK, update global schedule
        StudentSchedule.enrolled.addAll(toEnroll);
        StudentSchedule.waitlisted.addAll(toWaitlist);

        JOptionPane.showMessageDialog(this, "Classes saved!");

        new CheckSchedulePage();
        dispose();
    }
}
