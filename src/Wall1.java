import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Wall1 extends Tile {


	public Wall1() {
	}

	protected static final String[] connectableIds = { null, "wall1"};
	protected static final BufferedImage tileset = Level.images.get("tileset.wall1");
	protected static final String id = "wall1";
	protected static final int layer = 0;

	public String[] getConnectableIds() {
		return connectableIds;
	}

	public BufferedImage getImage() {
		return tileset;
	}

	public String getId() {
		return id;
	}


	public int getLayer() {
		return layer;
	}
}
