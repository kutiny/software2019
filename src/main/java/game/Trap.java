package game;

public class Trap {
	private boolean active;
	
	public Trap() {
		this.active = true;
	}
	
	public boolean status() {
		return this.active;
	}

	public void deactivate() {
		this.active = false;
	}
}
