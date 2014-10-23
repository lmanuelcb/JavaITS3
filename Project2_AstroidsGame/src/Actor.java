import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Actor {
	GameBoard gameBoard;
	Game game;
	Point location;
	double vX;
	double vY;

	Polygon vertices;
	List<Point> shape;
	boolean alive = true;

	Team team;

	double angle = 8;
	double angleSpeed = .1;

	public Actor() {

	}

	public Actor(Point location, Game game, GameBoard gameBoard1) {
		this.location = location;
		this.gameBoard = gameBoard1;
		this.game = game;
		team = Team.EMPIRE;
		vX = 2;
		vY = 1;

		makeShape();
		vertices = new Polygon();
		placeShip();
	}

	protected void makeShape() {
		shape = new ArrayList<Point>();
		shape.add(new Point(location.x, location.y));
	}

	protected void placeShip() {
		vertices.reset();
		for (Point currentPoint : shape) {
			int x = currentPoint.x;
			int y = currentPoint.y;

			double sin = Math.sin(angle);
			double cos = Math.cos(angle);

			int newX = (int) Math.round(x * cos - y * sin);
			int newY = (int) Math.round(x * sin + y * cos);

			vertices.addPoint(newX, newY);
		}
		vertices.translate(location.x, location.y);

	}

	public void checkBoardEdges() {

		int x = location.x;
		int y = location.y;

		int boardWidth = gameBoard.getWidth();
		int boardHeight = gameBoard.getHeight();

		int moveX = 0;
		int moveY = 0;

		if (x < 0) {
			moveX = boardWidth;
		}
		if (x > boardWidth) {
			moveX = -boardWidth;
		}
		if (y < 0) {
			moveY = boardHeight;
		}
		if (y > boardHeight) {
			moveY = -boardHeight;
		}
		location.translate(moveX, moveY);

	}

	public void draw(Graphics g) {
		g.drawPolygon(vertices);
	}

	public void tick() {
		location.translate((int) vX, (int) vY);
		checkBoardEdges();
		placeShip();
	}

	public void checkAllCollision(Collection<Actor> Actors) {
		if (alive) {
			for (Actor currentActor : Actors) {
				if (currentActor.checkCollision(this)) {
					currentActor.destroy();
					this.destroy();
				}
			}
		}
	}

	public boolean contains(int x, int y) {
		return vertices.contains(x, y);
	}

	public boolean checkCollision(Actor actor) {
		if (this != actor && this.team != actor.team) {
			for (int i = 0; i < vertices.npoints; i++) {
				if (actor.contains(vertices.xpoints[i], vertices.ypoints[i])) {
					return true;
				}
			}
		}
		return false;
	}

	public void destroy() {
		game.remove(this);
		alive = false;
	}

}
