import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Wall1 extends Tile {


	public Wall1() {
		this(0, 0);
	}

	public Wall1(int x, int y) {
		super(x, y);
		size = 16;
		layer = 0;
		tileset=Level.images.get("tileset.wall1");
		connectableIds = new String[2];
		connectableIds[0] = "wall1";
		connectableIds[1] = null;
		id = "wall1";
	}

}
