import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoard extends JPanel {
	private static final long serialVersionUID = 1L;

	int paddleXPlayerOne = 25;
	int paddleYPlayerOne = 100;
	int paddleWidthPlayerOne = 6;
	int paddleSizePlayerOne = 50;
	int paddleVYPlayerOne = 5;

	int paddleXPlayerTwo = 375;
	int paddleYPlayerTwo = 100;
	int paddleWidthPlayerTwo = 6;
	int paddleSizePlayerTwo = 50;
	int paddleVYPlayerTwo = 5;

	int ballX = 150;
	int ballY = 70;
	int ballVX = -3;
	int ballVY = 1;
	int ballSize = 5;

	int playerOneScore = 0;
	int playerTwoScore = 0;

	public GameBoard() {
		class GameRunnable implements Runnable {
			GameBoard gameboard;

			public GameRunnable(GameBoard b) {
				gameboard = b;

			}

			public void run() {
				while (true) {
					gameboard.moveBall();

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
		Thread thread = new Thread(new GameRunnable(this));
		thread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(paddleXPlayerOne, paddleYPlayerOne, paddleWidthPlayerOne,
				paddleSizePlayerOne);
		g.fillRect(paddleXPlayerTwo, paddleYPlayerTwo, paddleWidthPlayerTwo,
				paddleSizePlayerTwo);

		g.fillOval(ballX, ballY, ballSize, ballSize);

		g.drawString("Player 1 Score: " + playerOneScore, 50, 15);
		g.drawString("Player 2 Score: " + playerTwoScore, 250, 15);
	}

	public void movePaddleUpPlayerOne() {
		paddleYPlayerOne = paddleYPlayerOne - paddleVYPlayerOne;
		if (paddleYPlayerOne + paddleSizePlayerOne < 0) {
			paddleYPlayerOne = this.getHeight();
		}

		this.repaint();

	}

	public void movePaddleUpPlayerTwo() {
		paddleYPlayerTwo = paddleYPlayerTwo - paddleVYPlayerTwo;
		if (paddleYPlayerTwo + paddleSizePlayerTwo < 0) {
			paddleYPlayerTwo = this.getHeight();
		}

		this.repaint();

	}

	public void movePaddleDownPlayerOne() {
		paddleYPlayerOne += paddleVYPlayerOne;

		if (paddleYPlayerOne > this.getHeight()) {
			paddleYPlayerOne = 0 - paddleSizePlayerOne;
		}

		this.repaint();
	}

	public void movePaddleDownPlayerTwo() {
		paddleYPlayerTwo += paddleVYPlayerTwo;

		if (paddleYPlayerTwo > this.getHeight()) {
			paddleYPlayerTwo = 0 - paddleSizePlayerTwo;
		}

		this.repaint();
	}

	public void moveBall() {
		ballX += ballVX;
		ballY += ballVY;

		if (ballX <= 0) {
			playerOneScore = 0;
			ballVX = -ballVX;
		}

		if (ballX + ballSize + 1 > this.getWidth()) {
			ballVX = -ballVX;
		}

		if (ballY < 0) {
			ballVY = -ballVY;
		}

		if (ballY + ballSize + 2 > this.getHeight()) {
			ballVY = -ballVY;
		}

		if (ballVX < 0) {
			if (ballX < paddleXPlayerOne + paddleWidthPlayerOne
					&& ballX - ballVX > paddleXPlayerOne) {
				if (ballY > paddleYPlayerOne
						&& ballY < paddleYPlayerOne + paddleSizePlayerOne) {
					playerOneScore++;
					int bounce = paddleXPlayerOne + paddleWidthPlayerOne
							- ballX;
					ballX = ballX + (2 * bounce);
					ballVX = -ballVX;
				}
			}
		}

		this.repaint();

	}

}
