package src.main.java.game;
import src.main.java.lib.Observable;
import src.main.java.lib.Observer;
import java.util.ArrayList;

public class CharacterLifePointsObservable implements Observable {
  
  private ArrayList<Observer> observersList;

  public CharacterLifePointsObservable(){
    this.observersList = new ArrayList();
  }

  public void subscribe(Observer obj){
    this.observersList.add(obj);
  }

  public boolean unsubscribe(Observer obj){
    try {
      this.observersList.remove(this.observersList.indexOf(obj));
      return true;
    }catch(IndexOutOfBoundsException e){
      return false;
    }
  }

  public void next(Object value){
    for(Observer o : this.observersList){
      o.notifyHandler(value);
    }
  }
}