package niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zuce wei on 2018/3/20.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class KMinNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null || k>input.length || k==0) return new ArrayList<Integer>();
        Queue<Integer> queue = new PriorityQueue<>(input.length);
        for(int i:input){
            queue.offer(i);
        }
        ArrayList<Integer> list=new ArrayList<>(k);
        while (k>0){
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}
