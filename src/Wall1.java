import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Wall1 extends Tile {

	public Wall1(Twin pos) {
		super(pos);
	}

	public Wall1() {
		this(new Twin(0, 0));
	}

	protected static final String[] connectableIds = { null, "wall1", "Wall2" };
	protected static final BufferedImage tileset = Level.images.get("tileset.wall1");
	protected static final String id = "wall1";
	protected static final int size = 16;
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

	public int getSize() {
		return size;
	}

	public int getLayer() {
		return layer;
	}
}
