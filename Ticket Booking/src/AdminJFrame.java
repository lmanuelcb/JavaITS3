import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btn_eventDetails = new JButton("Event Details");
	JButton btn_searchName = new JButton("Search Customer");
	JButton btn_deleteTransaction = new JButton("Delete Transaction");
	JButton btn_createEvent = new JButton("Create Event");
	JButton btn_cancel = new JButton("Cancel");
	

	public AdminJFrame() {
		initUI();
		placeComponents();
		createListeners();

	}

	private void initUI() {
		this.setSize(200, 300);
		this.setTitle("Admin Area");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);

	}

	private void placeComponents() {
		JPanel p1 = new JPanel(new GridBagLayout());
		JPanel p2 = new JPanel(new GridBagLayout());

		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(3, 0, 3, 0);
		GridBagConstraints p2_gbc = new GridBagConstraints();
		p2_gbc.insets = new Insets(0, 0, 20, 0);

		this.getContentPane().add(p1, BorderLayout.CENTER);
		this.getContentPane().add(p2, BorderLayout.SOUTH);

		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(btn_eventDetails, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 1;
		p1.add(btn_searchName, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 2;
		p1.add(btn_deleteTransaction, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 3;
		p1.add(btn_createEvent, p1_gbc);


		p2_gbc.gridx = 0;
		p2_gbc.gridy = 0;
		p2.add(btn_cancel, p2_gbc);

	}

	private void createListeners() {
		btn_createEvent.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openCreateEventJFrame();
				
			}
			
		});
		
		btn_eventDetails.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickedEventDetails();
				
			}
			
		});
		
		btn_searchName.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickedSearchName();
				
			}
			
		});
	}

	protected void onClickedSearchName() {
		SearchCustomerJFrame win = new SearchCustomerJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
		
	}

	protected void onClickedEventDetails() {
		EventDetailsJFrame win = new EventDetailsJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
		
	}

	protected void openCreateEventJFrame() {
		CreateEventJFrame win = new CreateEventJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
		
	}

}
