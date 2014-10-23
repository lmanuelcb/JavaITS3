import java.awt.Point;
import java.util.ArrayList;

public class Bullet extends Actor {

	double speed = 8;
	int life = 20;
	static int numberOfBullets = 0;
	static final int MAXBULLETS = 5;
	
	public static boolean isOkToCreateAnother(){
		return numberOfBullets < MAXBULLETS;
	}

	public Bullet(Point location, Game game, GameBoard gameBoard1) {
		super(location, game, gameBoard1);
		team = team.JEDI;
		numberOfBullets++;
	}

	protected void makeShape() {

		shape = new ArrayList<Point>();
		shape.add(new Point(1, 0));
		shape.add(new Point(0, 1));
		shape.add(new Point(-1, 0));
		shape.add(new Point(0, -1));

	}

	public void setAngle(double angle) {
		vX = speed * Math.cos(angle);
		vY = speed * Math.sin(angle);
	}

	@Override
	public void tick() {
		life--;
		if (life < 0) {
			this.destroy();
		}
		super.tick();
	}
	@Override
	public void destroy(){
		super.destroy();
		numberOfBullets--;
	}
}
