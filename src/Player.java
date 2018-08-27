
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

public class Player extends Pawn {

	public Player() {
		super();
	}

	public Player(Point2D.Float pos, int layer) {
		super(pos, layer);
	}

	@Override
	public void draw(Graphics g, int layer) {
		super.draw(g, layer);
		g.setColor(Color.BLACK);
		g.drawString(health + "", 10, 100);
	}

}
