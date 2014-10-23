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
import javax.swing.JTextField;

public class TicketSellingSystemJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel tf_id = new JLabel();
	JLabel lbl_total = new JLabel("$0");
	JLabel lbl_eventName = new JLabel("Please Select Event");
	JLabel lbl_soldOut = new JLabel();
	JTextField tf_eventName = new JTextField(10);
	JTextField tf_customerName = new JTextField(10);
	JTextField tf_quantity = new JTextField(10);
	JTextField tf_price = new JTextField(10);
	JButton btn_Paid = new JButton("Pay");
	JButton btn_Cancel = new JButton("Cancel");

	EventDAO eventDAO = new EventDAO();
	TicketDAO ticketDAO = new TicketDAO();

	ButtonGroup group = new ButtonGroup();

	int i = 0;
	int b = 1;
	int c = 0;
	int d = 3;

	int transactionId = ticketDAO.getLastSoldId();
	JLabel eventSelected = new JLabel();
	JLabel ticketPrice = new JLabel();
	JLabel venue = new JLabel();

	EventClass event;

	public TicketSellingSystemJFrame() {
		initUI();
		placeComponents();
		createListeners();
	}

	private void initUI() {
		this.setSize(500, 250);
		this.setResizable(true);
		this.setTitle("Buy a Ticket");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);

	}

	private void placeComponents() {

		JPanel p1 = new JPanel(new GridBagLayout());
		JPanel p2 = new JPanel(new GridBagLayout());
		JPanel p3 = new JPanel(new GridBagLayout());
		JPanel p4 = new JPanel(new GridBagLayout());

		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(0, 20, 0, 0);
		GridBagConstraints p2_gbc = new GridBagConstraints();
		GridBagConstraints p3_gbc = new GridBagConstraints();
		p3_gbc.insets = new Insets(0, 0, 0, 20);
		GridBagConstraints p4_gbc = new GridBagConstraints();
		p4_gbc.insets = new Insets(0, 0, 15, 0);

		this.getContentPane().add(p1, BorderLayout.WEST);
		this.getContentPane().add(p2, BorderLayout.CENTER);
		this.getContentPane().add(p3, BorderLayout.EAST);
		this.getContentPane().add(p4, BorderLayout.SOUTH);

		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(new JLabel("<html><font size=+1>Customer Name</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 1;
		p1.add(tf_customerName, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 2;
		p1.add(new JLabel("<html><font size=+1>Quantity</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 3;
		p1.add(tf_quantity, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 4;
		p1.add(new JLabel("<html><font size=+1>Selected Event</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 5;
		p1.add(lbl_eventName, p1_gbc);

		p2_gbc.anchor = 25;
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 0;
		p2.add(new JLabel("<html><font size=+1>Events Available</font></html>"), p2_gbc);

		List<EventClass> event = eventDAO.getAll();
		final JRadioButton[] eventRadioButton = new JRadioButton[50];

		for (final EventClass currentEvent : event) {
			if (currentEvent.getSoldTickets() < currentEvent.getCapacity()) {

				p2_gbc.gridx = 0;
				p2_gbc.gridy = b++;
				i++;
				eventRadioButton[i] = new JRadioButton(currentEvent.getEventName());
				p2.add(eventRadioButton[i], p2_gbc);
				group.add(eventRadioButton[i]);

				eventRadioButton[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						lbl_eventName.setText("<html><b>"
								+ e.getActionCommand() + "</b><br>" 
								+ " $"
								+ currentEvent.getNormalPrice() 
								+ "/Ticket"
								+ "</html>");
						eventSelected.setText(currentEvent.getEventName());
						ticketPrice.setText("" + currentEvent.getNormalPrice());
						venue.setText(currentEvent.getVenue());

						int numOfTickets = Integer.parseInt(tf_quantity
								.getText());
						int eventPrice = currentEvent.getNormalPrice();
						int total = numOfTickets * eventPrice;

						lbl_total.setText("$" + total);

					}

				});
			} else {
				p3_gbc.gridy = d++;
				p3.add(new JLabel("<html>" + currentEvent.getEventName()
						+ "</html>"), p3_gbc);
			}
		}
		p3_gbc.gridx = 0;
		p3_gbc.gridy = 0;
		p3.add(new JLabel("<html><font size=+1>Total</font></html>"), p3_gbc);
		p3_gbc.gridx = 0;
		p3_gbc.gridy = 1;
		p3.add(lbl_total, p3_gbc);
		p3_gbc.gridx = 0;
		p3_gbc.gridy = 2;
		p3.add(new JLabel("<html><font size=+1>Sold Out</font></html>"), p3_gbc);

		p4.add(btn_Paid, p4_gbc);
		p4.add(btn_Cancel, p4_gbc);

	}

	private void createListeners() {
		btn_Paid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickedPayBtn();
			}

		});
	}

	protected void onClickedPayBtn() {
		transactionId++;

		TicketPrintJFrame win = new TicketPrintJFrame();
		win.customerName.setText(this.tf_customerName.getText());
		win.eventSelected.setText(this.eventSelected.getText());
		win.quantity.setText(this.tf_quantity.getText());
		win.totalPaid.setText(this.lbl_total.getText());
		win.transactionId.setText("" + this.transactionId);
		win.venue.setText(this.venue.getText());
		win.setVisible(true);
	
		ticketDAO.create(this);
		eventDAO.updateSoldTickets(this);

		this.setVisible(false);

	}

}
