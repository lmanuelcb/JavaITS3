import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	Game parentGame;

	public GameBoard(Game parentGame) {
		super();
		this.parentGame = parentGame;
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		parentGame.drawActors(g);
	}
}
