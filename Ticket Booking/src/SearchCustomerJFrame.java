import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class SearchCustomerJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField tf_customerSearch = new JTextField("Enter Name", 10);
	JButton btn_search = new JButton("Search");
	JButton btn_cancel = new JButton("Cancel");
	
	
	String[] columnNames = { "ID", "Event Name", "Customer Name", "Quantity" };
	DefaultTableModel model = new DefaultTableModel(columnNames,0);
	
	TicketClass ticket;
	TicketDAO ticketDAO = new TicketDAO();
	
	
	
	public SearchCustomerJFrame(){
		
		iniUI();
		placeComponents();
		createListeners();
	}

	private void iniUI() {
		this.setSize(300, 200);
		this.setResizable(true);
		this.setTitle("Search");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		
	}

	private void placeComponents() {
		JPanel p1 = new JPanel(new GridBagLayout());
		JPanel p2 = new JPanel(new GridBagLayout());
		JTable table = new JTable(model);
	
		
		GridBagConstraints p1_gbc = new GridBagConstraints();
		p1_gbc.insets = new Insets(5,0,0,0);
		GridBagConstraints p2_gbc = new GridBagConstraints();
		p2_gbc.insets = new Insets(0,0,20,0);
		
		this.getContentPane().add(p1, BorderLayout.NORTH);
		this.getContentPane().add(p2, BorderLayout.CENTER);
		this.getContentPane().add(table, BorderLayout.SOUTH);
		
		
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 0;
		p1.add(new JLabel("Enter Customer Name"), p1_gbc);
		p1_gbc.gridx = 0;
		p1_gbc.gridy = 1;
		p1.add(tf_customerSearch, p1_gbc);
		
		p2.add(btn_search, p2_gbc);
		p2.add(btn_cancel, p2_gbc);
		
		
		
	
		
		
	}

	private void createListeners() {
		btn_search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onBtnSearchClicked();
				
			}
			
		});
		
		btn_cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				onBtnCancelClicked();
				
			}
			
		});
		
	}

	protected void onBtnSearchClicked() {
		ticketDAO.customerName.setText("" + this.tf_customerSearch.getText());
		
		List<TicketClass> searchList = ticketDAO.searchCustomerName();
		System.out.println(searchList);
		
		
		for (final TicketClass currentTicket : searchList){
			//Object[] rowData = { "" + currentTicket.getId(), currentTicket.getEventName(), currentTicket.getCustomerName(), "" + currentTicket.getQuantity() };
			model.addColumn(new String[]{"ID", "Event Name", "Customer Name", "Quantity"});
			model.addRow(new Object[]{ "" + currentTicket.getId(), currentTicket.getEventName(), currentTicket.getCustomerName(), "" + currentTicket.getQuantity() });
			
		}
		
		
		
		
		
	}

	protected void onBtnCancelClicked() {
		
		AdminJFrame win = new AdminJFrame();
		win.setVisible(true);
		
		this.setVisible(false);
		
	}

}
