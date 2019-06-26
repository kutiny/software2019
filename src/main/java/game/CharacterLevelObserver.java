package game;

import lib.Observer;

public class CharacterLevelObserver implements Observer {

	private int lastValue;
	
	public CharacterLevelObserver(Character c) {
		c.levelObservable.subscribe(this);
	}
	
	@Override
	public void notifyHandler(Object value) {
		if(value instanceof Integer) {
			this.lastValue = (int) value;
		}
	}
	
	public int getLastValue() {
		return this.lastValue;
	}
}
