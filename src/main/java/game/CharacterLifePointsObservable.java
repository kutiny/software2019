package game;
import lib.Observable;
import lib.Observer;
import java.util.ArrayList;

public class CharacterLifePointsObservable implements Observable {
  
  private ArrayList<Observer> observersList;

  public CharacterLifePointsObservable(){
    this.observersList = new ArrayList<>();
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
      try {
        o.notifyHandler(value);
      }catch(Exception e){
        return;
      }
    }
  }

  public ArrayList<Observer> getObserversList(){
    return this.observersList;
  }

  public void setObserversList(ArrayList<Observer> observersList){
    this.observersList = observersList;
  }
}