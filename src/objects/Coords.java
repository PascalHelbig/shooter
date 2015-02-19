package objects;

public class Coords {

	private float y;
	private float x;

	public Coords(float pos_x, float pos_y) {
		this.y=pos_y;
		this.x=pos_x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

}
