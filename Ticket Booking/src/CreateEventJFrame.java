import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CreateEventJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tf_name = new JTextField(10);
	JTextField tf_venue = new JTextField(10);
	JTextField tf_capacity = new JTextField(10);
	JTextField tf_normalPrice = new JTextField(10);
	JButton btn_create = new JButton("Create");
	
	EventClass event;
	
	public CreateEventJFrame(){
		initUI();
		placeComponents();
		createListeners();
	}

	private void initUI() {
		this.setSize(160,280);
		this.setResizable(false);
		this.setTitle("Create Event");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void placeComponents() {
		this.getContentPane().setLayout(new FlowLayout());
		
		this.getContentPane().add(new JLabel("Event Name"));
		this.getContentPane().add(tf_name);
		
		this.getContentPane().add(new JLabel("Venue"));
		this.getContentPane().add(tf_venue);
		
		this.getContentPane().add(new JLabel("Capacity"));
		this.getContentPane().add(tf_capacity);
		
		this.getContentPane().add(new JLabel("Price"));
		this.getContentPane().add(tf_normalPrice);
		
		this.getContentPane().add(btn_create);
	}

	private void createListeners() {
		btn_create.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						onCreateClicked();
					}
				});
		
	}
	
	private void onCreateClicked() {
		try{
		String nameString = tf_name.getText().trim();
		String venueString = tf_venue.getText().trim();
		String capacityString = tf_capacity.getText().trim();
		String priceString = tf_normalPrice.getText().trim();
		int soldTickets = 10;
		
		int capacity = (int) Long.parseLong(capacityString);
		int price = (int) Long.parseLong(priceString);
		
		EventClass event = new EventClass(nameString, venueString, capacity, price, soldTickets);
		EventDAO dao = new EventDAO();
		dao.create(event);
		
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Please enter a number");
		}
		
		tf_name.setText("");
		tf_venue.setText("");
		tf_capacity.setText("");
		tf_normalPrice.setText("");
		
	}

}
