package objects;

public class Healthbar extends GameObject {

	private int lifes;

	public Healthbar(int lifes) {
		super();
	}

	public void update() {
		throw new UnsupportedOperationException();
	}

	public void render() {
		throw new UnsupportedOperationException();
	}

	public int getLifes() {
		return this.lifes;
	}
}
