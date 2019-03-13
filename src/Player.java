
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import trinity.Game;
import trinity.Key;
import trinity.Level;
import trinity.Render;
import trinity.Segment;
import trinity.Twin;

public class Player extends Pawn {

	int test = 0;

	float walkCycle = 0;

	static Segment[] arm = new Segment[8];

	static Segment head = new Segment(Level.images.get("pawn.player.head"));
	static Segment laser = new Segment(Level.images.get("laser"));
	static Segment body = new Segment(Level.images.get("pawn.player.body"));

	static Segment[] leg = new Segment[2];

	static BufferedImage head2 = Level.images.get("crawler.head");

	static BufferedImage[] leg2 = new BufferedImage[2];

	int i = 0;

	public Player() {
		super();
	}

	public Player(Twin pos) {
		super(pos, 0, 0, 1f, 0);
		for (int i = 0; i < 8; i++) {
			arm[i] = new Segment(Level.images.get("pawn.player.arm." + i));
		}
		for (int i = 0; i < 2; i++) {
			leg[i] = new Segment(Level.images.get("pawn.player.leg." + i));
			leg2[i] = Level.images.get("crawler.leg." + i);
		}
	}

	@Override
	public void update() {

		if (pos.x + Render.scroll.getTranslateX() > (Render.getGameSize().x-Render.scrollOffset.x)) {
			Render.scroll.translate((Render.getGameSize().x-Render.scrollOffset.x)-(pos.x + Render.scroll.getTranslateX()), 0);
		}
		if (pos.x + Render.scroll.getTranslateX() < Render.scrollOffset.x) {
			Render.scroll.translate((Render.scrollOffset.x)-(pos.x + Render.scroll.getTranslateX()), 0);
		}
		
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

		vel = pos.getTwordsAmount(target, Math.min(speed.value, 3f));
		move(vel);

		if (Key.getKey("click").pressed) {
//			System.out.println("f");
//			System.out.println();
//			Twin foo = pos.getTwordsAmount(Key.mousePos, 1f);
//			System.out.println(foo);
//			System.out.println(foo.offset(vel));
			// System.out.println(vel.fix());
			Level.newEntities.add(new Bullet(pos.getTwords(Key.mousePos, 10), pos.getTwordsAmount(Key.mousePos, 3)));
			// System.out.println(pos.getTwords(Key.mousePos, 2).x + " " +
			// pos.getTwords(Key.mousePos, 2).y);
			// System.out.println(pos.x + " " + pos.y);
			// System.out.println(pos.getTwordsAmount(Key.mousePos, 1));
		}

		if (pos.distance(target) > 1) {

			walkCycle += speed.value;
		} else {
			walkCycle = 0;
		}
		while (walkCycle > 14) {
			walkCycle -= 14;
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
		if (layer == 1) {
			if (walkCycle == 0) {
				drawSegment(g, leg2[0], new Twin(2, 23), 0);
				drawSegment(g, leg2[0], new Twin(0, 24), 0);
			} else if (walkCycle > 7) {
				drawSegment(g, leg2[0], new Twin(2, 22), 0);
				drawSegment(g, leg2[0], new Twin(0, 24), 0);
			} else {
				drawSegment(g, leg2[0], new Twin(2, 23), 0);
				drawSegment(g, leg2[0], new Twin(0, 23), 0);
			}
			drawSegment(g, leg2[1], new Twin(-3, 23), 0);

			drawSegment(g, head2, new Twin(0, 20), 0);

		}

		if (layer == 3) {

//			if (walkCycle == 0) {
//				drawSegment(g, leg[0], new Twin(-1, 2), 0);
//				drawSegment(g, leg[1], new Twin(2, 2), 0);
//			} else if (walkCycle > 7) {
//				drawSegment(g, leg[0], new Twin(-1, 2), 0);
//				drawSegment(g, leg[1], new Twin(2, 1), 0);
//			} else {
//				drawSegment(g, leg[0], new Twin(-1, 1), 0);
//				drawSegment(g, leg[1], new Twin(2, 2), 0);
//			}
			left = Key.mousePos.x < pos.x;
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

			leg[0].Draw(g, pos, new Twin(-1, walkCycle > 7 ? 3 : 4), left, 0);
			leg[1].Draw(g, pos, new Twin(2, (walkCycle < 7 && walkCycle > 0) ? 3 : 4), left, 0);

			int foo = pos.rotBreak(Key.mousePos, 16, 0f);
			if (foo > 8) {
				foo = Math.abs(foo - 16);
			}

			arm[(foo % 4) + 4].Draw(g, pos, new Twin(3, 0), left, (foo / 4) * 90);
			// System.out.println(pos.rotBreak(Key.mousePos, 16, 0f)*Math.PI*2);
			// drawSegment(g, arm[Math.abs(pos.rotBreak(Key.mousePos, 16, 0f)) % 4 + 4], new
			// Twin(3, -1),
			// pos.rotBreak(Key.mousePos, 16, 0f) / 4);
			body.Draw(g, pos, new Twin(0, 0), left, 0);

			head.Draw(g, pos, new Twin(0, -4), left, 0);
			// Math.PI/100*i++);
			// drawSegment(g, head, new Twin(0, -5), 0);
			arm[foo % 4].Draw(g, pos, new Twin(-2, 0), left, (foo / 4) * 90);
			// (foo/4.0)*90);

			// drawSegment(g, arm[Math.abs(pos.rotBreak(Key.mousePos, 16, 0f)) % 4], new
			// Twin(-2, -1),
			// pos.rotBreak(Key.mousePos, 16, 0f) / 4);

			// Render.DrawChain(g, laser, pos, pos.ix()/10, 0, pos.getRot(Key.mousePos));

			// drawSegment(g, Render.tile(laser.getImage(), 1, 10), new Twin(0,10), 0);

			for (int i = 0; i < 50; i++) {
				// Render.DrawChain(g, laser, pos, Key.mousePos, 1, 0);
			}

			g.setColor(Color.red);

			g.drawString(health + "", 10, 90);
			g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
			g.drawString(health + "", 10, 100);
			if (Game.debug) {
				g.draw(hitbox());
			}

		}
	}

	@Override
	public Shape hitbox() {
		return new Ellipse2D.Double(pos.x - 4, pos.y + 2, 8, 4);
	}

}
