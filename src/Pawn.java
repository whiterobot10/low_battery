
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.image.BufferedImage;

import trinity.Entity;
import trinity.Game;
import trinity.Level;
import trinity.Stat;
import trinity.StatMod;

public class Pawn extends trinity.Entity {

	public static BufferedImage image = Level.images.get("checker");
	public Point2D.Float target = new Point2D.Float(0, 0);

	public Pawn() {
		this(new Point2D.Float(0, 0), 0, 0, 0, 0, 0);
	}

	Stat speed;
	Stat maxPower;
	Stat maxHealth;
	Stat loot;
	float health;
	float power;

	@Override
	public void update() {
		move(target, Math.min(0.1f, 3f));
		target.x = pos.x;
		target.y = pos.y;
		
		speed.update();
		maxHealth.update();
		maxPower.update();
		loot.update();
	}

	public Pawn(Point2D.Float pos, int layer, float maxHealth, float maxPower, float speed, float loot) {
		super(pos, layer, true);
		target.x = pos.x;
		target.y = pos.y;
		this.speed = new Stat(speed);
		this.maxHealth = new Stat(maxHealth);
		this.maxPower = new Stat(maxHealth);
		this.loot = new Stat(loot);
	}

	@Override
	public void damage(float amount, String type) {
		amount *= 0.9 + Game.random.nextFloat() / 5;
		health -= amount;
		if (type.equals("power")) {
			loot.addMod(new StatMod((maxHealth.getValue() / amount) / 2, true));
		}
	}

	@Override
	public void draw(Graphics2D g, int layer) {
		if (layer == this.layer) {
			drawSegment(g, image, pos);
			if (Game.debug) {
				g.setColor(Color.red);
				Rectangle foo = hitbox.getBounds();
				g.drawRect(foo.x, foo.y, foo.width, foo.height);
				g.setColor(Color.red);
				g.fillRect((int) pos.x - 1, (int) pos.y - 1, 2, 2);
			}
		}
	}
}
