import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class AstroidsJFrame extends JFrame {
	private final int SHIPLEFT = 37;
	private final int SHIPRIGHT = 39;
	private final int SHIPTHRUST = 38;
	private final int SHOOT = 32;

	Game game = new Game();

	public AstroidsJFrame() {
		iniUI();
		makeLayout();
		makeListener();
	}

	private void iniUI() {
		this.setSize(400, 200);
		this.setTitle("Asteroids");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	private void makeLayout() {
		GameBoard board = game.getGameBoard();
		this.getContentPane().add(board, BorderLayout.CENTER);
	}

	private void makeListener() {
		this.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				onKeyDown(e);

			}

			public void keyReleased(KeyEvent e) {
				onKeyUp(e);

			}

			public void keyTyped(KeyEvent e) {

			}

		});
	}

	private void onKeyDown(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		if (keyPressed == SHIPLEFT) {
			game.moveShipLeft(true);
		}
		if (keyPressed == SHIPRIGHT) {
			game.moveShipRight(true);
		}
		if (keyPressed == SHIPTHRUST) {
			game.moveShipThrust(true);
		}
		if (keyPressed == SHOOT) {
			game.shoot(true);
		}
	}

	private void onKeyUp(KeyEvent e) {
		int keyReleased = e.getKeyCode();
		if (keyReleased == SHIPLEFT) {
			game.moveShipLeft(false);
		}
		if (keyReleased == SHIPRIGHT) {
			game.moveShipRight(false);
		}
		if (keyReleased == SHIPTHRUST) {
			game.moveShipThrust(false);
		}
		if (keyReleased == SHOOT) {
			game.shoot(false);
		}
	}
}
