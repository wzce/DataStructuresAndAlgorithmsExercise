package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Player extends Observer{
    String name;
    protected  State state;
    GameCenter gameCenter;

    List<Observer> teamList=new ArrayList<>();
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void info() {

    }

    public void notifyAllObservers(){
        for (Observer observer : teamList) {
            observer.info();
        }
    }
    public void register(Observer player){
        teamList.add(player);
    }

    public void remove(Observer player){
        teamList.remove(player);
    }

    public void setGameCenter(GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Observer> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Observer> teamList) {
        this.teamList = teamList;
    }
}
