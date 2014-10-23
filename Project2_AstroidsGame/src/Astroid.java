import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;

public class Astroid extends Actor {

	Random randomGenerator = new Random();
	int size = 3;

	public Astroid(Point location, Game game, GameBoard gameBoard1) {
		this(location,game,gameBoard1,3);
	}

	public Astroid(Point location, Game game, GameBoard gameBoard1, int size) {
		this.location = location;
		this.gameBoard = gameBoard1;
		this.size = size;
		this.game = game;
		team = Team.EMPIRE;
		vX = 2;
		vY = 1;

		makeShape();
		vertices = new Polygon();
		placeShip();
	}

	@Override
	protected void makeShape() {
		
		shape = new ArrayList<Point>();
		shape.add(new Point(6 * size, -1 * size));
		shape.add(new Point(4 * size, -4 * size));
		shape.add(new Point(-4 * size, -4 * size));
		shape.add(new Point(-6 * size, 0 * size));
		shape.add(new Point(-4 * size, 4 * size));
		shape.add(new Point(2 * size, 4 * size));
	}

	@Override
	public void tick() {
		angle -= angleSpeed;
		super.tick();
	}

	@Override
	public void destroy() {
		super.destroy();
		// increment score
		if (size > 1) {
			game.addActor(createChild());

			game.addActor(createChild());

		}
	}

	public Astroid createChild() {
		Astroid a = new Astroid(new Point(location.x, location.y), game,gameBoard,size -1);
		a.vX = randomGenerator.nextInt(7) - 3;
		a.vY = randomGenerator.nextInt(7) - 3;
		return a;
	}

}
