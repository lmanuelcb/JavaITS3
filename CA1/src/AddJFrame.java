import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddJFrame extends JFrame{

	JTextField txt_event_name = new JTextField(20);
	JTextField txt_event_venue = new JTextField(20);
	JTextField txt_event_capacity = new JTextField(20);
	JTextField txt_event_nprice = new JTextField(20);
	JTextField txt_ticket_id = new JTextField(20);
	JTextField txt_ticket_eventname = new JTextField(20);
	JTextField txt_ticket_custname = new JTextField(20);
	JTextField txt_ticket_numbought = new JTextField(20);

	JButton btn_insert = new JButton("insert");


	public AddJFrame(){
		initUi();
		placeComponents();
		makeListeners();
	}

	public void initUi(){
		this.setSize(400, 200);
		this.setTitle("Add a person to the database");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	private void placeComponents() {
		this.getContentPane().setLayout(new FlowLayout());

		this.getContentPane().add(new JLabel("id"));
		this.getContentPane().add(tf_id);

		this.getContentPane().add(new JLabel("name"));
		this.getContentPane().add(tf_name);

		this.getContentPane().add(btn_insert);
	}
	private void makeListeners() {
		btn_insert.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						onInsertClicked();
					}
				});

	}
	public void onInsertClicked(){
		String idString = tf_id.getText().trim();
		try{
			long id = Long.parseLong(idString);
			String name = tf_name.getText().trim();

			Person person = new Person(id, name);

			PersonDao dao = new PersonDao();
			dao.create(person);


			System.out.println(person);
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "please enter a number as id");
		}
		tf_id.setText("");
		tf_name.setText("");
	}
}
