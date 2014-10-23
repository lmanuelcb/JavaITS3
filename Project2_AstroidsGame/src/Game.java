import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Game {
	GameBoard gameBoard;
	GameThread gameThread;
	Ship ship;
	Set<Actor> actors;
	Set<Actor> deadActors = new HashSet<Actor>();
	Set<Actor> newActors = new HashSet<Actor>();

	public Game() {
		gameBoard = new GameBoard(this);
		makeActors();
		gameThread = new GameThread(this);
		gameThread.start();
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void moveShipLeft(boolean on) {
		ship.rotateLeft(on);
	}

	public void moveShipRight(boolean on) {
		ship.rotateRight(on);
	}

	public void moveShipThrust(boolean on) {
		ship.thrust(on);
	}

	public void shoot(boolean on) {
		ship.shoot(on);
	}

	public void makeBullet(Point location, double angle) {
		Bullet bullet = new Bullet(location, this, gameBoard);
		bullet.setAngle(angle);
		actors.add(bullet);
	}

	public void tickActors() {
		for (Actor currentActor : actors) {
			currentActor.tick();
			currentActor.checkAllCollision(actors);
		}
		actors.addAll(newActors);
		newActors.clear();
		for (Actor deadActor : deadActors){
			actors.remove(deadActor);
		}
		deadActors.clear();
		
		gameBoard.repaint();
	}

	private void makeActors() {
		actors = new HashSet<Actor>();
		

		Astroid dumby = new Astroid(new Point(50, 50), this, gameBoard);
		actors.add(dumby);
		
		ship = new Ship(new Point(100, 100), this, gameBoard);
		actors.add(ship);
		makeBullet(new Point(40, 40), 1);

	}

	public void drawActors(Graphics g) {
		for (Actor currentActor : actors) {
			currentActor.draw(g);
		}

	}
	
	public void remove(Actor actor){
		deadActors.add(actor);
	}
	
	public void addActor(Actor actor){
		newActors.add(actor);
	}

}
