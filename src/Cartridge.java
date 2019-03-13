
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import trinity.Game;
import trinity.Key;
import trinity.Level;
import trinity.Render;
import trinity.Tile;
import trinity.Twin;
import trinity.Wall;

public class Cartridge extends trinity.Level {
	

	{

		clear();
		Key.resetKeys();
		Render.fixDisplay(new Dimension(200, 100));

		Game.currentName = "low_battery";
		{
			importImage("pawn/player/arm/0.png");
			importImage("pawn/player/arm/1.png");
			importImage("pawn/player/arm/2.png");
			importImage("pawn/player/arm/3.png");
			importImage("pawn/player/arm/4.png");
			importImage("pawn/player/arm/5.png");
			importImage("pawn/player/arm/6.png");
			importImage("pawn/player/arm/7.png");
			
			importImage("pawn/player/head.png");
			importImage("pawn/player/body.png");
			
			importImage("pawn/player/leg/0.png");
			importImage("pawn/player/leg/1.png");
			

			images.put("crawler.head", Render.loadImage("pawn/crawler/head.png"));

			images.put("crawler.leg.0", Render.loadImage("pawn/crawler/leg_0.png"));
			images.put("crawler.leg.1", Render.loadImage("pawn/crawler/leg_1.png"));
			
			//images.put("player.arm.3", Render.loadImage("pawn/player/arm_3.png"));
			// images.put("player.legs.0", Render.loadImage("pawn/player/outer_arm.png"));
			// images.put("player.legs.1", Render.loadImage("pawn/player/outer_arm.png"));
			// images.put("player.legs.2", Render.loadImage("pawn/player/outer_arm.png"));
		}

		importImage("checker.png");
		importImage("tileset/wall1.png");
		importImage("tileset/wall2.png");
		importImage("tileset/cube1.png");
		importImage("tileset/cube2.png");
		importImage("tileset/cube3.png");
		importImage("tileset/void.png");
		
	
		importImage("pointer_2.png");
		importImage("chain.png");
		importImage("laser.png");
		importImage("bullet1.png");
		
		levels.add(new Level());
		currentLevel = levels.get(0);
		currentLevel.entities.add(new Player(new Twin(50, 50)));
		currentLevel.walls.add(new Wall(new Twin(30, 30), new Twin(10, 10)));
		
		
//		Tile.addTile(new Void(), new Twin(1,0), currentLevel.tiles);
//		Tile.addTile(new Void(), new Twin(2,0), currentLevel.tiles);
//		Tile.addTile(new Void(), new Twin(3,0), currentLevel.tiles);
//		Tile.addTile(new Void(), new Twin(4,0), currentLevel.tiles);
//		
//		
//		Tile.addTile(new Void(), new Twin(0,1), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(1,1), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(2,1), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(3,1), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(4,1), currentLevel.tiles);
//		Tile.addTile(new Void(), new Twin(5,1), currentLevel.tiles);
//		
//		
//		Tile.addTile(new Void(), new Twin(0,2), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(1,2), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(2,2), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(3,2), currentLevel.tiles);
//		Tile.addTile(new Wall1(), new Twin(4,2), currentLevel.tiles);
//		Tile.addTile(new Void(), new Twin(5,2), currentLevel.tiles);
//		
//		Tile.addTile(new Wall2(), new Twin(1,3), currentLevel.tiles);
//		Tile.addTile(new Wall2(), new Twin(2,3), currentLevel.tiles);
//		Tile.addTile(new Wall2(), new Twin(3,3), currentLevel.tiles);
//		Tile.addTile(new Wall2(), new Twin(4,3), currentLevel.tiles);
		
		Tile.update(currentLevel.tiles);
		
		Key.keys.add(new Key(KeyEvent.VK_UP, "up", false));
		Key.keys.add(new Key(KeyEvent.VK_DOWN, "down", false));
		Key.keys.add(new Key(KeyEvent.VK_LEFT, "left", false));
		Key.keys.add(new Key(KeyEvent.VK_RIGHT, "right", false));
		Key.keys.add(new Key(KeyEvent.VK_W, "up_2", false));
		Key.keys.add(new Key(KeyEvent.VK_S, "down_2", false));
		Key.keys.add(new Key(KeyEvent.VK_A, "left_2", false));
		Key.keys.add(new Key(KeyEvent.VK_D, "right_2", false));
		Key.keys.add(new Key(MouseEvent.BUTTON1, "click", true));
		Key.keys.add(new Key(MouseEvent.BUTTON1, "right_click", true));

		Render.canvasLayers = 10;
	}

}
