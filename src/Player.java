
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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

	static BufferedImage arm = Level.images.get("player.arm.0");
	static BufferedImage arm1 = Level.images.get("player.arm.1");
	static BufferedImage arm2 = Level.images.get("player.arm.2");
	static BufferedImage arm3 = Level.images.get("player.arm.3");

	static BufferedImage arm4 = Level.images.get("player.arm.4");
	static BufferedImage arm5 = Level.images.get("player.arm.5");
	static BufferedImage arm6 = Level.images.get("player.arm.6");
	static BufferedImage arm7 = Level.images.get("player.arm.7");

	static BufferedImage head = Level.images.get("player.head");
	static BufferedImage body = Level.images.get("player.body");

	static BufferedImage leg0 = Level.images.get("player.leg.0");
	static BufferedImage leg1 = Level.images.get("player.leg.1");

	public Player() {
		super();
	}

	public Player(Twin pos, int layer) {
		super(pos, layer, 0, 0, 1f, 0);
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
		if (pos.distance(target) > 1) {
			walkCycle += speed.value;
		} else {
			walkCycle = 0;
		}
		while (walkCycle > 10) {
			walkCycle -= 10;
		}
		super.update();

	}

	@Override
	public void draw(Graphics2D g, int layer) {
		super.draw(g, layer);

		if (walkCycle == 0) {
			drawSegment(g, leg0, new Twin(-1, 2), 0);
			drawSegment(g, leg1, new Twin(2, 2), 0);
		} else if (walkCycle > 5) {
			drawSegment(g, leg0, new Twin(-1, 2), 0);
			drawSegment(g, leg1, new Twin(2, 1), 0);
		} else {
			drawSegment(g, leg0, new Twin(-1, 1), 0);
			drawSegment(g, leg1, new Twin(2, 2), 0);
		}
		left = Key.mousePos.x < pos.x;

		switch (Math.abs(pos.rotBreak(Key.mousePos, 16, 0f)) % 4) {
		case 0: {
			drawSegment(g, arm4, new Twin(3, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			drawSegment(g, body, new Twin(0, -1), 0);
			drawSegment(g, head, new Twin(0, -5), 0);
			drawSegment(g, arm, new Twin(-2, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			return;
		}
		case 1: {
			drawSegment(g, arm5, new Twin(3, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			drawSegment(g, body, new Twin(0, -1), 0);
			drawSegment(g, head, new Twin(0, -5), 0);
			drawSegment(g, arm1, new Twin(-2, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			return;
		}
		case 2: {
			drawSegment(g, arm6, new Twin(3, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			drawSegment(g, body, new Twin(0, -1), 0);
			drawSegment(g, head, new Twin(0, -5), 0);
			drawSegment(g, arm2, new Twin(-2, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			return;
		}
		case 3: {
			drawSegment(g, arm7, new Twin(3, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			drawSegment(g, body, new Twin(0, -1), 0);
			drawSegment(g, head, new Twin(0, -5), 0);
			drawSegment(g, arm3, new Twin(-2, -1), pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			return;
		}
		}

		// drawSegment(g, inner_arm, new Twin(-2, -1), 0);

		// Render.DrawChain(g, Level.images.get("laser"), pos, Key.mousePos, 0.9f);

		g.drawString(health + "", 10, 100);
	}

}
