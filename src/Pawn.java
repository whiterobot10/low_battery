
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import trinity.Entity;
import trinity.Game;
import trinity.Level;
import trinity.Stat;
import trinity.StatMod;
import trinity.Twin;

public class Pawn extends trinity.Entity {

	public static BufferedImage image = Level.images.get("checker");
	public static BufferedImage image2 = Level.images.get("pointer2");
	public Twin target = new Twin(0, 0);

	public Pawn() {
		this(new Twin(0, 0), 0, 0, 0, 0);
	}

	Stat speed;
	Stat maxPower;
	Stat maxHealth;
	Stat loot;
	float health;
	float power;

	@Override
	public void update() {
		move(target, Math.min(speed.value, 3f));
		target.x = pos.x;
		target.y = pos.y;

		speed.update();
		maxHealth.update();
		maxPower.update();
		loot.update();
	}

	public Pawn(trinity.Twin pos, float maxHealth, float maxPower, float speed, float loot) {
		super(pos, true);
		target.x = pos.x;
		target.y = pos.y;
		this.speed = new Stat(speed);
		this.maxHealth = new Stat(maxHealth);
		this.maxPower = new Stat(maxHealth);
		this.loot = new Stat(loot);
	}


	public void damage(float amount, String type) {
		amount *= 0.9 + Game.random.nextFloat() / 5;
		health -= amount;
		if (type.equals("power")) {
			loot.addMod(new StatMod((maxHealth.value / amount) / 2, true));
		}
	}

	@Override
	public void draw(Graphics2D g, int layer) {
		if (layer == 2) {
			//drawSegment(g, image);
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
