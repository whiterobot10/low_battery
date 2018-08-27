
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.net.MalformedURLException;



import trinity.Game;
import trinity.Key;
import trinity.Level;
import trinity.Render;
import trinity.MenuItem;

public class Cartridge extends trinity.Level {

	{
		clear();
		try {
			Game.getThing("Pawn", "/Users/josh/eclipse-workspace/low_battery/bin/");
			Game.getThing("Player", "/Users/josh/eclipse-workspace/low_battery/bin/");
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		Game.currentName = "low_battery";
		images.put("checker", Render.loadImage("checker.png"));
		levels.put("Menu", new Level());
		currentLevel = levels.get("Menu");
		currentLevel.entities.add(new Player(new Point2D.Float(100, 100), 0));
		Key.keys.add(new Key(KeyEvent.VK_UP, "up", false));
		Key.keys.add(new Key(KeyEvent.VK_DOWN, "down", false));
		Key.keys.add(new Key(KeyEvent.VK_LEFT, "left", false));
		Key.keys.add(new Key(KeyEvent.VK_RIGHT, "right", false));
	}

}
