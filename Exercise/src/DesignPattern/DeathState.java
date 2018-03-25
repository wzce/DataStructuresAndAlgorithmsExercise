package DesignPattern;

/**
 * Created by zuce wei on 2018/3/21.
 */
public class DeathState extends State{
    public DeathState(State state){}
    public void pause()  //游戏暂停
    {
        //暂停代码省略
        player.setState(new PauseState(this));  //转为暂停状态
    }
    public void start()  //游戏启动
    {
        //游戏程序正在运行中，该方法不可用
    }
    public void beAttacked()  //被攻击
    {
        //其他代码省略
        if(healthPoint<=0)
        {
            player.setState(new DeathState(this));  //转为阵亡状态
        }
    }
    public void shot()  //射击
    {
        //代码省略
    }
    public void move()  //移动
    {
        //代码省略
    }
}
