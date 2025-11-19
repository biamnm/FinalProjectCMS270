import javax.swing.*;

public class MenuPage extends JFrame {

		JButton scheduleButton = new JButton("Access My Schedule");
	    JButton addClassesButton = new JButton("Add Classes");
	    
	    public MenuPage() {
	        setTitle("Student Portal");
	        setSize(300, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        JPanel panel = new JPanel();
	        panel.add(addClassesButton);
	        panel.add(scheduleButton);
	    	
	        add(panel);
	        
	        setVisible(true);
	    }
	    

	}


