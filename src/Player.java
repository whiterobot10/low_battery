
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;


import trinity.Game;
import trinity.Key;
import trinity.Render;
import trinity.Twin;

public class Player extends Pawn {

	public Player() {
		super();
	}

	public Player(Twin pos, int layer) {
		super(pos, layer, 0, 0, 0.3f, 0);
	}

	@Override
	public void update() {
		if (Key.getKey("up").held) {
			target.y -= 30;
		}
		if (Key.getKey("down").held) {
			target.y += 30;
		}
		if (Key.getKey("left").held) {
			target.x -= 30;
		}
		if (Key.getKey("right").held) {
			target.x += 30;
		}
		super.update();
	}

	@Override
	public void draw(Graphics2D g, int layer) {
		super.draw(g, layer);
		Render.drawImage(g, image2, pos, false, false, 90);
		g.setColor(Color.BLACK);
		g.drawString(health + "", 10, 100);
	}

}
