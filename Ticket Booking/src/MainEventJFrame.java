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

public class MainEventJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btn_buyTicket = new JButton("Buy a Ticket");
	JButton btn_admin = new JButton("Admin Area");

	public MainEventJFrame() {
		initUI();
		placeComponents();
		createListeners();
	}

	private void initUI() {
		this.setSize(300, 200);
		this.setTitle("Welcome to E-Tickets");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);

	}

	private void placeComponents() {
		JPanel p1 = new JPanel(new GridBagLayout());

		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(0, 0, 10, 0);

		this.getContentPane().add(p1, BorderLayout.CENTER);

		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(btn_buyTicket, p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 1;
		p1.add(btn_admin, p1_gbc);

	}

	private void createListeners() {
		btn_buyTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openBuyTicketJFrame();
			}

		});
		
		btn_admin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openAdminJFrame();
				
			}
			
		});

	}

	protected void openAdminJFrame() {
		AdminJFrame win = new AdminJFrame();
		win.setVisible(true);
		this.setVisible(false);
		
	}

	protected void openBuyTicketJFrame() {
		
		TicketSellingSystemJFrame win1 = new TicketSellingSystemJFrame();
		win1.setVisible(true);
		this.setVisible(false);
		
	}

}
