
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import trinity.Game;
import trinity.Key;
import trinity.Level;
import trinity.Render;
import trinity.Twin;

public class Player extends Pawn {

	int test = 0;

	float walkCycle = 0;

	static BufferedImage[] arm = new BufferedImage[8];

	static BufferedImage head = Level.images.get("player.head");
	static BufferedImage body = Level.images.get("player.body");

	static BufferedImage[] leg = new BufferedImage[2];

	public Player() {
		super();
	}

	public Player(Twin pos) {
		super(pos, 0, 0, 1f, 0);
		for (int i = 0; i < 8; i++) {
			arm[i] = Level.images.get("player.arm." + i);
		}
		for (int i = 0; i < 2; i++) {
			leg[i] = Level.images.get("player.leg." + i);
		}
	}

	@Override
	public void update() {
		if (Key.getKey("up").held || Key.getKey("up_2").held) {
			target.y -= 30;
		}
		if (Key.getKey("down").held || Key.getKey("down_2").held) {
			target.y += 30;
		}
		if (Key.getKey("left").held || Key.getKey("left_2").held) {
			target.x -= 30;
		}
		if (Key.getKey("right").held || Key.getKey("right_2").held) {
			target.x += 30;
		}
		if (Key.getKey("menu_enter").pressed) {
			test += 1;
		}
		if (pos.distance(target) > 1 && move(target, Math.min(speed.value, 3f))) {
			walkCycle += speed.value;
		} else {
			walkCycle = 0;
		}
		while (walkCycle > 10) {
			walkCycle -= 10;
		}

		target.x = pos.x;
		target.y = pos.y;

		speed.update();
		maxHealth.update();
		maxPower.update();
		loot.update();

	}

	@Override
	public void draw(Graphics2D g, int layer) {
		super.draw(g, layer);
		if (layer == 3) {
			if (walkCycle == 0) {
				drawSegment(g, leg[0], new Twin(-1, 2), 0);
				drawSegment(g, leg[1], new Twin(2, 2), 0);
			} else if (walkCycle > 5) {
				drawSegment(g, leg[0], new Twin(-1, 2), 0);
				drawSegment(g, leg[1], new Twin(2, 1), 0);
			} else {
				drawSegment(g, leg[0], new Twin(-1, 1), 0);
				drawSegment(g, leg[1], new Twin(2, 2), 0);
			}
			left = Key.mousePos.x < pos.x;

			drawSegment(g, arm[Math.abs(pos.rotBreak(Key.mousePos, 16, 0f)) % 4 + 4], new Twin(3, -1),
					pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			drawSegment(g, body, new Twin(0, -1), 0);
			drawSegment(g, head, new Twin(0, -5), 0);
			drawSegment(g, arm[Math.abs(pos.rotBreak(Key.mousePos, 16, 0f)) % 4], new Twin(-2, -1),
					pos.rotBreak(Key.mousePos, 16, 0f) / 4);

			g.setColor(Color.red);
			g.drawString(health + "", 10, 100);
			if (Game.debug) {
				g.draw(hitbox());
			}
		}
	}

	@Override
	public Shape hitbox() {
		return new Ellipse2D.Double(pos.x - 3, pos.y, 6, 4);
	}

}
