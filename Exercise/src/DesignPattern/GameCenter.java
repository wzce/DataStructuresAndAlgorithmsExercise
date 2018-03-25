package DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuce wei on 2018/3/21.
 */
public class GameCenter  {

    List<Observer> observerList=new ArrayList<>();

    public void notifyALl() {

    }

    public void register(Observer observer){
        observerList.add(observer);
    }

    public void remove(Observer observer){
        observerList.remove(observer);
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }
}
