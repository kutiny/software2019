package observer;

import lib.Observer;

public class CharacterLevelObserver implements Observer {

	private int lastValue;

	public CharacterLevelObserver() {

	}

	@Override
	public void notifyHandler(Object value) {
		try {
			Integer entero = (Integer)value;
			this.lastValue = entero;
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public int getLastValue() {
		return this.lastValue;
	}
}
