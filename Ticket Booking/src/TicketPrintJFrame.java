import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicketPrintJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TicketSellingSystemJFrame ticket;

	JButton btn_finish = new JButton("Finish");
	JLabel customerName = new JLabel();
	JLabel eventSelected = new JLabel();
	JLabel quantity = new JLabel();
	JLabel transactionId = new JLabel();
	JLabel totalPaid = new JLabel();
	JLabel venue = new JLabel();

	public TicketPrintJFrame() {

		initUI();
		placeComponents();
		createListeners();

	}

	private void initUI() {
		this.setSize(325, 250);
		this.setResizable(true);
		this.setTitle("Ticket Print");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);

	}

	private void placeComponents() {
		JPanel p1 = new JPanel(new GridBagLayout());
		JPanel p2 = new JPanel(new GridBagLayout());
		JPanel p3 = new JPanel(new GridBagLayout());

		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(0, 35, 0, 35);
		GridBagConstraints p2_gbc = new GridBagConstraints();
		p2_gbc.insets = new Insets(0, 35, 0, 35);
		GridBagConstraints p3_gbc = new GridBagConstraints();
		p3_gbc.insets = new Insets(0, 0, 20, 0);

		this.getContentPane().add(p1, BorderLayout.WEST);
		this.getContentPane().add(p2, BorderLayout.EAST);
		this.getContentPane().add(p3, BorderLayout.SOUTH);

		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(new JLabel("<html><font size=+1>Name</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 1;
		p1.add(customerName, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 2;
		p1.add(new JLabel("<html><font size=+1>Event Name</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 3;
		p1.add(eventSelected, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 4;
		p1.add(new JLabel("<html><font size=+1>Quantity</font></html>"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 5;
		p1.add(quantity, p1_gbc);

		p2_gbc.gridx = 0;
		p2_gbc.gridy = 0;
		p2.add(new JLabel("<html><font size=+1>Ticket ID</font></html>"), p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 1;
		p2.add(transactionId, p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 2;
		p2.add(new JLabel("<html><font size=+1>Venue</font></html>"), p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 3;
		p2.add(venue, p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 4;
		p2.add(new JLabel("<html><font size=+1>Total Paid</font></html>"), p2_gbc);
		p2_gbc.gridx = 0;
		p2_gbc.gridy = 5;
		p2.add(totalPaid, p2_gbc);

		p3.add(btn_finish, p3_gbc);

	}

	private void createListeners() {
		btn_finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				onCLickedFinish();

			}

		});

	}

	protected void onCLickedFinish() {
		MainEventJFrame win = new MainEventJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
	}

}
