import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Wall2 extends Tile {


	public Wall2() {
		this(0, 0);
	}

	public Wall2(int x, int y) {
		super(x, y);
		size = 16;
		layer = 0;
		tileset=Level.images.get("tileset.wall2");
		connectableIds = new String[1];
		connectableIds[0] = "wall2";
		id = "wall2";
	}

}
