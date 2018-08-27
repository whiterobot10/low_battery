

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.image.BufferedImage;

import trinity.Entity;
import trinity.Game;
import trinity.Level;

public class Pawn extends trinity.Entity {
	
	public static BufferedImage image = Level.images.get("checker");
	
	public Pawn() {
		super(new Point2D.Float(0,0), 0, true);
	}

	float power = 10;
	float health = 10;
	float scrap = 10;

	@Override
	public void update() {

	}

	public Pawn(Point2D.Float pos, int layer) {
		super(pos, layer, true);
	}

	@Override
	public void damage(float amount, String type) {
		amount *= 0.9 + Game.random.nextFloat() / 5;
		health -= amount;
		if (type.equals("power")) {
			scrap -= amount / 2;
		}
	}
	
	@Override
	public void draw(Graphics g, int layer) {
		if (layer == this.layer) {
			drawSegment(g, image, pos);
			if (Game.debug) {
				g.setColor(Color.red);
				Rectangle foo = hitbox.getBounds();
				g.drawRect(foo.x,foo.y,foo.width,foo.height);
				g.setColor(Color.red);
				g.fillRect((int) pos.x - 1, (int) pos.y - 1, 2, 2);
			}
		}
	}
}
