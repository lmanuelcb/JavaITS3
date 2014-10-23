import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class EventDetailsJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel numOfTicketsSold = new JLabel("Choose Event");
	JLabel totalEventSold = new JLabel("Choose Event");
	JButton btn_goBack = new JButton("Go Back");
	
	EventDAO eventDAO = new EventDAO();
	
	int b = 1;
	int i = 0;
	
	int numSoldTickets;
	int ticketPrice;
	int totalSold;
	
	ButtonGroup group = new ButtonGroup();
	
	public EventDetailsJFrame(){
		
		initUI();
		placeComponents();
		createListeners();
	}

	private void initUI() {
		this.setSize(375, 300);
		this.setTitle("Event Details");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		
	}

	private void placeComponents() {
		
		JPanel p1 = new JPanel(new GridBagLayout());
		JPanel p2 = new JPanel(new GridBagLayout());
		JPanel p3 = new JPanel(new GridBagLayout());
		
		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(0, 20, 0, 0);
		p1_gbc.anchor = GridBagConstraints.WEST;
	    p1_gbc.fill = GridBagConstraints.BOTH;
		GridBagConstraints p2_gbc = new GridBagConstraints();
		p2_gbc.insets = new Insets(0, 0, 0, 20);
		GridBagConstraints p3_gbc = new GridBagConstraints();
		p3_gbc.insets = new Insets(0, 0, 20, 0);
		
		this.getContentPane().add(p1, BorderLayout.WEST);
		this.getContentPane().add(p2, BorderLayout.EAST);
		this.getContentPane().add(p3, BorderLayout.SOUTH);
		
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(new JLabel("<html><font size=+1>Choose Event</font></html>"));
		
		List<EventClass> event = eventDAO.getAll();
		final JRadioButton[] eventRadioButton = new JRadioButton[50];

		for (final EventClass currentEvent : event) {

				p1_gbc.gridx = 0;
				p1_gbc.gridy = b++;
				i++;
				eventRadioButton[i] = new JRadioButton(currentEvent.getEventName());
				p1.add(eventRadioButton[i], p1_gbc);
				group.add(eventRadioButton[i]);

				eventRadioButton[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						numSoldTickets = currentEvent.getSoldTickets();
						ticketPrice = currentEvent.getNormalPrice();
						totalSold = numSoldTickets * ticketPrice;
						
						numOfTicketsSold.setText("" + numSoldTickets);
						totalEventSold.setText("Û" + totalSold);
						
					}

				});
		
		}
		
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 0;
		p2.add(new JLabel("<html><font size=+1>Num of Tickets Sold</font></html>"), p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 1;
		p2.add(numOfTicketsSold, p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 2;
		p2.add(new JLabel("<html><font size=+1>Total Amount Sold</font></html>"), p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 3;
		p2.add(totalEventSold, p2_gbc);
		
		p3.add(btn_goBack, p3_gbc);

	}

	private void createListeners() {
		
		btn_goBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onClickedGoBack();
				
			}
			
		});
		
	}

	protected void onClickedGoBack() {
		AdminJFrame win = new AdminJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
		
	}

}
