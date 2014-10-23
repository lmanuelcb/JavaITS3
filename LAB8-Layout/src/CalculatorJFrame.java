import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import javax.swing.plaf.metal.MetalIconFactory;


public class CalculatorJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// components
	JTextField tfDisplay = new JTextField();
	JButton btnPlus = new JButton("+");
	JButton btnMinus = new JButton("-");
	JButton btnMultiply = new JButton("X");
	JButton btnDivide = new JButton("/");
	
	JButton btn1 = new NumberJButton(new MetalIconFactory.TreeFolderIcon() );
	JButton btn2 = new NumberJButton("2");
	JButton btn3 = new NumberJButton("3");
	JButton btn4 = new NumberJButton("4");
	JButton btn5 = new NumberJButton("5");
	JButton btn6 = new NumberJButton("6");
	JButton btn7 = new NumberJButton("7");
	JButton btn8 = new NumberJButton("8");
	JButton btn9 = new NumberJButton("9");
	JButton btn0 = new JButton("0");
	JButton btnEquals = new JButton("=");
	JButton btnDecimal = new JButton(".");
	
	
	public CalculatorJFrame(){
		super();
		initJFrame();
		makeLayout();
		makeListeners();
	}
	public void initJFrame(){
		this.setSize(400, 200);
		this.setTitle("my window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	public void makeLayout(){
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel displayPanel = new JPanel(new GridLayout(1,1));
		JPanel numberPanel = new JPanel(new GridLayout(4,3));
		JPanel operatorPanel = new JPanel(new GridLayout(4,1));
		
		this.getContentPane().add(mainPanel);
		
		mainPanel.setBackground(Color.BLUE);
		mainPanel.add(displayPanel,BorderLayout.NORTH);
		
		displayPanel.setBackground(Color.RED);
		displayPanel.add(tfDisplay);
		tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
		
		mainPanel.add(operatorPanel, BorderLayout.EAST);
		operatorPanel.add(btnPlus);
		operatorPanel.add(btnMinus);
		operatorPanel.add(btnMultiply);
		operatorPanel.add(btnDivide);
		
		mainPanel.add(numberPanel, BorderLayout.CENTER);
		numberPanel.add(btn7);
		numberPanel.add(btn8);
		numberPanel.add(btn9);
		numberPanel.add(btn4);
		numberPanel.add(btn5);
		numberPanel.add(btn6);
		numberPanel.add(btn1);
		numberPanel.add(btn2);
		numberPanel.add(btn3);
		numberPanel.add(btnDecimal);
		numberPanel.add(btn0);
		numberPanel.add(btnEquals);
	}
	public void makeListeners(){
		
	}

}
