package game;

import lib.Observer;

public class CharacterLifeObserver implements Observer {

	private int lastValue;
	
	public CharacterLifeObserver(Character c) {
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