package game;

public class DamageType {
	private String name;
	
	public DamageType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
