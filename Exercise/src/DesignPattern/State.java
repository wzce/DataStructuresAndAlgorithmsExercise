package DesignPattern;

/**
 * Created by zuce wei on 2018/3/21.
 */
public class State {

    protected Player player;
    protected int healthPoint;

    public void paused(){

    }

    public void beAttacked(){

    }

    public void shot(){

    }

    public void move(){

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}
