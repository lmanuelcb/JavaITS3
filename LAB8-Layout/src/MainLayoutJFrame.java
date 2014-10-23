import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainLayoutJFrame extends JFrame{
	
	JButton btn_1 = new JButton("1");
	JButton btn_2 = new JButton("2");
	JButton btn_3 = new JButton("3");
	JButton btn_4 = new JButton("4");
	JButton btn_5 = new JButton("5");
	
	public MainLayoutJFrame(){
		initUI();
		makeLayout();
		addListeners();
	}
	
	public void initUI(){
		this.setSize(550,200);
		this.setTitle("Playing around with Layouts");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void makeLayout(){
		getContentPane().add(btn_1, BorderLayout.NORTH);
		getContentPane().add(btn_2, BorderLayout.SOUTH);
		getContentPane().add(btn_3, BorderLayout.WEST);
		getContentPane().add(btn_4, BorderLayout.EAST);
		getContentPane().add(btn_5, BorderLayout.CENTER);
	
	}
	
	public void addListeners(){
		btn_1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg1){
						btn1Clicked();
					}
				});
		
		btn_2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg1){
						btn2Clicked();
					}
				});
	}
	
	public void btn1Clicked(){
		System.out.println("btn_1");
		Container mainPane = this.getContentPane();
		mainPane.removeAll();
		mainPane.setLayout(new FlowLayout());
		mainPane.add(btn_1);
		mainPane.add(btn_2);
		mainPane.add(btn_3);
		mainPane.add(btn_4);
		mainPane.add(btn_5);
		this.invalidate();
		this.repaint();
	}
	
	public void btn2Clicked(){
		
	}

}
