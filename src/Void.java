import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import trinity.Level;
import trinity.Tile;
import trinity.Twin;

public class Void extends Tile {

	protected static final String[] connectableIds = { "null" };
	protected static final String id = "null";
	protected static final int layer = 0;

	public Void() {
	}

	public String[] getConnectableIds() {
		return connectableIds;
	}

	public BufferedImage getImage() {
		return null;
	}

	public String getId() {
		return id;
	}


	public int getLayer() {
		return layer;
	}

	//@Override
//	public void draw(Graphics2D g, int level) {
//	}

}
