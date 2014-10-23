import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class MainJFrame extends JFrame{

	JButton btn_1 = new JButton("1");
	int num2 = 0;
	
	JLabel text_1 = new JLabel("");
	
	
	MainJFrame(){
		
		iniUI();
		layoutWindow();
		makeListeners();
		
	}

	private void iniUI() {
		this.setSize(520, 400);
		this.setTitle("This is LAB8b");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layoutWindow() {
		Container mainPane = this.getContentPane();
		mainPane.removeAll();
		mainPane.setLayout(new FlowLayout());
		mainPane.add(btn_1);
		mainPane.add(text_1);
	}
	
	private void makeListeners() {
		btn_1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent arg1){
						btn1Clicked();
					}

					
				});
		btn_1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				onMouseOverButtonEntered();
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				onMouseOverButtonExited();
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
		});
	
	btn_1.addKeyListener(new KeyListener(){

		@Override
		public void keyPressed(KeyEvent arg0) {
			onKeyPressed(arg0);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		
	});
		
	}
	
	protected void onKeyPressed(KeyEvent ke) {
		System.out.println("Key Pressed: " + ke.getKeyCode() + ke.getKeyChar() );
		text_1.setText("" + ke.getKeyChar());
		
		if (ke.getKeyCode()==87){
			text_1.setText("moving ship up");
		}
		if (ke.getKeyCode()==83){
			text_1.setText("moving ship down");
		}
		if (ke.getKeyCode()==68){
			text_1.setText("moving ship rigth");
		}
		if (ke.getKeyCode()==65){
			text_1.setText("moving ship left");
		}
		
	}

	protected void onMouseOverButtonExited() {
		text_1.setBackground(null);
		text_1.setOpaque(true);
		
	}

	protected void onMouseOverButtonEntered() {
		text_1.setBackground(Color.RED);
		text_1.setOpaque(true);
		
	}

	private void btn1Clicked() {
		int i = 1;
		num2 = num2 + i++;
		System.out.println(num2);
		text_1.setText(""+num2);
		
	}
}
