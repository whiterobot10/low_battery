
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import trinity.Entity;
import trinity.Game;
import trinity.Level;
import trinity.Twin;

public class Bullet extends trinity.Entity {
	static BufferedImage head = Level.images.get("player.head");

	public Bullet() {
		this(new Twin(0, 0), new Twin(0, 0));
	}

	float damage = 1;
	float shock = 0.05f;
	int maxTimer = 100;
	int timer = 0;

	@Override
	public void update() {
		if (++timer > maxTimer) {
			remove = true;
		}
		if (!move(vel)) {
			if (vel.x > 0) {
				pos.x++;
			}
			if (vel.x < 0) {
				pos.x--;
			}
			if (vel.y > 0) {
				pos.y++;
			}
			if (vel.y < 0) {
				pos.y--;
			}
			for (Entity e : clsnObjects()) {
				if (e instanceof Pawn) {
					((Pawn) e).damage(damage, shock);
				}
			}
			remove = true;
		}

	}

	public Shape hitbox() {
		return new Rectangle(pos.ix() - 2, pos.iy() - 2, 4, 4);
	}

	public Bullet(Twin pos, Twin vel) {
		super(pos, true);
		this.vel = vel;
		solid = true;
	}

	@Override
	public void draw(Graphics2D g, int layer) {
		if (layer == 2) {
			drawSegment(g, head);
			if (Game.debug) {
				g.setColor(Color.red);
				g.draw(hitbox());
				g.setColor(Color.red);
				g.fillRect((int) pos.x - 1, (int) pos.y - 1, 2, 2);
			}
		}
	}
}
