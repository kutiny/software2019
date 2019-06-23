package game;

public class Trap {
	private boolean active;
	
	public Trap() {
		this.active = true;
	}
	
	public boolean getActive() {
		return this.active;
	}

	public void setDeactivated() {
		this.active = false;
	}
}
