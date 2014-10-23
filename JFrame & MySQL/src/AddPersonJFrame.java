import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddPersonJFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tf_id = new JTextField(10);
	JTextField tf_title = new JTextField(10);
	JTextField tf_author = new JTextField(10);
	JButton btn_insert = new JButton("Insert");
	
	public AddPersonJFrame(){
		initUi();
		placeComponents();
		makeListeners();
	}
	public void initUi(){
		this.setSize(550,200);
		this.setTitle("Add Person to the Database");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void placeComponents(){
		this.getContentPane().setLayout(new FlowLayout());
		
		this.getContentPane().add(new JLabel("Id"));
		this.getContentPane().add(tf_id);
		
		this.getContentPane().add(new JLabel("Title"));
		this.getContentPane().add(tf_title);
		
		this.getContentPane().add(new JLabel("Author"));
		this.getContentPane().add(tf_author);
		
		this.getContentPane().add(btn_insert);
	}
	
	public void makeListeners(){
		btn_insert.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						onInsertClicked();
					}
				});
		
	}
	
	public void onInsertClicked(){
		String idString = tf_id.getText().trim();
		try{
			long id = Long.parseLong(idString); 
			String titleString = tf_title.getText().trim();
			
		
			Person person = new Person(id, titleString);
			PersonDao dao = new PersonDao();
			dao.create(person);
		
			System.out.println(person);
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Please enter a number");
		}
		
		tf_id.setText("");
		tf_title.setText("");
		tf_author.setText("");
		
	}
	

}
