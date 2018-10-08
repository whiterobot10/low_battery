import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Void extends Tile {


	public Void() {
		this(0, 0);
	}

	public Void(int x, int y) {
		super(x, y);
		size = 16;
		layer = 0;
		tileset=Level.images.get("tileset.void");
		connectableIds = new String[0];
		id = "void";
	}
	@Override
	public void draw (Graphics2D g, int level) {
	}

}
