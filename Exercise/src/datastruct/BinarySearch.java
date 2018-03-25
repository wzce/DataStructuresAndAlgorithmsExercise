package datastruct;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zuce wei on 2018/3/22.
 */
public class BinarySearch <T extends Comparable<T>>{
    private Lock lock=new ReentrantLock();
    public  int binarySearch(T[] list,T val){
        lock.lock();
        if(list==null){
            return -1;
        }
        int low=0,hight=list.length-1,mid=0;
        while (low<=hight){
            mid=(low+hight)/2;
            if(val.compareTo(list[mid])>=0){
                low=mid+1;
            }else if(val.compareTo(list[mid])<0){
                hight=mid-1;
            }
        }
        lock.unlock();
        return mid-1;
    }
    
    public static void main(String args[]){

        Integer list[]={1,2,3,4,4,4,4,4,4,5,6,7,8,9,10};
        BinarySearch<Integer> binarySearch=new BinarySearch<>();
        System.out.print(binarySearch.binarySearch(list,4));
        Arrays.sort(list);
    }
}
