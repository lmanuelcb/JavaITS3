import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ListenerJFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// JButton button = new JButton();
	GameBoard gameBoard = new GameBoard();
	boolean top = true;

	public ListenerJFrame() {
		initUI();
		makeLayout();
		createListeners();
	}

	protected void initUI() {
		this.setSize(400, 200);
		this.setTitle("Super Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	protected void makeLayout() {
		this.getContentPane().setLayout(new BorderLayout());

		// this.getContentPane().add(button, BorderLayout.NORTH);
		this.getContentPane().add(gameBoard, BorderLayout.CENTER);
	}

	protected void createListeners() {
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				onKeyPressedPlayerOne(arg0);

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				onKeyReleasedPlayerOne(arg0);

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				onKeyPressedPlayerTwo(arg0);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				onKeyReleasedPlayerTwo(arg0);
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	protected void onKeyPressedPlayerOne(KeyEvent ke) {

		System.out.println("key Pressed " + ke.getKeyCode() + ke.getKeyChar());
		if (ke.getKeyCode() == 87) {
			gameBoard.movePaddleUpPlayerOne();
		}
		if (ke.getKeyCode() == 83) {
			gameBoard.movePaddleDownPlayerOne();
		}

	}

	protected void onKeyPressedPlayerTwo(KeyEvent be) {

		System.out.println("key Pressed " + be.getKeyCode() + be.getKeyChar());
		if (be.getKeyCode() == 79) {
			gameBoard.movePaddleUpPlayerTwo();
		}
		if (be.getKeyCode() == 76) {
			gameBoard.movePaddleDownPlayerTwo();
		}

	}

	protected void onKeyReleasedPlayerOne(KeyEvent ke) {
	}

	private void onKeyReleasedPlayerTwo(KeyEvent be) {
	}
}
