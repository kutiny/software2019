package src.main.java.lib;

import src.main.java.lib.Observer;

public interface Observable {
  
  public void subscribe(Observer obj);

  public boolean unsubscribe(Observer obj);

  public void next(Object value);


}
