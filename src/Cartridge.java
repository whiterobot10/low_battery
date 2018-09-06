
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import trinity.Game;
import trinity.Key;
import trinity.Level;
import trinity.Render;
import trinity.Twin;
import trinity.Wall;

public class Cartridge extends trinity.Level {

	{
		clear();
		try {
			Game.getThing("Pawn", "/Users/josh/eclipse-workspace/low_battery/bin/");
			Game.getThing("Player", "/Users/josh/eclipse-workspace/low_battery/bin/");
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		Render.fixDisplay(new Dimension(200, 100));

		Game.currentName = "low_battery";
		{
			images.put("player.arm.0", Render.loadImage("pawn/player/arm_0.png"));
			images.put("player.arm.1", Render.loadImage("pawn/player/arm_1.png"));
			images.put("player.arm.2", Render.loadImage("pawn/player/arm_2.png"));
			images.put("player.arm.3", Render.loadImage("pawn/player/arm_3.png"));

			images.put("player.arm.4", Render.loadImage("pawn/player/arm_4.png"));
			images.put("player.arm.5", Render.loadImage("pawn/player/arm_5.png"));
			images.put("player.arm.6", Render.loadImage("pawn/player/arm_6.png"));
			images.put("player.arm.7", Render.loadImage("pawn/player/arm_7.png"));

			images.put("player.head", Render.loadImage("pawn/player/head.png"));
			images.put("player.body", Render.loadImage("pawn/player/body.png"));

			images.put("player.leg.0", Render.loadImage("pawn/player/leg_0.png"));
			images.put("player.leg.1", Render.loadImage("pawn/player/leg_1.png"));
			// images.put("player.legs.0", Render.loadImage("pawn/player/outer_arm.png"));
			// images.put("player.legs.1", Render.loadImage("pawn/player/outer_arm.png"));
			// images.put("player.legs.2", Render.loadImage("pawn/player/outer_arm.png"));
		}

		images.put("checker", Render.loadImage("checker.png"));
		images.put("pointer2", Render.loadImage("pointer.png"));
		images.put("chain", Render.loadImage("chain.png"));
		images.put("laser", Render.loadImage("laser2.png"));
		levels.put("Menu", new Level());
		currentLevel = levels.get("Menu");
		currentLevel.entities.add(new Player(new Twin(50, 50)));
		currentLevel.walls.add(new Wall(new Twin(30, 30), new Twin(100, 10)));
		Key.keys.add(new Key(KeyEvent.VK_UP, "up", false));
		Key.keys.add(new Key(KeyEvent.VK_DOWN, "down", false));
		Key.keys.add(new Key(KeyEvent.VK_LEFT, "left", false));
		Key.keys.add(new Key(KeyEvent.VK_RIGHT, "right", false));
		Key.keys.add(new Key(KeyEvent.VK_W, "up_2", false));
		Key.keys.add(new Key(KeyEvent.VK_S, "down_2", false));
		Key.keys.add(new Key(KeyEvent.VK_A, "left_2", false));
		Key.keys.add(new Key(KeyEvent.VK_D, "right_2", false));

		Render.canvasLayers = 10;
	}

}
