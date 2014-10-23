import java.awt.Point;
import java.util.ArrayList;

public class Ship extends Actor {

	double power = .5;
	int size = 8;
	int coolDownCounter = 0;
	private static final int COOLDOWN = 4;

	boolean rotateLeft = false;
	boolean rotateRight = false;
	boolean thrust = false;
	boolean shoot = false;

	public Ship(Point location, Game game, GameBoard gameBoard1) {
		super(location, game, gameBoard1);
		team = Team.JEDI;
	}

	protected void makeShape() {
		size = 8;
		shape = new ArrayList<Point>();
		shape.add(new Point(size * 2, 0));
		shape.add(new Point(-size * 2, -size));
		shape.add(new Point(-size, 0));
		shape.add(new Point(-size * 2, size));
	}

	@Override
	public void tick() {
		coolDownCounter--;
		if (rotateLeft) {
			angle -= angleSpeed;
		}
		if (rotateRight) {
			angle += angleSpeed;
		}
		if (thrust) {
			vX += power * Math.cos(angle);
			vY += power * Math.sin(angle);
		}
		if (shoot) {
			if (coolDownCounter < 0){
				if (Bullet.isOkToCreateAnother()){
					Point tip = new Point(vertices.xpoints[0], vertices.ypoints[0]);
					Bullet bullet = new Bullet(tip, game, gameBoard);
					bullet.setAngle(angle);
					game.addActor(bullet);
					coolDownCounter = COOLDOWN;
				}
			}
		}
		super.tick();
	}

	public void rotateLeft(boolean on) {
		rotateLeft = on;
	}

	public void rotateRight(boolean on) {
		rotateRight = on;
	}

	public void thrust(boolean on) {
		thrust = on;
	}

	public void shoot(boolean on) {
		shoot = on;
	}
}
