package helpers;

import helpers.Observer;

public interface Observable {
  
  public void subscribe(Observer obj);

  public boolean unsubscribe(Observer obj);

  public void next(Object value);


}
