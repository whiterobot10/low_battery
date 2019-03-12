
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import trinity.Entity;
import trinity.Game;
import trinity.Level;
import trinity.Segment;
import trinity.Twin;

public class Bullet extends trinity.Entity {
	static Segment laser = new Segment(Level.images.get("bullet1"));

	public Bullet() {
		this(new Twin(0, 0), new Twin(0, 0));
	}

	float damage = 1;
	float shock = 0.05f;
	int maxTimer = 100;
	int timer = 0;
	double rotation = 0;

	@Override
	public void update() {
		if (++timer > maxTimer) {
			remove = true;
		}
		if (!move(vel)) {
			pos.move(vel.unit());
			for (Entity e : clsnObjects()) {
				if (e instanceof Pawn) {
					((Pawn) e).damage(damage, shock);
					
				}
			}
			//System.out.println("foo");
			remove = true;
		}

	}

	public Shape hitbox() {
		return new Rectangle(pos.ix() - 2, pos.iy() + 2, 4, 4);
	}

	public Bullet(Twin pos, Twin vel) {
		super(pos, true);
		this.vel = vel;
		solid = false;
		rotation = vel.getRot();
	}

	@Override
	public void draw(Graphics2D g, int layer) {
		if (layer == 2) {
			laser.Draw(g, pos, new Twin(0, 0), true, rotation+90);
			if (Game.debug) {
				g.setColor(Color.red);
				g.draw(hitbox());
				g.setColor(Color.red);
				g.fillRect((int) pos.x - 1, (int) pos.y - 1, 2, 2);
			}
		}
	}
}
