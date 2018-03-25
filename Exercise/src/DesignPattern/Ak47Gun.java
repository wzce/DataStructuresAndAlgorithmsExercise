package DesignPattern;
import java.util.*;
public class Ak47Gun extends Gun {
    private static Map<String, Ak47Gun> gunMap = new HashMap<>();
    private static final int maxNum=10;
    private static int num=0;
    public static final List<String> names = new ArrayList<>();
    private String name;
    private Ak47Gun(){}
    private Ak47Gun(String name){
        this.name = name;
    }
    public static synchronized Ak47Gun getInstance(String name){
        Ak47Gun gun=gunMap.get(name);
        if(gun==null && num<maxNum){
            gunMap.put(name,new Ak47Gun(name));
            names.add(name);
            num++;
        }
        return gunMap.get(name);
    }
}
